package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAllByAccountId(Long accountId);

}
