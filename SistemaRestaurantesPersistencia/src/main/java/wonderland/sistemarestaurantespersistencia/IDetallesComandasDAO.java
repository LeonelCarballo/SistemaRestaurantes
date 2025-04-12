/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author payde
 */
public interface IDetallesComandasDAO {
    
    public abstract DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComanda);
    
    public abstract DetalleComanda guardarDetallesComandas(List<DetalleComandaDTO> detalleComanda);
    
    public abstract List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO);
    
    public abstract void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado);
    
    public abstract DetalleComanda ActualizarDetallesComanda(DetalleComandaDTO detalleComandaDTO);
    
    public abstract List<DetalleComandaDTO> obtenerDetallesDTOPorComanda(ComandaDTO comandaDTO);
}
