package br.univille.sistemabillyepantcho.service.impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ClienteDTO save(ClienteDTO cliente) {
        Cliente clienteEntitty = mapper.mapClienteDTO(cliente);
        repository.save(clienteEntitty);
        return mapper.mapCliente(clienteEntitty);

    }

    @Override
    public ClienteDTO buscarPeloId(long id) {
        Optional<Cliente> cliente = repository.findById(id);   
        if (cliente.isPresent()){
            Cliente clienteEntity = cliente.get();
            return mapper.mapCliente(clienteEntity);
        }    
        
        return new ClienteDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
        
    }
    
}
