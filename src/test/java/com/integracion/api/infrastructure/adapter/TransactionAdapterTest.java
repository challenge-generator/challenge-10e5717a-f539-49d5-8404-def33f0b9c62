package com.integracion.api.infrastructure.adapter;

import com.integracion.api.domain.model.Transaction;
import com.integracion.api.infrastructure.dto.TransactionRequest;
import com.integracion.api.infrastructure.dto.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionAdapterTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private TransactionAdapter transactionAdapter;

    private TransactionRequest validRequest;
    private TransactionResponse validResponse;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transactionAdapter = new TransactionAdapter(webClient);
        
        validRequest = new TransactionRequest(
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD"
        );
        
        validResponse = new TransactionResponse(
                UUID.randomUUID().toString(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                "COMPLETED",
                LocalDateTime.now()
        );
        
        transaction = new Transaction(
                UUID.randomUUID(),
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                "COMPLETED",
                LocalDateTime.now()
        );
    }

    @Test
    void saveTransaction_success_returnsTransaction() {
        when(webClient.post()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions")).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.bodyValue(any(TransactionRequest.class))).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(validResponse));

        StepVerifier.create(transactionAdapter.saveTransaction(validRequest))
                .expectNextMatches(response -> response.transactionId().equals(validResponse.transactionId()))
                .verifyComplete();
    }

    @Test
    void getTransactionById_success_returnsTransaction() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(validResponse));

        StepVerifier.create(transactionAdapter.getTransactionById(transactionId))
                .expectNextMatches(response -> response.transactionId().equals(transactionId))
                .verifyComplete();
    }

    @Test
    void getTransactionById_notFound_throwsException() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class))
                .thenReturn(Mono.error(new WebClientResponseException(
                        "Not Found",
                        HttpStatus.NOT_FOUND.value(),
                        "Transaction not found",
                        null,
                        null,
                        null
                )));

        StepVerifier.create(transactionAdapter.getTransactionById(transactionId))
                .expectError(WebClientResponseException.NotFound.class)
                .verify();
    }

    @Test
    void updateTransactionStatus_success_returnsUpdatedTransaction() {
        String transactionId = UUID.randomUUID().toString();
        String newStatus = "COMPLETED";
        TransactionResponse updatedResponse = new TransactionResponse(
                transactionId,
                "TRANSFER",
                "ACC123",
                "ACC456",
                new BigDecimal("1000.00"),
                "USD",
                newStatus,
                LocalDateTime.now()
        );

        when(webClient.patch()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId + "/status"))
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.bodyValue(any())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(TransactionResponse.class)).thenReturn(Mono.just(updatedResponse));

        StepVerifier.create(transactionAdapter.updateTransactionStatus(transactionId, newStatus))
                .expectNextMatches(response -> response.status().equals(newStatus))
                .verifyComplete();
    }

    @Test
    void deleteTransaction_success_completesWithoutError() {
        String transactionId = UUID.randomUUID().toString();
        
        when(webClient.delete()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("http://external-service/api/transactions/" + transactionId))
                .thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.toBodilessEntity()).thenReturn(Mono.just(
                new org.springframework.http.ResponseEntity<>(HttpStatus.NO_CONTENT)
        ));

        StepVerifier.create(transactionAdapter.deleteTransaction(transactionId))
                .verifyComplete();
    }
}