package org.example.proxbanque.repository.compte;

import org.example.proxbanque.entity.compte.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByClientId(Long clientId);
    Optional<Compte> findByClientIdAndTypeCompte(Long clientId, String typeCompte);

}