package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findClientByClientId(Long clientId);

}
