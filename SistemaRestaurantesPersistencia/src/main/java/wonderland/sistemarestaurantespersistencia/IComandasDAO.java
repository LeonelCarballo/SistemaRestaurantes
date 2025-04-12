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

/**
 *
 * @author Dana Chavez
 */
public interface IComandasDAO {
    public abstract Comanda crearNuevarComanda(NuevaComandaDTO nuevaComanda);
    
    public abstract Comanda asociarClienteAComanda(Comanda comanda, ClienteFrecuente cliente);
    
    public abstract Comanda obtenerComandaPorId(Long idComanda);
    
    public abstract ComandaDTO obtenerComandaActivaPorMesa(Long idMesa);
    
    public abstract Comanda modificarEstadoComanda(ComandaDTO comandaDTO);
    
    public abstract Comanda cancelarComanda(ComandaDTO comandaDTO);
    
    public abstract List<ComandaDTO> obtenerComandas();
    
    public abstract List<ComandaDTO> obtenerComandasPorFechas(Calendar fechaInicio, Calendar fechaFin);
    
    //public abstract Comanda editarComanda(ComandaDTO comandaDTO);
}
