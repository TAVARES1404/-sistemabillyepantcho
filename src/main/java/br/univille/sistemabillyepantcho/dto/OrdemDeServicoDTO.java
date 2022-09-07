package br.univille.sistemabillyepantcho.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class OrdemDeServicoDTO {

    private long id;
    private long produtoId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private ClienteDTO cliente;
    private long clienteId;
    private VeiculoDTO veiculo;
    /**
     * @return the veiculo
     */
    public VeiculoDTO getVeiculo() {
        return veiculo;
    }
    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(VeiculoDTO veiculo) {
        this.veiculo = veiculo;
    }
    private long veiculoId;
    private List<ItensOrdemDeServicoDTO> listaDeServico = new ArrayList<>();

    
    /**
     * 
     * @return the produtoId
     */
    public long getProdutoId() {
        return produtoId;
    }
    /**
     * @param produtoId the produtoId to set
     */
    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    /**
     * @return the clienteId
     */
    public long getClienteId() {
        return clienteId;
    }
    /**
     * @param clienteId the clienteId to set
     */
    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }
    /**
     * @return the veiculoId
     */
    public long getVeiculoId() {
        return veiculoId;
    }
    /**
     * @param veiculoId the veiculoId to set
     */
    public void setVeiculoId(long veiculoId) {
        this.veiculoId = veiculoId;
    }
    /**
     * @return the listaDeServico
     */
    public List<ItensOrdemDeServicoDTO> getListaDeServico() {
        return listaDeServico;
    }
    /**
     * @param listaDeServico the listaDeServico to set
     */
    public void setListaDeServico(List<ItensOrdemDeServicoDTO> listaDeServico) {
        this.listaDeServico = listaDeServico;
    }
    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    
    
}
