package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.entity.OrdemDeServico;

@Mapper
public interface OrdemDeServicoMapper {

    List<OrdemDeServicoDTO> mapOrdemDeServico(List<OrdemDeServico> cliente);
    List<OrdemDeServico> mapOrdemDeServicoDTO(List<OrdemDeServicoDTO> cliente);

    OrdemDeServicoDTO mapOrdemDeServico(OrdemDeServico cliente);
    OrdemDeServico mapOrdemDeServicoDTO(OrdemDeServicoDTO cliente);
    
}
