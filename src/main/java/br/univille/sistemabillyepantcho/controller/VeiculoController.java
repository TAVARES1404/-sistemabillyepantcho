package br.univille.sistemabillyepantcho.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.service.ClienteService;
import br.univille.sistemabillyepantcho.service.VeiculoService;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index() {
        List<VeiculoDTO> listaVeiculo = service.getAll();
        return new ModelAndView("veiculo/index", "listaVeiculos", listaVeiculo);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        VeiculoDTO veiculo = new VeiculoDTO();
        List<ClienteDTO> listaClientes = clienteService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("veiculo", veiculo);
        dados.put("listaclientes", listaClientes);
        return new ModelAndView("veiculo/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@ModelAttribute("veiculo") VeiculoDTO veiculo) {
        service.save(veiculo);
        return new ModelAndView("redirect:/veiculo");
    }

    @GetMapping(path = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        VeiculoDTO veiculo = service.buscarPeloId(id);
        List<ClienteDTO> listaClientes =  clienteService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("veiculo",veiculo);
        dados.put("listaclientes",listaClientes);
        return new ModelAndView("veiculo/form", dados);
    }

    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/veiculo");
    }
    
}
