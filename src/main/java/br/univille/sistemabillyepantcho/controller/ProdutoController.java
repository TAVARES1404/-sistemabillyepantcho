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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView novo() {
        ProdutoDTO produto = new ProdutoDTO();
        List<CarroDTO> listaCarro = carroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaCarro", listaCarro);
        dados.put("compatibilidadeselecionada", 0);
        return new ModelAndView("produto/form",dados);
    }

    @PostMapping(params = {"save"})
    public ModelAndView save(ProdutoDTO produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @PostMapping(params = {"additem"})
    public ModelAndView addItem(ProdutoDTO produto) {
        List<CarroDTO> listaCarro = carroService.getAll();
        HashMap <String, Object> dados = new HashMap<>();
        dados.put("listaCarro", listaCarro);
        produto.getCompatibilidade().add(carroService.buscarPeloId(produto.getIdCompatibilidade()));
        dados.put("produto", produto);
        return new ModelAndView("produto/form",dados);
    }
    @PostMapping(params = {"remove"})
    public ModelAndView remove(@RequestParam(name = "remove") int index, ProdutoDTO produto) {
        List<CarroDTO> listaCarro = carroService.getAll();
        HashMap <String, Object> dados = new HashMap<>();
        dados.put("listaCarro", listaCarro);
        produto.getCompatibilidade().remove(index);
        dados.put("produto", produto);
        return new ModelAndView("produto/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        ProdutoDTO produto = service.buscarPeloId(id);
        List<CarroDTO> listaCarro = carroService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaCarro", listaCarro);
        dados.put("compatibilidadeselecionada", 0);
        return new ModelAndView("produto/form",dados);
        
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/produto");
    }
    
    
}
