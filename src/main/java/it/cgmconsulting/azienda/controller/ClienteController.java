package it.cgmconsulting.azienda.controller;

import it.cgmconsulting.azienda.entity.Cliente;
import it.cgmconsulting.azienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    //metodo per l'inserimento
    @PutMapping("/insert")
    public ResponseEntity<?> inserimentoCliente(@RequestBody Cliente cli){
        Optional<Cliente> c= clienteService.findByPiva(cli.getPiva());
        if(c.isPresent()){
            return new ResponseEntity<>("Questo cliente è già caricato", HttpStatus.BAD_REQUEST);
        }
        if(cli.getPiva().length()<11){
            return new ResponseEntity<>("Questa PIVA non rispetta la lunghezza di 11 caratteri", HttpStatus.BAD_REQUEST);
        }

        Cliente cliente = new Cliente(
                cli.getPiva(),
                cli.getRagioneSociale(),
                cli.getIndirizzo(),
                cli.getCitta()
        );

        clienteService.save(cliente);
        return new ResponseEntity<>("Nuovo cliente inserito", HttpStatus.CREATED);
    }

}
