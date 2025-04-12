/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IComandasDAO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public class ComandasBO implements IComandasBO {
    
    private IComandasDAO comandasDAO;

    public ComandasBO(IComandasDAO comandasDAO) {
        this.comandasDAO = comandasDAO;
    }
    
    @Override
    public Comanda asociarClienteAComanda(Comanda comanda, ClienteFrecuente cliente) throws NegocioException {
        try {
            return this.comandasDAO.asociarClienteAComanda(comanda, cliente);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public Comanda crearNuevaComanda(NuevaComandaDTO nuevaComanda) throws NegocioException {
        try {
            return this.comandasDAO.crearNuevarComanda(nuevaComanda);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public Comanda obtenerComandaPorId(Long idComanda) throws NegocioException {
        try {
            return this.comandasDAO.obtenerComandaPorId(idComanda);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public ComandaDTO obtenerComandaActivaPorMesa(Long idMesa) throws NegocioException {
        try {
            return this.comandasDAO.obtenerComandaActivaPorMesa(idMesa);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public Comanda modificarEstadoComanda(ComandaDTO comandaDTO) throws NegocioException {
        try {
            return this.comandasDAO.modificarEstadoComanda(comandaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public Comanda cancelarComanda(ComandaDTO comandaDTO) throws NegocioException {
        try {
            return this.comandasDAO.cancelarComanda(comandaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public List<ComandaDTO> obtenerComandas() throws NegocioException {
        try {
            return this.comandasDAO.obtenerComandas();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }

    @Override
    public List<ComandaDTO> obtenerComandasPorFechas(Calendar fechaInicio, Calendar fechaFin) throws NegocioException {
        try {
            return this.comandasDAO.obtenerComandasPorFechas(fechaInicio, fechaFin);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
    
}
