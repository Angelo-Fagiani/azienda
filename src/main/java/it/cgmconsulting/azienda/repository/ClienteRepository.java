package it.cgmconsulting.azienda.repository;

import it.cgmconsulting.azienda.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByPiva(String pIva);
}
