package com.integracion.api.application.service;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.domain.port.TransactionRepository;
import com.integracion.api.infrastructure.adapter.TransactionAdapter;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApiServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionAdapter transactionAdapter;

    private ApiService apiService;

    private Transaction sampleTransaction;
    private TransactionRequest sampleRequest;
    private TransactionResponse sampleResponse;

    @BeforeEach
    void setUp() {
        apiService = new ApiService(transactionRepository, transactionAdapter);
        
        sampleTransaction = new Transaction(
                UUID.randomUUID(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR",
                "PENDING",
                LocalDateTime.now()
        );
        
        sampleRequest = new TransactionRequest(
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR"
        );
        
        sampleResponse = new TransactionResponse(
                sampleTransaction.transactionId().toString(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("500.00"),
                "EUR",
                "PENDING",
                sampleTransaction.timestamp()
        );
    }

    @Test
    void processTransaction_success_returnsTransaction() {
        when(transactionAdapter.saveTransaction(any(TransactionRequest.class)))
                .thenReturn(Mono.just(sampleResponse));
        when(transactionRepository.save(any(Transaction.class)))
                .thenReturn(Mono.just(sampleTransaction));

        StepVerifier.create(apiService.processTransaction(sampleRequest))
                .expectNextMatches(tx -> tx.transactionId().equals(sampleTransaction.transactionId()))
                .verifyComplete();

        verify(transactionAdapter).saveTransaction(any(TransactionRequest.class));
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    void getTransactionById_success_returnsTransaction() {
        UUID transactionId = sampleTransaction.transactionId();
        
        when(transactionRepository.findById(transactionId))
                .thenReturn(Mono.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionById(transactionId.toString()))
                .expectNextMatches(tx -> tx.transactionId().equals(transactionId))
                .verifyComplete();
    }

    @Test
    void getTransactionsByAccount_success_returnsFluxOfTransactions() {
        String accountId = "ACC123";
        
        when(transactionRepository.findByAccountId(accountId))
                .thenReturn(Flux.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionsByAccount(accountId))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void getTransactionsByStatus_success_returnsFluxOfTransactions() {
        String status = "PENDING";
        
        when(transactionRepository.findByStatus(status))
                .thenReturn(Flux.just(sampleTransaction));

        StepVerifier.create(apiService.getTransactionsByStatus(status))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void updateTransactionStatus_success_returnsUpdatedTransaction() {
        UUID transactionId = sampleTransaction.transactionId();
        String newStatus = "COMPLETED";
        Transaction updatedTransaction = sampleTransaction.withStatus(newStatus);
        
        when(transactionRepository.updateStatus(transactionId, newStatus))
                .thenReturn(Mono.just(updatedTransaction));

        StepVerifier.create(apiService.updateTransactionStatus(transactionId.toString(), newStatus))
                .expectNextMatches(tx -> tx.status().equals(newStatus))
                .verifyComplete();
    }

    @Test
    void deleteTransaction_success_completes() {
        UUID transactionId = sampleTransaction.transactionId();
        
        when(transactionRepository.deleteById(transactionId))
                .thenReturn(Mono.empty());

        StepVerifier.create(apiService.deleteTransaction(transactionId.toString()))
                .verifyComplete();

        verify(transactionRepository).deleteById(transactionId);
    }

    @Test
    void processTransaction_adapterFails_propagatesError() {
        when(transactionAdapter.saveTransaction(any(TransactionRequest.class)))
                .thenReturn(Mono.error(new RuntimeException("External service error")));

        StepVerifier.create(apiService.processTransaction(sampleRequest))
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void getTransactionById_notFound_returnsEmpty() {
        UUID transactionId = UUID.randomUUID();
        
        when(transactionRepository.findById(transactionId))
                .thenReturn(Mono.empty());

        StepVerifier.create(apiService.getTransactionById(transactionId.toString()))
                .verifyComplete();
    }
}