package br.univille.sistemabillyepantcho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.CarroDTO;
import br.univille.sistemabillyepantcho.service.CarroService;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ModelAndView index() {
        List<CarroDTO> listaCarros = service.getAll();
        return new ModelAndView("carro/index", "listaCarros", listaCarros);
    }
    
    @GetMapping("/novo")
    public ModelAndView novo() {
        CarroDTO carro = new CarroDTO();
        return new ModelAndView("carro/form", "carro", carro);
    }

    @PostMapping(params = "form")
    public ModelAndView save(CarroDTO carro) {
        service.save(carro);
        return new ModelAndView("redirect:/carro");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        CarroDTO carro = service.buscarPeloId(id);
        return new ModelAndView("carro/form", "carro", carro);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/carro");
    }
}
