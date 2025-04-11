/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.List;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IDetallesComandasBO {
    
    public DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComandaDTO) throws NegocioException;
    
    public abstract List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) throws NegocioException;
    
    public abstract void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado) throws NegocioException;
}
