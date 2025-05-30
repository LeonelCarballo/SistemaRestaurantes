/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.Calendar;
import java.util.List;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.VistaFidelidadCliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IClientesBO {
    
    public abstract ClienteFrecuente registrarCliente(NuevoClienteFrecuenteDTO nuevoCliente) throws NegocioException;
    
    public abstract List<ClienteFrecuente> consultarClientesPorNombre(String filtroBusqueda) throws NegocioException;
    
    public abstract List<ClienteFrecuente> consultarClientesPorTelefono(String filtroBusqueda) throws NegocioException;
    
    public abstract List<ClienteFrecuente> consultarClientesPorCorreoElectronico(String filtroBusqueda) throws NegocioException;
    
    public abstract List<ClienteFrecuente> obtenerClientes() throws NegocioException;
    
    public abstract ClienteFrecuente editarCliente(ClienteFrecuenteDTO clienteDTO) throws NegocioException;
    
    public abstract ClienteFrecuente buscarClientePorId(Long id) throws NegocioException;

    public abstract ClienteFrecuenteDTO obtenerClientesConFidelidad(ClienteFrecuente cliente) throws NegocioException;
    
    public abstract ClienteFrecuenteDTO obtenerDatosFidelidad(Long idCliente) throws NegocioException;
    
    public abstract Calendar obtenerUltimaVisita(Long idCliente) throws NegocioException;
}
