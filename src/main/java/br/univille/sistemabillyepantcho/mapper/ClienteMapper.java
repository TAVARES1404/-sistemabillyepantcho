package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.entity.Cliente;

@Mapper
public interface ClienteMapper {
    List<ClienteDTO> mapCliente(List<Cliente> cliente);
    List<Cliente> mapClienteDTO(List<ClienteDTO> cliente);

    ClienteDTO mapCliente(Cliente cliente);
    Cliente mapClienteDTO(ClienteDTO cliente);
}
