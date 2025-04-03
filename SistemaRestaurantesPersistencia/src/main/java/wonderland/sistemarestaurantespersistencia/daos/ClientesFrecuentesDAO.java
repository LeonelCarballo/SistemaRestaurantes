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
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.IClientesFrecuentesDAO;

/**
 *
 * @author Dana Chavez
 */
public class ClientesFrecuentesDAO implements IClientesFrecuentesDAO {

    @Override
    public ClienteFrecuente registrarCliente(NuevoClienteFrecuenteDTO nuevoCliente) {
        
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        ClienteFrecuente cliente = new ClienteFrecuente();
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
    public List<ClienteFrecuente> consultarClientesPorNombre(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteFrecuente> criteria = builder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> entidadCliente = criteria.from(ClienteFrecuente.class);
        
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
        
        TypedQuery<ClienteFrecuente> query = entityManager.createQuery(criteria);
        List<ClienteFrecuente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<ClienteFrecuente> consultarClientesPorTelefono(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteFrecuente> criteria = builder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> entidadCliente = criteria.from(ClienteFrecuente.class);
        
        String filtro = filtroBusqueda;
        
        criteria = criteria.select(entidadCliente).where(builder.like(entidadCliente.get("telefonoEncriptado"), filtro));
        
        TypedQuery<ClienteFrecuente> query = entityManager.createQuery(criteria);
        List<ClienteFrecuente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<ClienteFrecuente> consultarClientesPorCorreoElectronico(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteFrecuente> criteria = builder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> entidadCliente = criteria.from(ClienteFrecuente.class);
        
        String filtro = filtroBusqueda.toLowerCase();
        
        criteria = criteria.select(entidadCliente).where(builder.like(entidadCliente.get("correoElectronico"), filtro));
        
        TypedQuery<ClienteFrecuente> query = entityManager.createQuery(criteria);
        List<ClienteFrecuente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public List<ClienteFrecuente> obtenerClientes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT v FROM ClienteFrecuente v ORDER BY v.nombre ASC";

        TypedQuery<ClienteFrecuente> query = entityManager.createQuery(jpqlQuery, ClienteFrecuente.class);
        List<ClienteFrecuente> clientes = query.getResultList();
        return clientes;
    }

    @Override
    public ClienteFrecuente editarCliente(ClienteFrecuenteDTO clienteFrecuenteDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        ClienteFrecuente clienteEncontrado = buscarClientePorId(clienteFrecuenteDTO.getId());
        clienteEncontrado.setNombre(clienteFrecuenteDTO.getNombre());
        clienteEncontrado.setApellidoPaterno(clienteFrecuenteDTO.getApellidoPaterno());
        clienteEncontrado.setApellidoMaterno(clienteFrecuenteDTO.getApellidoMaterno());
        clienteEncontrado.setCorreoElectronico(clienteFrecuenteDTO.getCorreoElectronico());
        clienteEncontrado.setTelefono(clienteFrecuenteDTO.getTelefono());
        
        entityManager.merge(clienteEncontrado);
        entityManager.getTransaction().commit();
        
        return clienteEncontrado;
    }

    @Override
    public ClienteFrecuente buscarClientePorId(Long idCliente) {   
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        ClienteFrecuente cliente = entityManager.find(ClienteFrecuente.class, idCliente);
        return cliente;       
    }
}
