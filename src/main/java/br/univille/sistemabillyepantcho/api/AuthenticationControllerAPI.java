package br.univille.sistemabillyepantcho.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.sistemabillyepantcho.entity.Usuario;
import br.univille.sistemabillyepantcho.security.JWTUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerAPI {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody Usuario usuario){
        UserDetails userDetails =
        userDetailsService.loadUserByUsername(usuario.getUsuario());
        if(userDetails.getPassword().equals(usuario.getSenha())){
            Map<String,Object> claims = new HashMap<>();
            String token = 
            jwtUtil.createToken(claims,userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }


}