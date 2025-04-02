/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public interface IClientesFrecuentesDAO {
    
    public abstract ClienteFrecuente registrarCliente(NuevoClienteFrecuenteDTO nuevoCliente);
    
    public abstract List<ClienteFrecuente> consultarClientesPorNombre(String filtroBusqueda);
    
    public abstract List<ClienteFrecuente> consultarClientesPorTelefono(String filtroBusqueda);
    
    public abstract List<ClienteFrecuente> consultarClientesPorCorreoElectronico(String filtroBusqueda);
    
    public abstract List<ClienteFrecuente> obtenerClientes();
    
    public abstract ClienteFrecuente editarCliente(ClienteFrecuenteDTO clienteDTO);
    
    public abstract ClienteFrecuente buscarClientePorId(Long idCliente);
    
    
}
