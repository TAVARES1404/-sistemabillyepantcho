package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.entity.Cliente;

public interface ClienteService {

    List<ClienteDTO>getAll();
    ClienteDTO save(ClienteDTO clienteDTO);
    ClienteDTO buscarPeloId(long id);
    void delete(long id);
    
    
}
