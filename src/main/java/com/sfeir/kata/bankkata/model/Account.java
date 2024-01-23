package com.sfeir.kata.bankkata.model;

import jakarta.persistence.*;

import java.util.UUID;

/** Bank account */
@Entity
@Table(name = "T_ACCOUNT")
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

    public Account() {

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
