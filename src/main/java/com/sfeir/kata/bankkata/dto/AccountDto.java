package com.sfeir.kata.bankkata.dto;

import com.sfeir.kata.bankkata.model.Account;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public record AccountDto(Long accountId, Long clientId, String accountNumber, float currentBalance) {

    public AccountDto(Account account) {
        this(account.accountId, account.clientId, account.accountNumber, account.currentBalance);
    }

}
