package br.univlle.sistemabillyepantcho.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ItensOrdemDeServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int codProduto;
    private int qtdFaturado;
    private float valorTotalItem;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="produto_id")
    private List<Produto> produtos = new ArrayList<>();
    
    public long getId() {
        return id;
    }

  
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    public int getQtdFaturado() {
        return qtdFaturado;
    }
    public void setQtdFaturado(int qtdFaturado) {
        this.qtdFaturado = qtdFaturado;
    }
    public float getValorTotalItem() {
        return valorTotalItem;
    }
    public void setValorTotalItem(float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
    
    
}

