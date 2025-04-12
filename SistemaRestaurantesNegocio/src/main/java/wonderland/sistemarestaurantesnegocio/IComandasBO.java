/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.Calendar;
import java.util.List;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IComandasBO {
    
    public abstract Comanda crearNuevaComanda(NuevaComandaDTO nuevaComanda) throws NegocioException;
    
    public abstract Comanda asociarClienteAComanda(Comanda comanda, ClienteFrecuente cliente) throws NegocioException;
    
    public abstract Comanda obtenerComandaPorId(Long idComanda) throws NegocioException;
    
    public abstract ComandaDTO obtenerComandaActivaPorMesa(Long idMesa) throws NegocioException;
    
    public abstract Comanda modificarEstadoComanda(ComandaDTO comandaDTO) throws NegocioException;
    
    public abstract Comanda cancelarComanda(ComandaDTO comandaDTO) throws NegocioException;
    
    public abstract List<ComandaDTO> obtenerComandas() throws NegocioException;
    
    public abstract List<ComandaDTO> obtenerComandasPorFechas(Calendar fechaInicio, Calendar fechaFin) throws NegocioException;
    
    
}
