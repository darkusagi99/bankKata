package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.TransactionDto;
import com.sfeir.kata.bankkata.model.Account;
import com.sfeir.kata.bankkata.model.Transaction;
import com.sfeir.kata.bankkata.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;

    private final AccountService accountService;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    // CRUD action - No DELETE, no UPDATE
    @Transactional
    public TransactionDto createTransaction(@RequestParam long clientId, @RequestParam long accountId, @RequestParam float transactionValue, @RequestParam(required = false) String label) {

        // Check Client and account matching
        Account currentAccount = accountService.getClientAccount(accountId, clientId);

        if (currentAccount != null) {
            Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder(accountId, transactionValue);
            builder.setLabel(label);

            // Create transaction
            Transaction newTransaction = new Transaction(builder);
            transactionRepository.save(newTransaction);

            // Update account balance
            accountService.updateBalance(accountId, transactionValue);

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
