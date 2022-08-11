package br.univille.sistemabillyepantcho.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.service.ClienteService;
import br.univille.sistemabillyepantcho.service.OrdemDeServicoService;
import br.univille.sistemabillyepantcho.service.ProdutoService;
import br.univille.sistemabillyepantcho.service.VeiculoService;

@Controller
@RequestMapping("/ordemdeservico")
public class OrdemDeServicoController {

    @Autowired
    private OrdemDeServicoService service;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ModelAndView index() {
        List<OrdemDeServicoDTO> listaOrdemDeServico = service.getAll();
        return new ModelAndView("ordemdeservico/index", "listaOrdemDeServico", listaOrdemDeServico);
    }
    @GetMapping("/novo")
    public ModelAndView novo() {
        OrdemDeServicoDTO ordemDeServico = new OrdemDeServicoDTO();
        List<ClienteDTO> listaClientes = clienteService.getAll();
        List<VeiculoDTO> listaVeiculos = veiculoService.getAll();
        List<ProdutoDTO> listaProduto = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("ordemdeservico", ordemDeServico);
        dados.put("listaclientes", listaClientes);
        dados.put("listaveiculos", listaVeiculos);
        dados.put("listaproduto", listaProduto);
        //dados.put("compatibilidadeselecionada", 0);
        return new ModelAndView("ordemdeservico/form",dados);
    }
    
}
