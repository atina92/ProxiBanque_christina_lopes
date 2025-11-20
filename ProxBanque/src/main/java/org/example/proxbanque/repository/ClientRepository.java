package org.example.proxbanque.repository;

import org.example.proxbanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
