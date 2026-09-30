package com.integracion.api.infrastructure.controller;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@Tag(name = "Transacciones", description = "API para gestión de transacciones financieras")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Crear transacción", description = "Crea una nueva transacción en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transacción creada exitosamente",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "createTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> createTransaction(
            @Valid @RequestBody TransactionRequest request) {
        log.info("Creating transaction with type: {} and amount: {}", request.getType(), request.getAmount());

        Transaction transaction = new Transaction(
                UUID.randomUUID(),
                request.getType(),
                request.getAmount(),
                request.getAccountId(),
                request.getDescription(),
                request.getTimestamp(),
                "PENDING"
        );

        return transactionRepository.save(transaction)
                .map(saved -> ResponseEntity.status(HttpStatus.CREATED).body(saved))
                .doOnSuccess(result -> log.info("Transaction created with id: {}", result.getId()))
                .doOnError(error -> log.error("Error creating transaction: {}", error.getMessage()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtener transacción por ID", description = "Recupera una transacción específica por su identificador único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción encontrada",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "getTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> getTransaction(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id) {
        log.info("Fetching transaction with id: {}", id);

        return transactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnSuccess(result -> {
                    if (result.getStatusCode() == HttpStatus.OK) {
                        log.info("Transaction found: {}", id);
                    } else {
                        log.warn("Transaction not found: {}", id);
                    }
                });
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar transacciones por estado", description = "Recupera todas las transacciones que coinciden con el estado especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transacciones",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "listTransactionsByStatusFallback")
    @Retry(name = "transactionService")
    public Flux<Transaction> listTransactionsByStatus(
            @Parameter(description = "Estado de la transacción (PENDING, COMPLETED, FAILED)")
            @RequestParam(required = false) String status) {
        log.info("Listing transactions with status: {}", status);

        Flux<Transaction> transactions = (status != null && !status.isBlank())
                ? transactionRepository.findByStatus(status)
                : transactionRepository.findByStatus("PENDING");

        return transactions
                .doOnComplete(() -> log.info("Transactions listed successfully"))
                .doOnError(error -> log.error("Error listing transactions: {}", error.getMessage()));
    }

    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listar transacciones por cuenta", description = "Recupera todas las transacciones asociadas a una cuenta específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transacciones de la cuenta",
                    content = @Content(implementation = Transaction.class)),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "listTransactionsByAccountFallback")
    @Retry(name = "transactionService")
    public Flux<Transaction> listTransactionsByAccount(
            @Parameter(description = "ID de la cuenta", required = true)
            @PathVariable String accountId) {
        log.info("Listing transactions for account: {}", accountId);

        return transactionRepository.findByAccountId(accountId)
                .doOnComplete(() -> log.info("Transactions for account {} listed successfully", accountId))
                .doOnError(error -> log.error("Error listing transactions for account {}: {}", accountId, error.getMessage()));
    }

    @PatchMapping(value = "/{id}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Actualizar estado de transacción", description = "Actualiza el estado de una transacción existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción actualizada exitosamente",
                    content = @Content(schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "updateTransactionStatusFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Transaction>> updateTransactionStatus(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id,
            @Parameter(description = "Nuevo estado de la transacción", required = true)
            @RequestParam String status) {
        log.info("Updating transaction {} status to: {}", id, status);

        return transactionRepository.updateStatus(id, status)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnSuccess(result -> log.info("Transaction {} status updated to: {}", id, status))
                .doOnError(error -> log.error("Error updating transaction {} status: {}", id, error.getMessage()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar transacción", description = "Elimina una transacción del sistema por su identificador único")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transacción eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @CircuitBreaker(name = "transactionService", fallbackMethod = "deleteTransactionFallback")
    @Retry(name = "transactionService")
    public Mono<ResponseEntity<Void>> deleteTransaction(
            @Parameter(description = "ID único de la transacción", required = true)
            @PathVariable UUID id) {
        log.info("Deleting transaction with id: {}", id);

        return transactionRepository.deleteById(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .doOnSuccess(result -> log.info("Transaction {} deleted successfully", id))
                .doOnError(error -> log.error("Error deleting transaction {}: {}", id, error.getMessage()));
    }

    private Mono<ResponseEntity<Transaction>> createTransactionFallback(TransactionRequest request, Throwable t) {
        log.error("Circuit breaker triggered for createTransaction: {}", t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Mono<ResponseEntity<Transaction>> getTransactionFallback(UUID id, Throwable t) {
        log.error("Circuit breaker triggered for getTransaction({}): {}", id, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Flux<Transaction> listTransactionsByStatusFallback(String status, Throwable t) {
        log.error("Circuit breaker triggered for listTransactionsByStatus({}): {}", status, t.getMessage());
        return Flux.empty();
    }

    private Flux<Transaction> listTransactionsByAccountFallback(String accountId, Throwable t) {
        log.error("Circuit breaker triggered for listTransactionsByAccount({}): {}", accountId, t.getMessage());
        return Flux.empty();
    }

    private Mono<ResponseEntity<Transaction>> updateTransactionStatusFallback(UUID id, String status, Throwable t) {
        log.error("Circuit breaker triggered for updateTransactionStatus({}, {}): {}", id, status, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }

    private Mono<ResponseEntity<Void>> deleteTransactionFallback(UUID id, Throwable t) {
        log.error("Circuit breaker triggered for deleteTransaction({}): {}", id, t.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
    }
}