/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IClientesDAO;

/**
 *
 * Clase para implementar las reglas de negocio
 * al manejar los metodos de las DAOs de clientes
 */
public class ClientesBO implements IClientesBO {
    
    private IClientesDAO clientesDAO;
    
    private static final int LIMITE_CARACTERES_NOMBRE = 100;
    private static final int LIMITE_CARACTERES_CORREO_ELECTRONICO = 100;
    private static final int LIMITE_CARACTERES_TELEFONO = 20;
    private static final int LIMITE_CARACTERES = 100;
    
    public ClientesBO(IClientesDAO clientesDAO){
        this.clientesDAO = clientesDAO;
    }

    @Override
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) throws NegocioException {
        
        //validaciones de campos obligatorios
        if (nuevoCliente.getNombre() == null || nuevoCliente.getNombre().trim().isEmpty()) {
            throw new NegocioException ("Debes proporcionar el nombre del cliente");
        }
        
        if (nuevoCliente.getApellidoPaterno() == null || nuevoCliente.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException ("Debes proporcionar el apellido paterno del cliente");
        }
        
        if (nuevoCliente.getApellidoMaterno() == null) {
            throw new NegocioException ("Debes proporcionar el apellido materno del cliente");
        }
        
        if (nuevoCliente.getTelefono() == null || nuevoCliente.getTelefono().trim().isEmpty()) {
            throw new NegocioException ("Debes proporcionar el telefono del cliente");
        }
        
        // validaciones de longitud
        if (nuevoCliente.getNombre().length() > LIMITE_CARACTERES_NOMBRE ){
            throw new NegocioException ("El Nombre del cliente Excede el limite de " + LIMITE_CARACTERES_NOMBRE);
        }
        
        if (nuevoCliente.getApellidoPaterno().length() > LIMITE_CARACTERES_NOMBRE ){
            throw new NegocioException ("El Nombre del cliente Excede el limite de " + LIMITE_CARACTERES_NOMBRE);
        }
        
        if (nuevoCliente.getApellidoMaterno().length() > LIMITE_CARACTERES_NOMBRE ){
            throw new NegocioException ("El Nombre del cliente Excede el limite de " + LIMITE_CARACTERES_NOMBRE);
        }
        
        if (nuevoCliente.getCorreoElectronico().length() > LIMITE_CARACTERES_CORREO_ELECTRONICO ){
            throw new NegocioException ("El Nombre del cliente Excede el limite de " + LIMITE_CARACTERES_NOMBRE);
        }
        
        if (nuevoCliente.getTelefono().length() > LIMITE_CARACTERES_TELEFONO ){
            throw new NegocioException ("El Nombre del cliente Excede el limite de " + LIMITE_CARACTERES_NOMBRE);
        }
        
        // validacion formato correo
        String correo = nuevoCliente.getCorreoElectronico();
        if (correo != null && !correo.trim().isEmpty()) {
            if (correo.length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
                throw new NegocioException("El correo electrónico excede el límite de " + LIMITE_CARACTERES_CORREO_ELECTRONICO + " caracteres.");
            }
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                throw new NegocioException("El formato del correo electrónico no es válido.");
            }
        }
        
        return this.clientesDAO.registrarCliente(nuevoCliente);
    }

    @Override
    public List<Cliente> consultarClientesPorNombre(String filtroBusqueda) throws NegocioException {
        if (filtroBusqueda.length() > LIMITE_CARACTERES) {
                    throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                }
                return this.clientesDAO.consultarClientesPorNombre(filtroBusqueda);
    }

    @Override
    public List<Cliente> consultarClientesPorTelefono(String filtroBusqueda) throws NegocioException {
        if (filtroBusqueda.length() > LIMITE_CARACTERES_TELEFONO) {
                    throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                }
                return this.clientesDAO.consultarClientesPorTelefono(filtroBusqueda);
    }

    @Override
    public List<Cliente> consultarClientesPorCorreoElectronico(String filtroBusqueda) throws NegocioException {
        if (filtroBusqueda.length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
                    throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                }
                return this.clientesDAO.consultarClientesPorCorreoElectronico(filtroBusqueda);
    }

    @Override
    public List<Cliente> obtenerClientes() throws NegocioException {
        
        return this.clientesDAO.obtenerClientes();
    }
    
    
    
    
}
