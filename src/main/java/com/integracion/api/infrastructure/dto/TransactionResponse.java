package com.integracion.api.infrastructure.dto;


import com.integracion.api.domain.model.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionResponse(
    @NotNull(message = "Transaction ID cannot be null")
    UUID id,
    
    @NotBlank(message = "Account ID cannot be blank")
    String accountId,
    
    @NotBlank(message = "Transaction type cannot be blank")
    String transactionType,
    
    @NotNull(message = "Amount cannot be null")
    BigDecimal amount,
    
    @NotBlank(message = "Currency cannot be blank")
    String currency,
    
    @NotBlank(message = "Status cannot be blank")
    String status,
    
    LocalDateTime timestamp,
    
    String description,
    
    String correlationId,
    
    LocalDateTime createdAt,
    
    LocalDateTime updatedAt
) {
    public static TransactionResponse fromDomain(com.integracion.api.domain.model.Transaction transaction) {
        return new TransactionResponse(
            UUID.fromString(transaction.id()),
            transaction.accountId(),
            transaction.transactionType(),
            transaction.amount(),
            transaction.currency(),
            transaction.status(),
            transaction.timestamp(),
            transaction.description(),
            transaction.correlationId(),
            transaction.createdAt(),
            transaction.updatedAt()
        );
    }
}