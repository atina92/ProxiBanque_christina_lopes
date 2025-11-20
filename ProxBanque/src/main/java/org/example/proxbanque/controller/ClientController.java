package org.example.proxbanque.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxbanque.entity.Client;
import org.example.proxbanque.repository.ClientRepository;
import org.example.proxbanque.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getClient();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}