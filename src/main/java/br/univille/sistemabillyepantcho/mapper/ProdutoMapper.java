package br.univille.sistemabillyepantcho.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.entity.Produto;

@Mapper
public interface ProdutoMapper {

    List<ProdutoDTO> mapProduto(List<Produto> cliente);
    List<Produto> mapProdutoDTO(List<ProdutoDTO> cliente);

    ProdutoDTO mapProduto(Produto cliente);
    Produto mapProdutoDTO(ProdutoDTO cliente);
    
}
