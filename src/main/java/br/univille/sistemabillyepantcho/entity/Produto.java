package br.univille.sistemabillyepantcho.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeProduto;
    private String marcaProduto;
    private int codigoProduto;
    private float valorProduto;
    private int quantidadeProduto;
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name ="produto_id")
    private List<Carro> compatibilidade = new ArrayList<>();
    
    /**
     * @return the quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    /**
     * @param quantidadeProduto the quantidadeProduto to set
     */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getMarcaProduto() {
        return marcaProduto;
    }
    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
    public List<Carro> getCompatibilidade() {
        return compatibilidade;
    }
    public void setCompatibilidade(List<Carro> compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    


    
}
