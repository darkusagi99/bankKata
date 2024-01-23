package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClientByClientId(Long clientId);

}
