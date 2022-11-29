package br.univille.sistemabillyepantcho.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.entity.Produto;
import br.univille.sistemabillyepantcho.mapper.ProdutoMapper;
import br.univille.sistemabillyepantcho.repository.ProdutoRepository;
import br.univille.sistemabillyepantcho.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    private ProdutoMapper mapper = Mappers.getMapper(ProdutoMapper.class);

    @Override
    public List<ProdutoDTO> getAll() {
        return mapper.mapProduto(repository.findAll());
    }

    @Override
    public ProdutoDTO save(ProdutoDTO produto) {
        Produto produtoEntitty = mapper.mapProdutoDTO(produto);
        repository.save(produtoEntitty);
        return mapper.mapProduto(produtoEntitty);
    }

    @Override
    public ProdutoDTO buscarPeloId(long id) {
        Optional<Produto> produto = repository.findById(id);   
        if (produto.isPresent()){
            Produto produtoEntitty = produto.get();
            return mapper.mapProduto(produtoEntitty);
        }    
        return new ProdutoDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
        
    }

    @Override
    public List<ProdutoDTO> findByQuantidadeProdutoGreaterThan(int qtd) {

        return mapper.mapProduto(repository.findByQuantidadeProdutoGreaterThan(qtd));
    }

    @Override
    public void updataQtd(long id, int qtd) {

        System.out.println(id+ "aqui");
        Optional<Produto> produto = repository.findById(id);  
        
        if (produto.isPresent()){
            System.out.println("aqui2");
            Produto produtoEntitty = produto.get();
            int qtdOld = produtoEntitty.getQuantidadeProduto();
            System.out.println(qtdOld);
            int qtdNew = qtdOld - qtd;
            System.out.println(qtdNew);
            produtoEntitty.setQuantidadeProduto(qtdNew);
            repository.save(produtoEntitty);
        }
        
    }

    @Override
    public List<ProdutoDTO> findByQuantidadeProdutoLessThan(int qtd) {
        return mapper.mapProduto(repository.findByQuantidadeProdutoLessThanEqual(qtd));
    }
}
