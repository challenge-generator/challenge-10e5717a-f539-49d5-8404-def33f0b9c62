package com.integracion.api.infrastructure.adapter;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.UUID;

@Repository
public class TransactionAdapter implements TransactionRepository {

    private static final Logger log = LoggerFactory.getLogger(TransactionAdapter.class);

    private final WebClient webClient;
    private final String baseUrl;
    private final int maxRetries;
    private final Duration retryDelay;

    public TransactionAdapter(
            WebClient webClient,
            @Value("${external.transaction-service.base-url:http://localhost:8081}") String baseUrl,
            @Value("${external.transaction-service.max-retries:3}") int maxRetries,
            @Value("${external.transaction-service.retry-delay-ms:1000}") long retryDelayMs) {
        this.webClient = webClient;
        this.baseUrl = baseUrl;
        this.maxRetries = maxRetries;
        this.retryDelay = Duration.ofMillis(retryDelayMs);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        return webClient
                .post()
                .uri(baseUrl + "/api/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction saved successfully: {}", result))
                .doOnError(error -> log.error("Failed to save transaction: {}", error.getMessage()))
                .retryWhen(Retry.backoff(maxRetries, retryDelay)
                        .filter(throwable -> throwable instanceof WebClientResponseException.ServiceUnavailable
                                || throwable instanceof WebClientResponseException.GatewayTimeout)
                        .doBeforeRetry(signal -> log.warn("Retrying save transaction, attempt: {}", signal.totalRetries() + 1)));
    }

    @Override
    public Mono<Transaction> findById(UUID transactionId) {
        return webClient
                .get()
                .uri(baseUrl + "/api/v1/transactions/{id}", transactionId)
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction found: {}", result))
                .onErrorResume(WebClientResponseException.NotFound.class,
                        e -> {
                            log.warn("Transaction not found with id: {}", transactionId);
                            return Mono.empty();
                        })
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transaction {}: {}", transactionId, e.getMessage());
                            return Mono.error(e);
                        });
    }

    @Override
    public Flux<Transaction> findByAccountId(String accountId) {
        return webClient
                .get()
                .uri(baseUrl + "/api/v1/transactions/account/{accountId}", accountId)
                .retrieve()
                .bodyToFlux(Transaction.class)
                .doOnComplete(() -> log.info("Retrieved all transactions for account: {}", accountId))
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transactions for account {}: {}", accountId, e.getMessage());
                            return Flux.empty();
                        });
    }

    @Override
    public Flux<Transaction> findByStatus(String status) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(baseUrl + "/api/v1/transactions")
                        .queryParam("status", status)
                        .build())
                .retrieve()
                .bodyToFlux(Transaction.class)
                .doOnComplete(() -> log.info("Retrieved all transactions with status: {}", status))
                .onErrorResume(WebClientResponseException.class,
                        e -> {
                            log.error("Error retrieving transactions by status {}: {}", status, e.getMessage());
                            return Flux.empty();
                        });
    }

    @Override
    public Mono<Void> deleteById(UUID transactionId) {
        return webClient
                .delete()
                .uri(baseUrl + "/api/v1/transactions/{id}", transactionId)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(result -> log.info("Transaction deleted successfully: {}", transactionId))
                .doOnError(error -> log.error("Failed to delete transaction {}: {}", transactionId, error.getMessage()));
    }

    @Override
    public Mono<Transaction> updateStatus(UUID transactionId, String newStatus) {
        return webClient
                .patch()
                .uri(baseUrl + "/api/v1/transactions/{id}/status", transactionId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"status\":\"" + newStatus + "\"}")
                .retrieve()
                .bodyToMono(Transaction.class)
                .doOnSuccess(result -> log.info("Transaction status updated: {} -> {}", transactionId, newStatus))
                .doOnError(error -> log.error("Failed to update transaction status {}: {}", transactionId, error.getMessage()))
                .retryWhen(Retry.backoff(maxRetries, retryDelay)
                        .filter(throwable -> throwable instanceof WebClientResponseException.ServiceUnavailable));
    }
}