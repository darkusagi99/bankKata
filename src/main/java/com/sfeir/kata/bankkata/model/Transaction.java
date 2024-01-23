package com.sfeir.kata.bankkata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    public Long transactionId;
    @Column(nullable = false)
    public Long accountId;
    @Column(nullable = false)
    public float value;
    @Column(nullable = false)
    public LocalDateTime date;
    @Column(nullable = false)
    public String label;

    public Transaction(TransactionBuilder builder) {
        this.accountId = builder.accountId;
        this.value = builder.value;
        this.label = builder.label;

        this.date = LocalDateTime.now();

    }

    public static class TransactionBuilder {
        private final Long accountId;
        private final float value;
        private String label;

        public TransactionBuilder(Long accountId, float value) {
            this.accountId = accountId;
            this.value = value;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

}
