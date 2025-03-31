/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;
import wonderland.sistemarestaurantespersistencia.IClientesDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;

/**
 *
 * @author Dana Chavez
 */
public class ClientesDAO implements IClientesDAO {

    @Override
    public Cliente registrarCliente(NuevoClienteDTO nuevoCliente) {
        
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nuevoCliente.getNombre());
        cliente.setApellidoPaterno(nuevoCliente.getApellidoPaterno());
        cliente.setApellidoMaterno(nuevoCliente.getApellidoMaterno());
        cliente.setCorreoElectronico(nuevoCliente.getCorreoElectronico());
        cliente.setTelefono(nuevoCliente.getTelefono());
        cliente.setFechaRegistro(Calendar.getInstance());
        
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        
        return cliente;
    }

    @Override
    public List<Cliente> consultarClientesPorNombre(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> entidadCliente = criteria.from(Cliente.class);
        
        String filtro = "%" + filtroBusqueda.toLowerCase() + "%";
        
        criteria = criteria.select(entidadCliente).where(
                                                        builder.like(
                                                            builder.lower(
                                                                builder.concat(
                                                                    builder.concat(
                                                                        builder.concat(entidadCliente.get("nombre"), " "),
                                                                        builder.concat(entidadCliente.get("apellidoPaterno"), " ")
                                                                    ),
                                                                    entidadCliente.get("apellidoMaterno")
                                                                )
                                                            ),
                                                            filtro
                                                        )
                                                    );
        
        TypedQuery<Cliente> query = entityManager.createQuery(criteria);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<Cliente> consultarClientesPorTelefono(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> entidadCliente = criteria.from(Cliente.class);
        
        String filtro = filtroBusqueda;
        
        criteria = criteria.select(entidadCliente).where(builder.like(entidadCliente.get("telefono"), filtro));
        
        TypedQuery<Cliente> query = entityManager.createQuery(criteria);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<Cliente> consultarClientesPorCorreoElectronico(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> entidadCliente = criteria.from(Cliente.class);
        
        String filtro = filtroBusqueda.toLowerCase();
        
        criteria = criteria.select(entidadCliente).where(builder.like(entidadCliente.get("correoElectronico"), filtro));
        
        TypedQuery<Cliente> query = entityManager.createQuery(criteria);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT v FROM Cliente v ORDER BY v.nombre ASC";

        TypedQuery<Cliente> query = entityManager.createQuery(jpqlQuery, Cliente.class);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public Cliente editarCliente(ClienteDTO clienteDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Cliente clienteEncontrado = buscarClientePorId(clienteDTO.getId());
        clienteEncontrado.setNombre(clienteDTO.getNombre());
        clienteEncontrado.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteEncontrado.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteEncontrado.setCorreoElectronico(clienteDTO.getCorreoElectronico());
        clienteEncontrado.setTelefono(clienteDTO.getTelefono());
        
        entityManager.merge(clienteEncontrado);
        entityManager.getTransaction().commit();
        
        return clienteEncontrado;
    }

    @Override
    public Cliente buscarClientePorId(Long idCliente) {   
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        return cliente;       
    }
}
