/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;

/**
 *
 * @author Dana Chavez
 */
public class ClientesDAOTest {
    
    public ClientesDAOTest() {
    }

    /**
     * Test of registrarCliente method, of class ClientesDAO.
     */
    @Test
    public void testRegistrarClienteCompletoOk() {
        ClientesDAO clientesDAO = new ClientesDAO();
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO("Dana Melissa", "Chavez", "Gutierrez", "dana11@hotmail.com", "1234567890");
        Cliente clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        
        assertNotNull(clienteGuardado.getId());
        
        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
        assertEquals(nuevoCliente.getCorreoElectronico(), clienteGuardado.getCorreoElectronico());
        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
    }
    
    @Test
    public void testRegistrarClienteSinCorreoElectronicoOk() {
        ClientesDAO clientesDAO = new ClientesDAO();
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO("Dana Melissa", "Chavez", "Gutierrez", "1234567890");
        Cliente clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
        
        assertNotNull(clienteGuardado.getId());
        
        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
        
        assertNull(nuevoCliente.getCorreoElectronico(), clienteGuardado.getCorreoElectronico());       
    }
    
    @Test
    public void testConsultarClientePorNombreCompletoOk(){
        ClientesDAO clientesDAO = new ClientesDAO();
        String filtroBusqueda = "Dana Melissa Chavez Gutierrez";
        final int NUMERO_CLIENTES_ESPERADOS = 9;
        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorNombre(filtroBusqueda);
        
        assertNotNull(clientesConsultados);
        
        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
    }
    
    @Test
    public void testConsultarClientePorParteDelNombreOk(){
        ClientesDAO clientesDAO = new ClientesDAO();
        String filtroBusqueda = "Dana";
        final int NUMERO_CLIENTES_ESPERADOS = 9;
        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorNombre(filtroBusqueda);
        
        assertNotNull(clientesConsultados);
        
        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
    }
    
    @Test
    public void testConsultarClientePorTelefonoOk(){
        ClientesDAO clientesDAO = new ClientesDAO();
        String filtroBusqueda = "1234567890";
        final int NUMERO_CLIENTES_ESPERADOS = 9;
        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorTelefono(filtroBusqueda);
        
        assertNotNull(clientesConsultados);
        
        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
    }
    
    @Test
    public void testConsultarClientePorCorreoElectronicoOk(){
        ClientesDAO clientesDAO = new ClientesDAO();
        String filtroBusqueda = "dana11@hotmail.com";
        final int NUMERO_CLIENTES_ESPERADOS = 5;
        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorCorreoElectronico(filtroBusqueda);
        
        assertNotNull(clientesConsultados);
        
        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
    }
    
}
