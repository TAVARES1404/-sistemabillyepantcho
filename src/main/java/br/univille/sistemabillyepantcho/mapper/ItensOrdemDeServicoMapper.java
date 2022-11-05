package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.ItensOrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.entity.ItensOrdemDeServico;
@Mapper
public interface ItensOrdemDeServicoMapper {
    List<ItensOrdemDeServicoDTO> mapItensOrdemDeServico(List<ItensOrdemDeServico> itensOrdemDeServicos);
    List<ItensOrdemDeServico> mapItensOrdemDeServicoDTO(List<ItensOrdemDeServicoDTO> itensOrdemDeServicos);

    ItensOrdemDeServicoDTO mapItensOrdemDeServico(ItensOrdemDeServico itensOrdemDeServicos);
    ItensOrdemDeServico mapItensOrdemDeServicoDTO(ItensOrdemDeServicoDTO itensOrdemDeServicos);
}
