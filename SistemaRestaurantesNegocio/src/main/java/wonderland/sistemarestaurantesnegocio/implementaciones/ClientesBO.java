/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteDTO;
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

        // Validaciones de campos obligatorios
        if (nuevoCliente.getNombre() == null || nuevoCliente.getNombre().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el nombre del cliente");
        }

        if (nuevoCliente.getApellidoPaterno() == null || nuevoCliente.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el apellido paterno del cliente");
        }

        if (nuevoCliente.getApellidoMaterno() == null || nuevoCliente.getApellidoMaterno().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el apellido materno del cliente");
        }

        if (nuevoCliente.getTelefono() == null || nuevoCliente.getTelefono().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el teléfono del cliente");
        }

        // Validaciones de formato (solo letras para nombre y apellidos)
        if (!nuevoCliente.getNombre().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El nombre solo puede contener letras");
        }

        if (!nuevoCliente.getApellidoPaterno().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido paterno solo puede contener letras");
        }

        if (!nuevoCliente.getApellidoMaterno().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido materno solo puede contener letras");
        }

        // Validaciones de longitud
        if (nuevoCliente.getNombre().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El nombre del cliente excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (nuevoCliente.getApellidoPaterno().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El apellido paterno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (nuevoCliente.getApellidoMaterno().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El apellido materno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (nuevoCliente.getCorreoElectronico().length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
            throw new NegocioException("El correo electrónico excede el límite de " + LIMITE_CARACTERES_CORREO_ELECTRONICO + " caracteres.");
        }

        if (nuevoCliente.getTelefono().length() > LIMITE_CARACTERES_TELEFONO) {
            throw new NegocioException("El teléfono excede el límite de " + LIMITE_CARACTERES_TELEFONO + " caracteres.");
        }

        // Validación de formato de teléfono
        String telefono = nuevoCliente.getTelefono();
        if (!telefono.matches("^\\+?\\d+$")) {
            throw new NegocioException("El teléfono solo puede contener números y puede comenzar con un +.");
        }

        // Validación de formato de correo electrónico
        String correo = nuevoCliente.getCorreoElectronico();
        if (correo != null && !correo.trim().isEmpty()) {
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

    @Override
    public Cliente editarCliente(ClienteDTO clienteDTO) throws NegocioException {

        // Validaciones de campos obligatorios
        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el nombre del cliente");
        }

        if (clienteDTO.getApellidoPaterno() == null || clienteDTO.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el apellido paterno del cliente");
        }

        if (clienteDTO.getApellidoMaterno() == null || clienteDTO.getApellidoMaterno().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el apellido materno del cliente");
        }

        if (clienteDTO.getTelefono() == null || clienteDTO.getTelefono().trim().isEmpty()) {
            throw new NegocioException("Debes proporcionar el teléfono del cliente");
        }

        // Validaciones de formato (solo letras para nombre y apellidos)
        if (!clienteDTO.getNombre().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El nombre solo puede contener letras");
        }

        if (!clienteDTO.getApellidoPaterno().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido paterno solo puede contener letras");
        }

        if (!clienteDTO.getApellidoMaterno().matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido materno solo puede contener letras");
        }

        // Validaciones de longitud
        if (clienteDTO.getNombre().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El nombre del cliente excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (clienteDTO.getApellidoPaterno().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El apellido paterno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (clienteDTO.getApellidoMaterno().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El apellido materno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
        }

        if (clienteDTO.getCorreoElectronico().length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
            throw new NegocioException("El correo electrónico excede el límite de " + LIMITE_CARACTERES_CORREO_ELECTRONICO + " caracteres.");
        }

        if (clienteDTO.getTelefono().length() > LIMITE_CARACTERES_TELEFONO) {
            throw new NegocioException("El teléfono excede el límite de " + LIMITE_CARACTERES_TELEFONO + " caracteres.");
        }

        // Validación de formato de teléfono
        String telefono = clienteDTO.getTelefono();
        if (!telefono.matches("^\\+?\\d+$")) {
            throw new NegocioException("El teléfono solo puede contener números y puede comenzar con un +.");
        }

        // Validación de formato de correo electrónico
        String correo = clienteDTO.getCorreoElectronico();
        if (correo != null && !correo.trim().isEmpty()) {
            if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                throw new NegocioException("El formato del correo electrónico no es válido.");
            }
        }
        
        return this.clientesDAO.editarCliente(clienteDTO);
    }

    @Override
    public Cliente buscarClientePorId(Long id) throws NegocioException {
        return this.clientesDAO.buscarClientePorId(id);
    }
    
    
    
    
}
