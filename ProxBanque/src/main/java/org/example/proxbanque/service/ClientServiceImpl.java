package org.example.proxbanque.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.proxbanque.entity.Client;
import org.example.proxbanque.entity.compte.Compte;
import org.example.proxbanque.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @PostConstruct
    private void initDb() {

    }

    @Override
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        Compte compteCourant = new Compte(
                "CC" + client.getName(),  //pas hyper hyper safe
                0.0,
                "COURANT"
        );

        Compte compteEpargne = new Compte(
                "CE" + client.getName(),
                0.0,
                "EPARGNE"
        );

        client.setCompte(compteCourant);
        client.setCompte(compteEpargne);

        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> updateClient(Client client) {
        return Optional.of(
                clientRepository.save(client));
    }

    @DeleteMapping
    public void deleteClient(@RequestBody Client client) {
        clientRepository.delete(client);
    }
}
