package it.cgmconsulting.azienda.service;

import it.cgmconsulting.azienda.entity.Articolo;
import it.cgmconsulting.azienda.repository.ArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticoloService {

    @Autowired
    ArticoloRepository articoloRepository;

    public Optional<Articolo> findByNomeArticolo(String nomeArticolo){
       return articoloRepository.findByNomeArticolo(nomeArticolo);
    }

    public void save(Articolo art){
        articoloRepository.save(art);
    }
}
