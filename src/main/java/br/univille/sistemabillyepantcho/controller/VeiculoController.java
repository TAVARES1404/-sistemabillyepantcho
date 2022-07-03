package br.univille.sistemabillyepantcho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.service.VeiculoService;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public ModelAndView index() {
        List<VeiculoDTO> listaVeiculo = service.getAll();
        return new ModelAndView("veiculo/index", "listaVeiculos", listaVeiculo);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        VeiculoDTO veiculo = new VeiculoDTO();
        return new ModelAndView("veiculo/form", "veiculo", veiculo);
    }

    @PostMapping(params = "form")
    public ModelAndView save(VeiculoDTO veiculo) {
        service.save(veiculo);
        return new ModelAndView("redirect:/veiculo");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        VeiculoDTO veiculo = service.buscarPeloId(id);
        return new ModelAndView("cliente/form", "veiculo", veiculo);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/veiculo");
    }
    
}
