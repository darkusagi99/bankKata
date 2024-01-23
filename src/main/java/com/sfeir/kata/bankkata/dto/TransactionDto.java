package com.sfeir.kata.bankkata.dto;

import com.sfeir.kata.bankkata.model.Transaction;

import java.time.LocalDateTime;

public record TransactionDto(Long transactionId, Long accountId, Float transactionValue, LocalDateTime date, String label) {

    public TransactionDto(Transaction transaction) {
        this(transaction.transactionId, transaction.accountId, transaction.transactionValue, transaction.date, transaction.label);
    }
}
