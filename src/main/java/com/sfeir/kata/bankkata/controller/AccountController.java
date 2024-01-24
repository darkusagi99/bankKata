package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Get information for one account
    @GetMapping(value = "/{accountId}")
    public AccountDto getAccount(@PathVariable long accountId) {
        return accountService.getAccountDto(accountId);
    }

    // Create a new account
    @PutMapping()
    public AccountDto createAccount(@RequestParam long clientId) {
        return accountService.createAccount(clientId);
    }



}
