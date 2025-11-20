package org.example.proxbanque.entity.compte;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxbanque.entity.Client;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue
    private Long id;

    private String numeroCompte;
    private LocalDate dateOuverture;
    private double solde;
    private String typeCompte;

    @ManyToOne
    @JoinColumn(name = "client_id")

    private Client client;

    public Compte(String numeroCompte, double solde, String type) {
        this.numeroCompte = numeroCompte;
        this.dateOuverture = LocalDate.now();
        this.solde = solde;
        this.typeCompte = type;
    }
}