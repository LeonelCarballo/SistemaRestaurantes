/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
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
    
}
