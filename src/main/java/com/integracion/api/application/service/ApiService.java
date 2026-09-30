package com.integracion.api.application.service;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class ApiService {

    private static final Logger log = LoggerFactory.getLogger(ApiService.class);
    private static final String DEFAULT_CURRENCY = "USD";
    private static final String DEFAULT_STATUS = "PENDING";

    private final TransactionRepository transactionRepository;
    private final CircuitBreaker externalServiceCircuitBreaker;
    private final Retry externalServiceRetry;

    public ApiService(
            TransactionRepository transactionRepository,
            CircuitBreaker externalServiceCircuitBreaker,
            Retry externalServiceRetry) {
        this.transactionRepository = transactionRepository;
        this.externalServiceCircuitBreaker = externalServiceCircuitBreaker;
        this.externalServiceRetry = externalServiceRetry;
    }

    public Mono<TransactionResponse> createTransaction(TransactionRequest request) {
        log.info("Creating transaction for account: {}, type: {}", 
                request.accountId(), request.transactionType());

        String correlationId = generateCorrelationId();
        LocalDateTime now = LocalDateTime.now();

        Transaction transaction = new Transaction(
                UUID.randomUUID().toString(),
                request.accountId(),
                request.transactionType(),
                request.amount() != null ? request.amount() : BigDecimal.ZERO,
                request.currency() != null ? request.currency() : DEFAULT_CURRENCY,
                DEFAULT_STATUS,
                now,
                request.description(),
                correlationId,
                now,
                now
        );

        return transactionRepository.save(transaction)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction created successfully: {}", result.id()))
                .doOnError(error -> log.error("Failed to create transaction: {}", error.getMessage()));
    }

    public Flux<TransactionResponse> getAllTransactions(String accountId, String status) {
        log.info("Retrieving transactions - accountId: {}, status: {}", accountId, status);

        Flux<Transaction> transactionsFlux;

        if (accountId != null && !accountId.isBlank()) {
            transactionsFlux = transactionRepository.findByAccountId(accountId);
        } else if (status != null && !status.isBlank()) {
            transactionsFlux = transactionRepository.findByStatus(status);
        } else {
            transactionsFlux = Flux.empty();
        }

        return transactionsFlux
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnComplete(() -> log.info("Transactions retrieved successfully"))
                .doOnError(error -> log.error("Failed to retrieve transactions: {}", error.getMessage()));
    }

    public Mono<TransactionResponse> getTransactionById(String transactionId) {
        log.info("Retrieving transaction by ID: {}", transactionId);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.findById(uuid)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction retrieved: {}", transactionId))
                .doOnError(error -> log.error("Failed to retrieve transaction: {}", error.getMessage()));
    }

    public Mono<Void> deleteTransaction(String transactionId) {
        log.info("Deleting transaction: {}", transactionId);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.deleteById(uuid)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction deleted: {}", transactionId))
                .doOnError(error -> log.error("Failed to delete transaction: {}", error.getMessage()));
    }

    public Mono<TransactionResponse> updateTransactionStatus(String transactionId, String newStatus) {
        log.info("Updating transaction status: {} to {}", transactionId, newStatus);

        UUID uuid = UUID.fromString(transactionId);

        return transactionRepository.updateStatus(uuid, newStatus)
                .map(TransactionResponse::fromDomain)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(result -> log.info("Transaction status updated: {}", transactionId))
                .doOnError(error -> log.error("Failed to update transaction status: {}", error.getMessage()));
    }

    public <T> Mono<T> executeWithResilience(Supplier<Mono<T>> operation, String operationName) {
        Supplier<Mono<T>> decoratedSupplier = CircuitBreaker.decorateSupplier(
                externalServiceCircuitBreaker,
                () -> operation.get()
        );

        decoratedSupplier = Retry.decorateSupplier(
                externalServiceRetry,
                decoratedSupplier
        );

        return decoratedSupplier.get()
                .doOnError(error -> log.error("Operation {} failed after retries and circuit breaker: {}", 
                        operationName, error.getMessage()))
                .onErrorResume(error -> Mono.empty());
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    public Mono<Transaction> processExternalTransaction(Transaction transaction) {
        return executeWithResilience(
                () -> {
                    log.info("Processing external transaction: {}", transaction.id());
                    return Mono.just(transaction.withStatus("PROCESSING"));
                },
                "processExternalTransaction"
        );
    }

    public Mono<Boolean> validateExternalService(String serviceEndpoint) {
        return executeWithResilience(
                () -> {
                    log.info("Validating external service: {}", serviceEndpoint);
                    return Mono.just(true);
                },
                "validateExternalService"
        );
    }

    public Mono<Transaction> enrichTransactionWithExternalData(Transaction transaction) {
        return executeWithResilience(
                () -> {
                    log.info("Enriching transaction with external data: {}", transaction.id());
                    return Mono.just(transaction);
                },
                "enrichTransactionWithExternalData"
        );
    }

    public Flux<Transaction> syncTransactionsFromExternalSource(String sourceSystem) {
        log.info("Syncing transactions from external source: {}", sourceSystem);

        return executeWithResilience(
                () -> {
                    log.info("Executing sync from: {}", sourceSystem);
                    return Flux.empty();
                },
                "syncTransactionsFromExternalSource"
        );
    }