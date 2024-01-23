package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findAccountByAccountId(Long accountId);

    Account findAccountByAccountIdAndClientId(Long accountId, Long clientId);

    List<Account> findAccountsByClientId(Long clientId);



}
