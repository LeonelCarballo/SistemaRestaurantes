/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IDetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IDetallesComandasDAO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public class DetallesComandasBO implements IDetallesComandasBO {
    
    private IDetallesComandasDAO detallesComandasDAO;

    public DetallesComandasBO(IDetallesComandasDAO detallesComandasDAO) {
        this.detallesComandasDAO = detallesComandasDAO;
    }


    @Override
    public DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComandaDTO) throws NegocioException {
        try {
            return this.detallesComandasDAO.guardarDetalleComanda(detalleComandaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) throws NegocioException {
        try {
            return this.detallesComandasDAO.obtenerDetalleComandaPorComanda(comandaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado) throws NegocioException {
        try {
            this.detallesComandasDAO.editarDetalleComanda(idComanda, productoSeleccionado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public DetalleComanda ActualizarDetallesComanda(DetalleComandaDTO detalleComandaDTO) throws NegocioException {
        try {
            return this.detallesComandasDAO.ActualizarDetallesComanda(detalleComandaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

   
    
}
