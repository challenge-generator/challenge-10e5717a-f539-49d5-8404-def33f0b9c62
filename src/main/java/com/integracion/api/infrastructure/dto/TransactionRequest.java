package com.integracion.api.infrastructure.dto;


import com.integracion.api.domain.model.Transaction;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequest(
    @NotBlank(message = "Account ID cannot be blank")
    String accountId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotBlank(message = "Currency cannot be blank")
    @Size(min = 3, max = 3, message = "Currency must be 3 characters")
    String currency,

    @NotBlank(message = "Transaction type cannot be blank")
    String transactionType,

    @NotBlank(message = "Reference cannot be blank")
    String reference,

    @NotBlank(message = "Counterparty account ID cannot be blank")
    String counterpartyAccountId,

    @NotBlank(message = "Description cannot be blank")
    String description) {

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }
}