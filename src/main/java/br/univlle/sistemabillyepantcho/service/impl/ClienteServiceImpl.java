package br.univlle.sistemabillyepantcho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univlle.sistemabillyepantcho.dto.ClienteDTO;
import br.univlle.sistemabillyepantcho.entity.Cliente;
import br.univlle.sistemabillyepantcho.repository.ClienteRepository;
import br.univlle.sistemabillyepantcho.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteDTO> getAll() {
        return repository.findAll();
    }
    
}
