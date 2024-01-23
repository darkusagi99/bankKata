package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Get information for one account
    @GetMapping(value = "/{accountId}")
    public AccountDto getAccount(@PathVariable long accountId) {
        return accountService.getAccount(accountId);
    }

    // Create a new account
    @PutMapping()
    public AccountDto createAccount(@RequestParam long clientId) {
        return accountService.createAccount(clientId);
    }



}
