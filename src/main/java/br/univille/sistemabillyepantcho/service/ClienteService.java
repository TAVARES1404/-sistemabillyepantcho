package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;

public interface ClienteService {

    List<ClienteDTO>getAll();
    ClienteDTO save(ClienteDTO clienteDTO);
    
    
}
