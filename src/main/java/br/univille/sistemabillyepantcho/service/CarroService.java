package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.CarroDTO;

public interface CarroService {

    List<CarroDTO> getAll();
    CarroDTO save (CarroDTO carroDTO);
    CarroDTO buscarPeloId(long id);
    void delete(long id);

    
}
