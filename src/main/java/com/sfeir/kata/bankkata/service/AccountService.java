package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.model.Account;
import com.sfeir.kata.bankkata.repository.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * Service class to manage account
 * */
@Service
public class AccountService {


    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // CRUD actions - No DELETE - Legal part
    /** Create account */
    public AccountDto createAccount(long clientId) {
        Account.AccountBuilder builder = new Account.AccountBuilder(clientId);
        Account newAccount = new Account(builder);
        return new AccountDto(accountRepository.save(newAccount));
    }

    /** Update - Balance only */
    public int updateBalance() {

        return 0;
    }

    /** Read action */
    public AccountDto getAccount(long accountId) {
        return new AccountDto(accountRepository.findAccountByAccountId(accountId));
    }


}
