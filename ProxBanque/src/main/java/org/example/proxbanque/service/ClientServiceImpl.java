package org.example.proxbanque.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.proxbanque.entity.Client;
import org.example.proxbanque.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @PostConstruct
    private void initDb() {
        clientRepository.saveAll(
                List.of(
                        new Client("Christina", "epita", "94","kb", "102030405")
                )
        );

    }

    @Override
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> updateClient(Client client) {
        return Optional.of(
                clientRepository.save(client));
    }
}
