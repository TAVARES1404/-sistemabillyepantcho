package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.entity.OrdemDeServico;

@Mapper
public interface OrdemDeServicoMapper {

    List<OrdemDeServicoDTO> mapOrdemDeServico(List<OrdemDeServico> ordemDeServico);
    List<OrdemDeServico> mapOrdemDeServicoDTO(List<OrdemDeServicoDTO> ordemDeServico);

    OrdemDeServicoDTO mapOrdemDeServico(OrdemDeServico ordemDeServico);
    OrdemDeServico mapOrdemDeServicoDTO(OrdemDeServicoDTO ordemDeServico);
    
}
