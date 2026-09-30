package com.integracion.api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
    UUID transactionId,
    String accountId,
    BigDecimal amount,
    String currency,
    String transactionType,
    LocalDateTime timestamp,
    String status,
    String reference,
    String counterpartyAccountId,
    String description) {

    public Transaction {
        if (transactionId == null) {
            throw new IllegalArgumentException("Transaction ID cannot be null");
        }
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        if (transactionType == null || transactionType.isBlank()) {
            throw new IllegalArgumentException("Transaction type cannot be null or empty");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
    }

    public Transaction withStatus(String newStatus) {
        return new Transaction(
            this.transactionId,
            this.accountId,
            this.amount,
            this.currency,
            this.transactionType,
            this.timestamp,
            newStatus,
            this.reference,
            this.counterpartyAccountId,
            this.description
        );
    }
}