/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.NuevaMesaDTO;
import wonderland.sistemarestaurantesnegocio.IMesasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IMesasDAO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public class MesasBO implements IMesasBO {
    
    private IMesasDAO mesasDAO;
    
    public static final int LIMITE_MESAS = 80;
    
    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }

    @Override
    public List<Mesa> agregarMesas(NuevaMesaDTO nuevaMesa) throws NegocioException {
        try {
            return mesasDAO.agregarMesas(nuevaMesa);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public List<Mesa> mostrarMesas() throws NegocioException {
        
        try {
            return this.mesasDAO.mostrarMesas();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public Mesa cambiarEstadoMesa(Long idMesa, EstadoMesa nuevoEstado) throws NegocioException {
        try {
            return this.mesasDAO.cambiarEstadoMesa(idMesa, nuevoEstado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }  
}
