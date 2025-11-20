package org.example.proxbanque.service;

import org.example.proxbanque.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClient();
    Client createClient(Client client);
    Optional<Client> updateClient(Client client);

}
