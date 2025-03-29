/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.Calendar;
import javax.persistence.EntityManager;
import wonderland.sistemarestaurantesdominio.Cliente;
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



    
}
