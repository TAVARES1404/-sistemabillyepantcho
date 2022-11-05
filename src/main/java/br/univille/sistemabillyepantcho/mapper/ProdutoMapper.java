package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.entity.Produto;

@Mapper
public interface ProdutoMapper {

    List<ProdutoDTO> mapProduto(List<Produto> produto);
    List<Produto> mapProdutoDTO(List<ProdutoDTO> produto);

    ProdutoDTO mapProduto(Produto produto);
    Produto mapProdutoDTO(ProdutoDTO produto);
    
}
