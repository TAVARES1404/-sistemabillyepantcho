package br.univille.sistemabillyepantcho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemabillyepantcho.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
