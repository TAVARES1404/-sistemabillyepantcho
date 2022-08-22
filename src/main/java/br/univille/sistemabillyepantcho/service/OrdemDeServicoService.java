package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;

public interface OrdemDeServicoService {

    List<OrdemDeServicoDTO>getAll();
    OrdemDeServicoDTO save(OrdemDeServicoDTO ordemDeServico);
    OrdemDeServicoDTO buscarPeloId(long id);
    void delete(long id);
    OrdemDeServicoDTO buscarVeic(long id);
}
