package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.model.Account;
import com.sfeir.kata.bankkata.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class to manage account
 * */
@Service
public class AccountService {


    private final AccountRepository accountRepository;

    private final ClientService clientService;

    public AccountService(AccountRepository accountRepository, ClientService clientService) {
        this.accountRepository = accountRepository;
        this.clientService = clientService;
    }

    // CRUD actions - No DELETE - Legal part
    /** Create account */
    public AccountDto createAccount(long clientId) {

        // Call to check if client exists
        clientService.getClient(clientId);

        Account.AccountBuilder builder = new Account.AccountBuilder(clientId);
        Account newAccount = new Account(builder);
        return new AccountDto(accountRepository.save(newAccount));
    }

    /** Update - Balance only */
    public void updateBalance(long accountId, float balanceChange) {

        Account currentAccount = getAccount(accountId);
        currentAccount.currentBalance += balanceChange;

        accountRepository.save(currentAccount);

    }

    /** Read action */
    public AccountDto getAccountDto(long accountId) {
        return new AccountDto(accountRepository.findAccountByAccountId(accountId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No Account Found")));
    }


    private Account getAccount(long accountId) {
        return accountRepository.findAccountByAccountId(accountId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No Account Found"));
    }



    /** Read account action */
    public Account getClientAccount(long accountId, long clientId) {
        return accountRepository.findAccountByAccountIdAndClientId(accountId, clientId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No Account Found"));
    }


}
