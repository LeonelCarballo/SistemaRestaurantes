/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesdominio.dtos;

import wonderland.sistemarestaurantesdominio.UnidadMedida;

/**
 *
 * @author leoca
 */
public class NuevoIngredienteDTO {
    
    private String nombre;
    private Float stock;
    private UnidadMedida unidadMedida;

    public NuevoIngredienteDTO(String nombre, Float stock, UnidadMedida unidadMedida) {
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getStock() {
        return stock;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }
    
    
    
}
