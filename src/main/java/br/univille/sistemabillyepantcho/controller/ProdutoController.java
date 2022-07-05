package br.univille.sistemabillyepantcho.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.CarroDTO;
import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.service.CarroService;
import br.univille.sistemabillyepantcho.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ModelAndView index() {
        List<ProdutoDTO> listaProduto = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos", listaProduto);
    }


    @GetMapping("/novo")
    public ModelAndView novo(Model model) {
        ProdutoDTO produto = new ProdutoDTO();
        List<CarroDTO> listaCarro = carroService.getAll();
        model.addAttribute("produto", produto);
        model.addAttribute("listaCarro", listaCarro);
        model.addAttribute("compatibilidadeselecionada", 0);
        return new ModelAndView("produto/form");
    }

    @PostMapping(params = {"save"})
    public ModelAndView save(ProdutoDTO produto, Long compatibilidadeselecionada) {
        service.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @PostMapping(params = {"additem"})
    public ModelAndView addItem(ProdutoDTO produto, Long compatibilidadeselecionada) {
        List<CarroDTO> listaCarro = carroService.getAll();
        HashMap <String, Object> dados = new HashMap<>();
        dados.put("listaCarro", listaCarro);
        //produto.getCompatibilidade().add(compatibilidadeselecionada);
        dados.put("produto", produto);
        dados.put("compatibilidadeselecionada", compatibilidadeselecionada);
        return new ModelAndView("produto/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        ProdutoDTO produto = service.buscarPeloId(id);
        return new ModelAndView("produto/form", "produto", produto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/produto");
    }
    
    
}
