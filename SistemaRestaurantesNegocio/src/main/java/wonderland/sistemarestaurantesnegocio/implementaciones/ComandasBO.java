/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IComandasDAO;

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
        return this.comandasDAO.asociarClienteAComanda(comanda, cliente);
    }

    @Override
    public Comanda crearNuevaComanda(NuevaComandaDTO nuevaComanda) throws NegocioException {
        return this.comandasDAO.crearNuevarComanda(nuevaComanda);
    }

    @Override
    public Comanda obtenerComandaPorId(Long idComanda) throws NegocioException {
        return this.comandasDAO.obtenerComandaPorId(idComanda);
    }

    @Override
    public ComandaDTO obtenerComandaActivaPorMesa(Long idMesa) throws NegocioException {
        return this.comandasDAO.obtenerComandaActivaPorMesa(idMesa);
    }

    @Override
    public Comanda modificarEstadoComanda(ComandaDTO comandaDTO) throws NegocioException {
        return this.comandasDAO.modificarEstadoComanda(comandaDTO);
    }

    @Override
    public Comanda cancelarComanda(ComandaDTO comandaDTO) throws NegocioException {
        return this.comandasDAO.cancelarComanda(comandaDTO);
    }
    
}
