package org.example.proxbanque.controller;

import lombok.RequiredArgsConstructor;
import org.example.proxbanque.entity.compte.Compte;
import org.example.proxbanque.repository.compte.CompteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
public class CompteController {

    private final CompteRepository compteRepository;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/client/{clientId}")
    public List<Compte> getComptesByClient(@PathVariable Long clientId) {
        return compteRepository.findByClientId(clientId);
    }

    @GetMapping("/client/{clientId}/courant")
    public Compte getCompteCourant(@PathVariable Long clientId) {
        return compteRepository.findByClientIdAndTypeCompte(clientId, "COURANT")
                .orElseThrow(() -> new RuntimeException("Compte courant not found"));
    }

    @GetMapping("/client/{clientId}/epargne")
    public Compte getCompteEpargne(@PathVariable Long clientId) {
        return compteRepository.findByClientIdAndTypeCompte(clientId, "EPARGNE")
                .orElseThrow(() -> new RuntimeException("Compte épargne not found"));
    }

    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
    }
}
