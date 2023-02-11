package it.cgmconsulting.azienda.service;

import it.cgmconsulting.azienda.entity.Cliente;
import it.cgmconsulting.azienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Optional<Cliente> findByPiva(String pIva){
        return clienteRepository.findByPiva(pIva);
    }
    public void save(Cliente cli){
        clienteRepository.save(cli);
    }
}
