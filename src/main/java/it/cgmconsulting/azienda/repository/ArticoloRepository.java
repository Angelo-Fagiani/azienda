package it.cgmconsulting.azienda.repository;

import it.cgmconsulting.azienda.entity.Articolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo, Long> {
        Optional<Articolo> findByNomeArticolo(String nomeArticolo);
}
