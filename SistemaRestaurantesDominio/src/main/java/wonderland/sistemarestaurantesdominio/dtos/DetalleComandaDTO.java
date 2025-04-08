/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesdominio.dtos;

import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.Producto;

/**
 *
 * @author payde
 */
public class DetalleComandaDTO {
    
    private Long idDetalleComanda;
    private Integer cantidadProducto;
    private Float precio;
    private String nota;
    private Producto producto;
    private Comanda comanda;

    public DetalleComandaDTO() {
    }

    public DetalleComandaDTO(Long idDetalleComanda, Integer cantidadProducto, Float precio, String nota, Producto producto, Comanda comanda) {
        this.idDetalleComanda = idDetalleComanda;
        this.cantidadProducto = cantidadProducto;
        this.precio = precio;
        this.nota = nota;
        this.producto = producto;
        this.comanda = comanda;
    }

    public Long getIdDetalleComanda() {
        return idDetalleComanda;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getNota() {
        return nota;
    }

    public Producto getProducto() {
        return producto;
    }

    public Comanda getComanda() {
        return comanda;
    }
    
    
    
}
