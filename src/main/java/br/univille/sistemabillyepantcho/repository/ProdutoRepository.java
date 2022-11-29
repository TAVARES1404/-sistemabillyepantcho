package br.univille.sistemabillyepantcho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemabillyepantcho.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByQuantidadeProdutoGreaterThan(int quantidadeProduto);
    List<Produto> findByQuantidadeProdutoLessThanEqual(int quantidadeProduto);
}
