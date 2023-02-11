package it.cgmconsulting.azienda.controller;

import it.cgmconsulting.azienda.entity.Categoria;
import it.cgmconsulting.azienda.service.CategoriaService;
import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    //metodo per inserire una nuova categoria
    @PutMapping("/insert")
    public ResponseEntity<?> inserimentoCategoria(@RequestBody Categoria cat){

        Optional<Categoria> c = categoriaService.findByCategoria(cat.getCategoria());
        if(c.isPresent()){
            return new ResponseEntity<String>("questa categoria è gia presente", HttpStatus.BAD_REQUEST);
        }

        Categoria categ = new Categoria(
                cat.getCategoria(),
                cat.getIva());

        categoriaService.save(categ);

        return new ResponseEntity<>("categoria salvata", HttpStatus.CREATED);
    }

}
