/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesdominio.dtos;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.EstadoComanda;
import wonderland.sistemarestaurantesdominio.Mesa;

/**
 *
 * @author Dana Chavez
 */
public class ComandaDTO {
    private Long id;
    private String folio;
    private EstadoComanda estadoComanda;
    private Mesa mesa;
    private Cliente cliente;
    private List<DetalleComanda> detallesComandas;

    public ComandaDTO() {
    }

    public ComandaDTO(Long id) {
        this.id = id;
    }

    public ComandaDTO(Long id, String folio, EstadoComanda estadoComanda, Mesa mesa, Cliente cliente, List<DetalleComanda> detallesComandas) {
        this.id = id;
        this.folio = folio;
        this.estadoComanda = estadoComanda;
        this.mesa = mesa;
        this.cliente = cliente;
        this.detallesComandas = detallesComandas;
    }

    public Long getId() {
        return id;
    }

    public String getFolio() {
        return folio;
    }

    public EstadoComanda getEstadoComanda() {
        return estadoComanda;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleComanda> getDetallesComandas() {
        return detallesComandas;
    }
    
    
    
}
