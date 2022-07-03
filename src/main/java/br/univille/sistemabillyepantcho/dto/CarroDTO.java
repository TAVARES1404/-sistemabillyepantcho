package br.univille.sistemabillyepantcho.dto;

public class CarroDTO {

    private long id;
    private String Marca;
    private String modelo;
    private String motor;
    
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
     * @return the marca
     */
    public String getMarca() {
        return Marca;
    }
    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        Marca = marca;
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
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }
    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }


    
}
