package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.AccountDto;
import com.sfeir.kata.bankkata.dto.ClientDto;
import com.sfeir.kata.bankkata.model.Account;
import com.sfeir.kata.bankkata.model.Client;
import com.sfeir.kata.bankkata.repository.AccountRepository;
import com.sfeir.kata.bankkata.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class to manage clients
 * */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    // CRUD actions - No Delete
    /** Create client */
    public ClientDto createClient(String lastname, String firstname, LocalDate birthdate, String address) {

        Client.ClientBuilder builder = new Client.ClientBuilder(lastname, firstname, birthdate);
        builder.setAddress(address);

        Client newClient = new Client(builder);

        return new ClientDto(clientRepository.save(newClient));

    }

    /** Update address for client */
    public ClientDto updateClientAddress(Long clientId, String newAddress) {

        Client clientToUpdate;
        Optional<Client> currentClient = clientRepository.findById(clientId);
        if(currentClient.isPresent()) {

            clientToUpdate = currentClient.get();
            clientToUpdate.setAddress(newAddress);
            clientRepository.save(clientToUpdate);

        } else {
            return null;
        }

        return new ClientDto(clientToUpdate);
    }

    /** Get client information */
    public ClientDto getClient(Long clientId) {

        return new ClientDto(clientRepository.findClientByClientId(clientId));
    }

    /** Get client and account Information */
    public ClientDto getClientAccount(Long clientId) {

        Client currentClient = clientRepository.findClientByClientId(clientId);
        List<AccountDto> accountDtoList = null;

        if (currentClient != null) {
            List<Account> accountList = accountRepository.findAccountsByClientId(clientId);
            accountDtoList = accountList.stream().map(AccountDto::new).collect(Collectors.toList());
            new ClientDto(currentClient, accountDtoList);
        }

        return null;
    }

    /** Get a list of all clients */
    public List<ClientDto> getAllClients() {

        List<ClientDto> clientList = new ArrayList<>();
        clientRepository.findAll().forEach(currentClient -> clientList.add(new ClientDto(currentClient)));

        return clientList;

    }

}
