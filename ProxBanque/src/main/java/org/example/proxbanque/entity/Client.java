package org.example.proxbanque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Client( String name, String address, String codePostal, String city, String phone) {
        this.name = name;
        this.address = address;
        this.codePostal = codePostal;
        this.city = city;
        this.phone = phone;
    }
}
