package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findAccountByAccountId(Long accountId);

    Optional<Account> findAccountByAccountIdAndClientId(Long accountId, Long clientId);

    List<Account> findAccountsByClientId(Long clientId);



}
