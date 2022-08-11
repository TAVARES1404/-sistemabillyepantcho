package br.univille.sistemabillyepantcho.dto;

import br.univille.sistemabillyepantcho.entity.Produto;

public class ItensOrdemDeServicoDTO {

    private long id;
    private int codProduto;
    private int qtdFaturado;
    private float valorTotalItem;
    private Produto produto;
    
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
     * @return the codProduto
     */
    public int getCodProduto() {
        return codProduto;
    }
    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    /**
     * @return the qtdFaturado
     */
    public int getQtdFaturado() {
        return qtdFaturado;
    }
    /**
     * @param qtdFaturado the qtdFaturado to set
     */
    public void setQtdFaturado(int qtdFaturado) {
        this.qtdFaturado = qtdFaturado;
    }
    /**
     * @return the valorTotalItem
     */
    public float getValorTotalItem() {
        return valorTotalItem;
    }
    /**
     * @param valorTotalItem the valorTotalItem to set
     */
    public void setValorTotalItem(float valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }
    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    

    
}
