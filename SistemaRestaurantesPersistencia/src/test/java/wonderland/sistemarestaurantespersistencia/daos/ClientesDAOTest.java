/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteDTO;
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
//    @Test
//    public void testRegistrarClienteCompletoOk() {
//        ClientesDAO clientesDAO = new ClientesDAO();
//        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO("Dana Melissa", "Chavez", "Gutierrez", "dana11@hotmail.com", "1234567890");
//        Cliente clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
//        
//        assertNotNull(clienteGuardado.getId());
//        
//        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
//        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
//        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
//        assertEquals(nuevoCliente.getCorreoElectronico(), clienteGuardado.getCorreoElectronico());
//        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
//    }
//    
//    @Test
//    public void testRegistrarClienteSinCorreoElectronicoOk() {
//        ClientesDAO clientesDAO = new ClientesDAO();
//        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO("Dana Melissa", "Chavez", "Gutierrez", "1234567890");
//        Cliente clienteGuardado = clientesDAO.registrarCliente(nuevoCliente);
//        
//        assertNotNull(clienteGuardado.getId());
//        
//        assertEquals(nuevoCliente.getNombre(), clienteGuardado.getNombre());
//        assertEquals(nuevoCliente.getApellidoPaterno(), clienteGuardado.getApellidoPaterno());
//        assertEquals(nuevoCliente.getApellidoMaterno(), clienteGuardado.getApellidoMaterno());
//        assertEquals(nuevoCliente.getTelefono(), clienteGuardado.getTelefono());
//        
//        assertNull(nuevoCliente.getCorreoElectronico(), clienteGuardado.getCorreoElectronico());       
//    }
//    
//    @Test
//    public void testConsultarClientePorNombreCompletoOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        String filtroBusqueda = "Dana Melissa Chavez Gutierrez";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorNombre(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorParteDelNombreOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        String filtroBusqueda = "Dana";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorNombre(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorTelefonoOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        String filtroBusqueda = "1234567890";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorTelefono(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorCorreoElectronicoOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        String filtroBusqueda = "dana11@hotmail.com";
//        final int NUMERO_CLIENTES_ESPERADOS = 2;
//        List<Cliente> clientesConsultados = clientesDAO.consultarClientesPorCorreoElectronico(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
    
//    @Test
//    public void testEditarClienteOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        Long idCliente = 1L;
//
//    }
//    
//    @Test
//    public void testConsultarClientePorNombreCompletoOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//        final Long ID_CLIENTE_BUSCADO = 1L;
//
//        Cliente clienteConsultado = clientesDAO.buscarClientePorId(ID_CLIENTE_BUSCADO);
//        
//        assertNotNull(clienteConsultado);
//        
//        assertEquals("Dana Melissa", clienteConsultado.getNombre());
//    }
//    
//    @Test
//    public void testEditarClienteOk(){
//        ClientesDAO clientesDAO = new ClientesDAO();
//
//        NuevoClienteDTO nuevoClienteDTO = new NuevoClienteDTO("Juan","Perez","Gom","juan@example.com","1234567890");
//
//        Cliente clienteRegistrado = clientesDAO.registrarCliente(nuevoClienteDTO);
//
//        ClienteDTO clienteDTO = new ClienteDTO();
//        clienteDTO.setId(clienteRegistrado.getId());
//        clienteDTO.setNombre("Juan Carlos");
//        clienteDTO.setApellidoPaterno("Perez");
//        clienteDTO.setApellidoMaterno("Gomez");
//        clienteDTO.setCorreoElectronico("juan.carlos@example.com");
//        clienteDTO.setTelefono("0987654321");
//
//        Cliente clienteEditado = clientesDAO.editarCliente(clienteDTO);
//
//        assertNotNull(clienteEditado);
//        assertEquals(clienteDTO.getId(), clienteEditado.getId());
//        assertEquals("Juan Carlos", clienteEditado.getNombre());
//        assertEquals("Perez", clienteEditado.getApellidoPaterno());
//        assertEquals("Gomez", clienteEditado.getApellidoMaterno());
//        assertEquals("juan.carlos@example.com", clienteEditado.getCorreoElectronico());
//        assertEquals("0987654321", clienteEditado.getTelefono());       
//    }
}
