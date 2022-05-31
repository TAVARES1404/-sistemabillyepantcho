package br.univlle.sistemabillyepantcho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univlle.sistemabillyepantcho.entity.Cliente;
import br.univlle.sistemabillyepantcho.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        List<Cliente> listaCliente = service.getAll();
        return new ModelAndView ("cliente/index","listaClientes",listaCliente);
    }
    
}