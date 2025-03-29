/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;

/**
 *
 * @author Dana Chavez
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(NuevoClienteDTO nuevoCliente);
    
}
