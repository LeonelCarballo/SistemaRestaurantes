/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IClientesBO {
    
    public abstract Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;
    
    public abstract List<Cliente> consultarClientesPorNombre(String filtroBusqueda) throws NegocioException;
    
    public abstract List<Cliente> consultarClientesPorTelefono(String filtroBusqueda) throws NegocioException;
    
    public abstract List<Cliente> consultarClientesPorCorreoElectronico(String filtroBusqueda) throws NegocioException;
    
    public abstract List<Cliente> obtenerClientes() throws NegocioException;
    
    public abstract Cliente editarCliente(ClienteDTO clienteDTO) throws NegocioException;
    
    public abstract Cliente buscarClientePorId(Long id) throws NegocioException;
    
}
