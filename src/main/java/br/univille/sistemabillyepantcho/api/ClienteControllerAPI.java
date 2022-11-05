package br.univille.sistemabillyepantcho.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControllerAPI {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> listClients = service.getAll();
        return new ResponseEntity<>(listClients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO cliente) {

        if (cliente.getId() == 0) {
            cliente = service.save(cliente);
            return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.CREATED);

        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable("id") long id) {

        ClienteDTO cliente = service.buscarPeloId(id);
        if (cliente.getId() != 0) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") long id, @RequestBody ClienteDTO cliente) {

        ClienteDTO clienteAntigo = service.buscarPeloId(id);
        if (clienteAntigo.getId() != 0) {

            clienteAntigo.setNome(cliente.getNome());
            clienteAntigo.setBairro(cliente.getBairro());
            clienteAntigo.setCidade(cliente.getCidade());
            clienteAntigo.setEndereco(cliente.getEndereco());
            clienteAntigo.setTelefone(cliente.getTelefone());

            clienteAntigo = service.save(clienteAntigo);
            return new ResponseEntity<>(clienteAntigo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable("id") long id) {
        ClienteDTO cliente = service.buscarPeloId(id);

        if (cliente.getId() != 0) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();

    }

}
