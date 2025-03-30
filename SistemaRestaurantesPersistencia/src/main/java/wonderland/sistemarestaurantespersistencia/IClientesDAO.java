/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(NuevoClienteDTO nuevoCliente);
    
    public abstract List<Cliente> consultarClientesPorNombre(String filtroBusqueda);
    
    public abstract List<Cliente> consultarClientesPorTelefono(String filtroBusqueda);
    
    public abstract List<Cliente> consultarClientesPorCorreoElectronico(String filtroBusqueda);
    
    
}
