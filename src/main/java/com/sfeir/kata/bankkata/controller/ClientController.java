package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.ClientDto;
import com.sfeir.kata.bankkata.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Get allClient information
    @GetMapping
    public List<ClientDto> getAllClients() {

        return clientService.getAllClients();
    }

    // Get information for one client
    @GetMapping(value = "/{clientId}")
    public ClientDto getClient(@PathVariable Long clientId) {
        return clientService.getClient(clientId);
    }

    // Get light information for one client
    @GetMapping(value = "/{clientId}/details")
    public ClientDto getDetailedClient(@PathVariable Long clientId) {
        return clientService.getClientAccount(clientId);
    }

    // Create new client
    @PutMapping
    public ClientDto createClient(@RequestParam String lastname, @RequestParam String firstname, @RequestParam LocalDate birthdate, @RequestParam String address) {
        return  clientService.createClient(lastname, firstname, birthdate, address);
    }

    // Update client address
    @PatchMapping(value = "/{clientId}")
    public ClientDto updateClientAddress(@PathVariable Long clientId, @RequestParam String newAddress) {
        return clientService.updateClientAddress(clientId, newAddress);

    }


}
