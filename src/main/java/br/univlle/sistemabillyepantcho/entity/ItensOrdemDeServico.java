package br.univlle.sistemabillyepantcho.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ItensOrdemDeServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int codProduto;
    private int qtdFaturado;
    private float valorTotalItem;
    private Produto produto;
    
    public long getId() {
        return id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
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

