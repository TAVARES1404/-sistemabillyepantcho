package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.ItensOrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.entity.ItensOrdemDeServico;
@Mapper
public interface ItensOrdemDeServicoMapper {
    List<ItensOrdemDeServicoDTO> mapItensOrdemDeServico(List<ItensOrdemDeServico> cliente);
    List<ItensOrdemDeServico> mapItensOrdemDeServicoDTO(List<ItensOrdemDeServicoDTO> cliente);

    ItensOrdemDeServicoDTO mapItensOrdemDeServico(ItensOrdemDeServico cliente);
    ItensOrdemDeServico mapItensOrdemDeServicoDTO(ItensOrdemDeServicoDTO cliente);
}
