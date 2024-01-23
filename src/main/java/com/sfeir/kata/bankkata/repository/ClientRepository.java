package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClientByClientId(Long clientId);

    @Modifying
    @Query("update Client c set c.clientId = :clientId where c.address = :address")
    void updateAddress(@Param(value = "clientId") long clientId, @Param(value = "address") String address);

}
