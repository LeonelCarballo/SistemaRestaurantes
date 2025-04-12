/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.Calendar;
import java.util.List;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IComandasDAO {
    public abstract Comanda crearNuevarComanda(NuevaComandaDTO nuevaComanda) throws PersistenciaException;
    
    public abstract Comanda asociarClienteAComanda(Comanda comanda, ClienteFrecuente cliente) throws PersistenciaException;
    
    public abstract Comanda obtenerComandaPorId(Long idComanda) throws PersistenciaException;
    
    public abstract ComandaDTO obtenerComandaActivaPorMesa(Long idMesa) throws PersistenciaException;
    
    public abstract Comanda modificarEstadoComanda(ComandaDTO comandaDTO) throws PersistenciaException;
    
    public abstract Comanda cancelarComanda(ComandaDTO comandaDTO) throws PersistenciaException;
    
    public abstract List<ComandaDTO> obtenerComandas() throws PersistenciaException;
    
    public abstract List<ComandaDTO> obtenerComandasPorFechas(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException;

}
