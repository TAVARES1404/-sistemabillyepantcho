package br.univlle.sistemabillyepantcho.mapper;

import org.mapstruct.Mapper;

import br.univlle.sistemabillyepantcho.dto.ClienteDTO;
import br.univlle.sistemabillyepantcho.entity.Cliente;

@Mapper
public interface ClienteMapper {
    ClienteDTO sourceToDestination(Cliente source);
    Cliente destinationToSource(ClienteDTO destination);
}
