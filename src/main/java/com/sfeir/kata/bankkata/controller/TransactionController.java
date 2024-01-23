package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.TransactionDto;
import com.sfeir.kata.bankkata.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /** Extract one transaction - From ID */
    @GetMapping(value = "/{transactionId}")
    public TransactionDto getTransaction(@PathVariable Long transactionId) {
        return transactionService.readTransaction(transactionId);
    }

    /** Extract multiple transactions - From client Id */
    @GetMapping(value = "/account/{accountId}")
    public List<TransactionDto> getAccountTransactions(@PathVariable Long accountId) {
        return transactionService.readAccountTransactions(accountId);
    }

    /** Create a new transaction */
    @PutMapping
    public TransactionDto createTransaction(@RequestParam long clientId, @RequestParam long accountId, @RequestParam float value, @RequestParam(required = false) String label) {
        return transactionService.createTransaction(clientId, accountId, value, label);
    }

}
