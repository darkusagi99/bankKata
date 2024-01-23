package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.TransactionDto;
import com.sfeir.kata.bankkata.model.Account;
import com.sfeir.kata.bankkata.model.Transaction;
import com.sfeir.kata.bankkata.repository.AccountRepository;
import com.sfeir.kata.bankkata.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    // CRUD action - No DELETE, no UPDATE
    public TransactionDto createTransaction(@RequestParam long clientId, @RequestParam long accountId, @RequestParam float value, @RequestParam(required = false) String label) {

        // Check Client and account matching
        Account currentAccount = accountRepository.findAccountByAccountIdAndClientId(accountId, clientId);

        if (currentAccount != null) {
        Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder(accountId, value);
        builder.setLabel(label);

        Transaction newTransaction = new Transaction(builder);
        transactionRepository.save(newTransaction);

        return new TransactionDto(newTransaction);
        } else {
            return null;
        }
    }

    public TransactionDto readTransaction(Long transactionId) {

        Optional<Transaction> currentTransaction = transactionRepository.findById(transactionId);

        return currentTransaction.map(TransactionDto::new).orElse(null);

    }

    public List<TransactionDto> readAccountTransactions(Long accountId) {
        List<Transaction> transactionList = transactionRepository.findAllByAccountId(accountId);
        return transactionList.stream().map(TransactionDto::new).collect(Collectors.toList());

    }

}
