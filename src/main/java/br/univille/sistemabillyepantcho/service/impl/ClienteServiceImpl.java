package br.univille.sistemabillyepantcho.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.entity.Cliente;
import br.univille.sistemabillyepantcho.mapper.ClienteMapper;
import br.univille.sistemabillyepantcho.repository.ClienteRepository;
import br.univille.sistemabillyepantcho.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repository;

    private ClienteMapper mapper = Mappers.getMapper(ClienteMapper.class);

    @Override
    public List<ClienteDTO> getAll() {
        return mapper.mapCliente(repository.findAll());
    }
    
}
