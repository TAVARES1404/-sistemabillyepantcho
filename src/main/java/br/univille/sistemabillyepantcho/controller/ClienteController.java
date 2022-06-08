package br.univille.sistemabillyepantcho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        List<ClienteDTO> listaCliente = service.getAll();
        return new ModelAndView ("cliente/index","listaClientes",listaCliente);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        ClienteDTO cliente = new ClienteDTO();
        return new ModelAndView ("cliente/form","cliente",cliente);
    }
    @PostMapping(params = "form")
    public ModelAndView save(ClienteDTO cliente){
        service.save(cliente);
        return new ModelAndView ("redirect:/cliente");
    }


}
