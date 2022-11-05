package br.univille.sistemabillyepantcho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.sistemabillyepantcho.entity.Usuario;

@Repository
public interface UsuarioRepository 
    extends JpaRepository<Usuario,Long>{
    //select * from usuario where usuario.usuario = 'zezinho'
    Usuario findByUsuario(String usuario);
    //select * from usuario where 
    //usuario.usuario = "zezinho" and usuario.senha = "1234"
    Usuario findByUsuarioAndSenha(String usuario, String senha);
}
