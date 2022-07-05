package br.univille.sistemabillyepantcho.dto;

import java.util.ArrayList;
import java.util.List;

import br.univille.sistemabillyepantcho.entity.Carro;

public class ProdutoDTO {

    private long id;
    private String nomeProduto;
    private String marcaProduto;
    private int codigoProduto;
    private float valorProduto;
    private List<CarroDTO> compatibilidade = new ArrayList<>();
    
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
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }
    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    /**
     * @return the marcaProduto
     */
    public String getMarcaProduto() {
        return marcaProduto;
    }
    /**
     * @param marcaProduto the marcaProduto to set
     */
    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }
    /**
     * @return the codigoProduto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }
    /**
     * @param codigoProduto the codigoProduto to set
     */
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    /**
     * @return the valorProduto
     */
    public float getValorProduto() {
        return valorProduto;
    }
    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }
    /**
     * @return the compatibilidade
     */
    public List<CarroDTO> getCompatibilidade() {
        return compatibilidade;
    }
    /**
     * @param compatibilidade the compatibilidade to set
     */
    public void setCompatibilidade(List<CarroDTO> compatibilidade) {
        this.compatibilidade = compatibilidade;
    }
    

    
    
}
