package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.CarroDTO;
import br.univille.sistemabillyepantcho.entity.Carro;

@Mapper
public interface CarroMapper {

    List<CarroDTO> mapCarro(List<Carro> carro);
    List<Carro> mapCarroDTO(List<CarroDTO> carro);

    CarroDTO mapCarro(Carro carro);
    Carro mapCarroDTO(CarroDTO carro);
    
}
