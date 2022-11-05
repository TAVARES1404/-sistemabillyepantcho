package br.univille.sistemabillyepantcho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemabillyepantcho.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    List<Veiculo> findByCliente_Id(long id);
    
}
