/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import wonderland.sistemarestaurantesdominio.Cliente;
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
    
    
}
