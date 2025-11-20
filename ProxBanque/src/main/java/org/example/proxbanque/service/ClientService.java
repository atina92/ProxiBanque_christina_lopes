package org.example.proxbanque.service;

import org.example.proxbanque.entity.Client;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClient();
    Client createClient(Client client);
    Optional<Client> updateClient(Client client);
    void deleteClient(@RequestBody Client client);

}
