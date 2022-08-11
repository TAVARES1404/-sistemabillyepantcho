package br.univille.sistemabillyepantcho.dto;

import br.univille.sistemabillyepantcho.entity.Cliente;

public class VeiculoDTO {

    private long id;
    private long clienteId;
    private Cliente cliente;
    private String modelo;
    private String marca;
    private String cor;
    private String placa;

    
    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    private float kilometragem;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }
    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }
    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    /**
     * @return the kilometragem
     */
    public float getKilometragem() {
        return kilometragem;
    }
    /**
     * @param kilometragem the kilometragem to set
     */
    public void setKilometragem(float kilometragem) {
        this.kilometragem = kilometragem;
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

    

    
    
}
