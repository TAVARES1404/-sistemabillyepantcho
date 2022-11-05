package br.univille.sistemabillyepantcho.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

@Entity
public class ItensOrdemDeServico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //private int codProduto;
    private int qtdFaturado;
    private float valorTotalItem;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Produto produto;
    
    public long getId() {
        return id;
    }
    

    public void setId(long id) {
        this.id = id;
    }
    /*public int getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }*/
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


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}

