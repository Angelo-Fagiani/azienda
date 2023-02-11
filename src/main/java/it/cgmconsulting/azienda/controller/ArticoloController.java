package it.cgmconsulting.azienda.controller;


import it.cgmconsulting.azienda.entity.Articolo;
import it.cgmconsulting.azienda.entity.Categoria;
import it.cgmconsulting.azienda.service.ArticoloService;
import it.cgmconsulting.azienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("articolo")
public class ArticoloController {
    @Autowired
    ArticoloService articoloService;
    @Autowired
    CategoriaService categoriaService;
    @PutMapping("/insert")
    public ResponseEntity<?> inserimentoArticolo(@RequestBody Articolo art){
        Optional<Articolo> a = articoloService.findByNomeArticolo(art.getNomeArticolo());
        if(a.isPresent()){
            return new ResponseEntity<>("Questo di articolo è già stato caricato", HttpStatus.BAD_REQUEST);
        }
        if(categoriaService.findByCategoria(art.getCategoria().getCategoria()).isEmpty()){
            return new ResponseEntity<>("Questa catergoria non esiste", HttpStatus.BAD_REQUEST);
        }

        Articolo articolo = new Articolo(
                art.getNomeArticolo(),
                art.getPrezzo(),
                new Categoria(art.getCategoria().getCategoria())
        );
        articoloService.save(articolo);
        return new ResponseEntity<>("Articolo inserito correttamente", HttpStatus.CREATED);
    }

}
