/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.NuevaMesaDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IMesasDAO {
    
    public abstract List<Mesa> agregarMesas(NuevaMesaDTO nuevaMesa) throws PersistenciaException;
    
    public abstract List<Mesa> mostrarMesas() throws PersistenciaException;
    
    public abstract Mesa cambiarEstadoMesa(Long idMesa, EstadoMesa nuevaMesa) throws PersistenciaException;
     
}
