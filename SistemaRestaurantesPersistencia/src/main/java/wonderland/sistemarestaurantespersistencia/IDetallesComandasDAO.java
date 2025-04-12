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
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public interface IDetallesComandasDAO {
    
    public abstract DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComanda) throws PersistenciaException;
    
    public abstract DetalleComanda guardarDetallesComandas(List<DetalleComandaDTO> detalleComanda) throws PersistenciaException;
    
    public abstract List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) throws PersistenciaException;
    
    public abstract void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado) throws PersistenciaException;
    
    public abstract DetalleComanda ActualizarDetallesComanda(DetalleComandaDTO detalleComandaDTO) throws PersistenciaException;
}
