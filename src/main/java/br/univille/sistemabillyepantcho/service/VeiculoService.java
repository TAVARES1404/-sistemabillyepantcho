package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.VeiculoDTO;

public interface VeiculoService {
    List<VeiculoDTO>getAll();
    VeiculoDTO save(VeiculoDTO veiculoDTO);
    VeiculoDTO buscarPeloId(long id);
    List<VeiculoDTO>buscarVeic(long id);
    void delete(long id);
    
    
}
