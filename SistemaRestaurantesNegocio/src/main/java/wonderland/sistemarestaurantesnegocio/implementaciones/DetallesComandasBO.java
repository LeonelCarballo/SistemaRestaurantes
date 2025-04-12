/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IDetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IDetallesComandasDAO;

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
        return this.detallesComandasDAO.guardarDetalleComanda(detalleComandaDTO);
    }

    @Override
    public List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) throws NegocioException {
        return this.detallesComandasDAO.obtenerDetalleComandaPorComanda(comandaDTO);
    }

    @Override
    public void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado) throws NegocioException {
       this.detallesComandasDAO.editarDetalleComanda(idComanda, productoSeleccionado);
    }

    @Override
    public DetalleComanda ActualizarDetallesComanda(DetalleComandaDTO detalleComandaDTO) throws NegocioException {
        return this.detallesComandasDAO.ActualizarDetallesComanda(detalleComandaDTO);
    }

    @Override
    public List<DetalleComandaDTO> obtenerDetallesDTOPorComanda(ComandaDTO comandaDTO) throws NegocioException {
        return this.detallesComandasDAO.obtenerDetallesDTOPorComanda(comandaDTO);
    }
  
}
