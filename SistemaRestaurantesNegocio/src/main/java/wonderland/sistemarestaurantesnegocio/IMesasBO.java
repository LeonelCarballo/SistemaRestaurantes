/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.List;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.NuevaMesaDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IMesasBO {
    
    public abstract List<Mesa> agregarMesas(NuevaMesaDTO nuevaMesa) throws NegocioException;
    
    public abstract List<Mesa> mostrarMesas() throws NegocioException;
    
    public abstract Mesa cambiarEstadoMesa(Long idMesa, EstadoMesa nuevoEstado) throws NegocioException;
}
