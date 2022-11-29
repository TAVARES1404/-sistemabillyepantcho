package br.univille.sistemabillyepantcho.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.service.OrdemDeServicoService;
import br.univille.sistemabillyepantcho.service.ProdutoService;

@Controller
@RequestMapping("/")
public class HomeController{

    @Autowired
    private OrdemDeServicoService serviceOS;
    
    @Autowired
    private ProdutoService productService;

    @GetMapping()
    public ModelAndView index(){
        List<OrdemDeServicoDTO> listOS = serviceOS.getAll();
        List<ProdutoDTO> listaProdutos = productService.findByQuantidadeProdutoLessThan(10);

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listOS", listOS);
        dados.put("listaProdutos", listaProdutos);
        
    
        return new ModelAndView("home/index", dados);
    }
    
}
