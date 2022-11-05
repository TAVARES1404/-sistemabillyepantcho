package br.univille.sistemabillyepantcho.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.service.OrdemDeServicoService;

@RestController
@RequestMapping("/api/v1/ordensdeservicos")
public class OrdemDeServicoControllerAPI {
    

    @Autowired
    private OrdemDeServicoService service;

    @GetMapping
    public ResponseEntity<List<OrdemDeServicoDTO>> getAll(){
        List<OrdemDeServicoDTO> listOs = service.getAll();
        return new ResponseEntity<>(listOs,HttpStatus.OK);
    }
}
