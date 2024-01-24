package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void createAccount() {

        // Test de la création de compte
        AccountDto newAccount = accountService.createAccount(1);

        assertEquals(newAccount.clientId(), 1);


    }

    @Test
    void updateBalance() {

        Account testAccount = accountService.getClientAccount(1, 1);
        float checkBalance = testAccount.currentBalance;
        checkBalance += 10;

        accountService.updateBalance(1, 10);


        Account updatedAccount = accountService.getClientAccount(1, 1);

        assertEquals(updatedAccount.currentBalance, checkBalance);


    }

    @Test
    void getAccountDto() {
    }

    @Test
    void getClientAccount() {
    }
}