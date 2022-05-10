package br.univlle.sistemabillyepantcho.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Cliente cliente;
    private Veiculo veiculo;
    private ArrayList<ItensOrdemDeServico> itensDeServico = new ArrayList<>();
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public ArrayList<ItensOrdemDeServico> getItensDeServico() {
        return itensDeServico;
    }
    public void setItensDeServico(ArrayList<ItensOrdemDeServico> itensDeServico) {
        this.itensDeServico = itensDeServico;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
