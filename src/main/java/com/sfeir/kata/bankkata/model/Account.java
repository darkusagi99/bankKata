package com.sfeir.kata.bankkata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/** Bank account */
@Entity
public class Account {

    @Id
    @GeneratedValue
    public Long accountId;

    @Column(nullable = false)
    public Long clientId;

    @Column(nullable = false)
    public String accountNumber;

    @Column(nullable = false)
    public float currentBalance;

    public Account(AccountBuilder builder) {

        this.clientId = builder.clientId;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0;

    }

    public static class AccountBuilder {

        private final Long clientId;

        public AccountBuilder(Long clientId) {
            this.clientId = clientId;
        }

    }

    private String generateAccountNumber() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }


}
