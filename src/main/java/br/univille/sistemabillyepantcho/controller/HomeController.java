package br.univille.sistemabillyepantcho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.service.OrdemDeServicoService;

@Controller
@RequestMapping("/")
public class HomeController{

    @Autowired
    private OrdemDeServicoService serviceOS;

    @GetMapping()
    public ModelAndView index(){
        List<OrdemDeServicoDTO> listOS = serviceOS.getAll();
        return new ModelAndView("home/index", "listOS", listOS);
    }
    
}
