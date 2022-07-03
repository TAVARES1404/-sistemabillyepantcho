package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.entity.Veiculo;

@Mapper
public interface VeiculoMapper {

    List<VeiculoDTO> mapVeiculo(List<Veiculo> veiculo);
    List<Veiculo> mapVeiculoDTO(List<VeiculoDTO> veiculo);

    VeiculoDTO mapVeiculo(Veiculo veiculo);
    Veiculo mapVeiculoDTO(VeiculoDTO veiculo);
    
}
