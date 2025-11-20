package org.example.proxbanque.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.proxbanque.entity.compte.Compte;

import java.util.ArrayList;
import java.util.List;

import static java.util.Locale.filter;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String codePostal;
    private String city;
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes = new ArrayList<>();

    public Client( String name, String address, String codePostal, String city, String phone) {
        this.name = name;
        this.address = address;
        this.codePostal = codePostal;
        this.city = city;
        this.phone = phone;
    }

    public void setCompte(Compte compte) {
        comptes.add(compte);
        compte.setClient(this);
    }
    public Compte getCompteCourant() {
        return comptes.stream().filter(c -> c.getTypeCompte().equals("COURANT"))
                .findFirst()
                .orElse(null);
    }
    public Compte getCompteEpargne() {
        return comptes.stream().filter(c -> c.getTypeCompte().equals("EPARGNE"))
                .findFirst()
                .orElse(null);
    }
}
