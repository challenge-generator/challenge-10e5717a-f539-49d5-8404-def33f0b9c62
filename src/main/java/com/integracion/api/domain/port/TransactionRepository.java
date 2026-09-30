package com.integracion.api.domain.port;

import com.integracion.api.domain.model.Transaction;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import java.util.UUID;

public interface TransactionRepository {
    Mono<Transaction> save(Transaction transaction);
    Mono<Transaction> findById(UUID transactionId);
    Flux<Transaction> findByAccountId(String accountId);
    Flux<Transaction> findByStatus(String status);
    Mono<Void> deleteById(UUID transactionId);
    Mono<Transaction> updateStatus(UUID transactionId, String newStatus);
}