package com.sfeir.kata.bankkata.dto;

import com.sfeir.kata.bankkata.model.Client;

import java.time.LocalDate;
import java.util.List;

public record ClientDto(Long clientId, String lastname, String firstname, LocalDate birthdate, String address, List<AccountDto> accountList) {
    public ClientDto(Client client) {
        this(client.clientId, client.lastname, client.firstname, client.birthdate, client.address, null);
    }

    public ClientDto(Client client, List<AccountDto> accountList) {
        this(client.clientId, client.lastname, client.firstname, client.birthdate, client.address, accountList);
    }

}
