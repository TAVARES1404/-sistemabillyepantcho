package br.univlle.sistemabillyepantcho.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeProduto;
    private String marcaProduto;
    private int codigoProduto;
    private float valorProduto;
    private ArrayList<String> compatibilidade = new ArrayList<>();
    
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
    public ArrayList<String> getCompatibilidade() {
        return compatibilidade;
    }
    public void setCompatibilidade(ArrayList<String> compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    


    
}
