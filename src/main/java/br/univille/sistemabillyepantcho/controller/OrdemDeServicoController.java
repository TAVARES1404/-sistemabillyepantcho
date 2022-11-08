package br.univille.sistemabillyepantcho.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemabillyepantcho.dto.ClienteDTO;
import br.univille.sistemabillyepantcho.dto.ItensOrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.dto.OrdemDeServicoDTO;
import br.univille.sistemabillyepantcho.dto.ProdutoDTO;
import br.univille.sistemabillyepantcho.dto.VeiculoDTO;
import br.univille.sistemabillyepantcho.entity.Cliente;
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
        ItensOrdemDeServicoDTO itensOrdemdeServico = new ItensOrdemDeServicoDTO();
        List<ClienteDTO> listaClientes = clienteService.getAll();
        List<VeiculoDTO> listaVeiculos = veiculoService.getAll();
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("ordemdeservico", ordemDeServico);
        dados.put("item", itensOrdemdeServico);
        dados.put("listaclientes", listaClientes);
        dados.put("listaveiculos", listaVeiculos);
        dados.put("listaprodutos", listaProdutos);
        return new ModelAndView("ordemdeservico/form",dados);
    }

    @PostMapping(params="buscar")
    public ModelAndView buscarVeic(@ModelAttribute("ordemdeservico") OrdemDeServicoDTO ordemdeservico){

        List<ClienteDTO> listaClientes = clienteService.getAll();
        List<VeiculoDTO> listaVeiculos = veiculoService.buscarVeic(ordemdeservico.getClienteId());
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listaclientes", listaClientes);
        dados.put("listaveiculos", listaVeiculos);
        dados.put("listaprodutos", listaProdutos);
        dados.put("item", new ItensOrdemDeServicoDTO());
        
        return new ModelAndView("ordemdeservico/form", dados);
    }
    @PostMapping(params="additem")
    public ModelAndView addItem(@ModelAttribute("ordemdeservico") OrdemDeServicoDTO ordemdeservico, 
    @ModelAttribute("item") ItensOrdemDeServicoDTO item){

        ProdutoDTO p = produtoService.buscarPeloId(item.getIdProduto());
        if (p.getQuantidadeProduto() > 0){

            item.setProduto(produtoService.buscarPeloId(item.getIdProduto()));
            item.setValorTotalItem(item.getQtdFaturado()*item.getProduto().getValorProduto());
            ordemdeservico.getListaDeServico().add(item);
            List<ClienteDTO> listaClientes = clienteService.getAll();
            List<VeiculoDTO> listaVeiculos = veiculoService.buscarVeic(ordemdeservico.getClienteId());
            List<ProdutoDTO> listaProdutos = produtoService.getAll();
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("item", new ItensOrdemDeServicoDTO());
            dados.put("listaclientes", listaClientes);
            dados.put("listaveiculos", listaVeiculos);
            dados.put("listaprodutos", listaProdutos);
            
            
            
            return new ModelAndView("ordemdeservico/form", dados);
        }else{
            return new ModelAndView("redirect:/ordemdeservico");
        }
    }

    @PostMapping(params="save")
    public ModelAndView save(@ModelAttribute("ordemdeservico") OrdemDeServicoDTO ordemdeservico){
        ordemdeservico.setCliente(clienteService.buscarPeloId(ordemdeservico.getClienteId()));
        ordemdeservico.setVeiculo(veiculoService.buscarPeloId(ordemdeservico.getVeiculoId()));
        service.save(ordemdeservico);
        return new ModelAndView("redirect:/ordemdeservico");
    }

    @PostMapping(params = {"removeitem"})
    public ModelAndView remove(@RequestParam(name = "removeitem") int index, OrdemDeServicoDTO ordemDeServico) {
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        List<ClienteDTO> listaClientes = clienteService.getAll();
        List<VeiculoDTO> listaVeiculos = veiculoService.buscarVeic(ordemDeServico.getClienteId());
        ItensOrdemDeServicoDTO itensOrdemdeServico = new ItensOrdemDeServicoDTO();
        HashMap <String, Object> dados = new HashMap<>();
        dados.put("listaprodutos", listaProdutos);
        dados.put("item", itensOrdemdeServico);
        dados.put("listaveiculos", listaVeiculos);
        dados.put("listaclientes", listaClientes);
        ordemDeServico.getListaDeServico().remove(index);
        dados.put("ordemdeservico", ordemDeServico);
        return new ModelAndView("ordemDeServico/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {

        OrdemDeServicoDTO ordemDeServico = service.buscarPeloId(id);
        ItensOrdemDeServicoDTO itensOrdemdeServico = new ItensOrdemDeServicoDTO();
        List<ClienteDTO> listaClientes = clienteService.getAll();
        List<VeiculoDTO> listaVeiculos = veiculoService.getAll();
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("ordemdeservico", ordemDeServico);
        dados.put("item", itensOrdemdeServico);
        dados.put("listaclientes", listaClientes);
        dados.put("listaveiculos", listaVeiculos);
        dados.put("listaprodutos", listaProdutos);
        return new ModelAndView("ordemdeservico/form",dados);
        
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/ordemdeservico");
    }

    
    
}
