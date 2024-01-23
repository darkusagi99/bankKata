package com.sfeir.kata.bankkata.dto;

import com.sfeir.kata.bankkata.model.Account;

public record AccountDto(Long accountId, Long clientId, String accountNumber, float currentBalance) {

    public AccountDto(Account account) {
        this(account.accountId, account.clientId, account.accountNumber, account.currentBalance);
    }

}
