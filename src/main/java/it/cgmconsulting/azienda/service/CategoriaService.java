package it.cgmconsulting.azienda.service;

import it.cgmconsulting.azienda.entity.Categoria;
import it.cgmconsulting.azienda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;


    public Optional<Categoria> findByCategoria(String categoria) {
        return categoriaRepository.findByCategoria(categoria);
    }

    public void save (Categoria cat){
        categoriaRepository.save(cat);
    }
}
