package br.univille.sistemabillyepantcho.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.univille.sistemabillyepantcho.entity.Cliente;
import br.univille.sistemabillyepantcho.entity.ItensOrdemDeServico;
import br.univille.sistemabillyepantcho.entity.Veiculo;

public class OrdemDeServicoDTO {

    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private Cliente cliente;
    private long clienteId;
    private Veiculo veiculo;
    private long veiculoId;
    private List<ItensOrdemDeServico> listaDeServico = new ArrayList<>();

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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }
    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    /**
     * @return the listaDeServico
     */
    public List<ItensOrdemDeServico> getListaDeServico() {
        return listaDeServico;
    }
    /**
     * @param listaDeServico the listaDeServico to set
     */
    public void setListaDeServico(List<ItensOrdemDeServico> listaDeServico) {
        this.listaDeServico = listaDeServico;
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

    
    
}
