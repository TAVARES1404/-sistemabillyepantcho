package br.univille.sistemabillyepantcho.service;

import java.util.List;

import br.univille.sistemabillyepantcho.dto.ProdutoDTO;

public interface ProdutoService {
    List<ProdutoDTO>getAll();
    ProdutoDTO save(ProdutoDTO produto);
    ProdutoDTO buscarPeloId(long id);
    void delete(long id);
    List<ProdutoDTO> findByQuantidadeProdutoGreaterThan(int qtd);
    List<ProdutoDTO> findByQuantidadeProdutoLessThan(int qtd);
    void updataQtd(long id, int qtd);
    
}
