package com.sfeir.kata.bankkata.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue
    public Long transactionId;
    @Column(nullable = false)
    public Long accountId;
    @Column(nullable = false)
    public Float transactionValue;
    @Column(nullable = false)
    public LocalDateTime date;
    @Column(nullable = false)
    public String label;

    public Transaction(TransactionBuilder builder) {
        this.accountId = builder.accountId;
        this.transactionValue = builder.transactionValue;
        this.label = builder.label;

        this.date = LocalDateTime.now();

    }

    public Transaction() {

    }

    public static class TransactionBuilder {
        private final Long accountId;
        private final Float transactionValue;
        private String label;

        public TransactionBuilder(Long accountId, Float transactionValue) {
            this.accountId = accountId;
            this.transactionValue = transactionValue;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

}
