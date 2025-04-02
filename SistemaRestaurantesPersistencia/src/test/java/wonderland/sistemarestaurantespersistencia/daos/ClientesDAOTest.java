/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;

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
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        NuevoClienteFrecuenteDTO nuevoCliente = new NuevoClienteFrecuenteDTO("Dana Melissa", "Chavez", "Gutierrez", "dana11@hotmail.com", "1234567890");
//        ClienteFrecuente clienteGuardado = clientesFrecuentesDAO.registrarCliente(nuevoCliente);
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
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        NuevoClienteFrecuenteDTO nuevoCliente = new NuevoClienteFrecuenteDTO("Dana Melissa", "Chavez", "Gutierrez", "12345678902");
//        ClienteFrecuente clienteGuardado = clientesFrecuentesDAO.registrarCliente(nuevoCliente);
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
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        
//        final String filtroBusqueda = "Dana Melissa Chavez Gutierrez";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        
//        List<ClienteFrecuente> clientesConsultados = clientesFrecuentesDAO.consultarClientesPorNombre(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorParteDelNombreOk(){
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        
//        final String filtroBusqueda = "Dana";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        
//        List<ClienteFrecuente> clientesConsultados = clientesFrecuentesDAO.consultarClientesPorNombre(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorTelefonoOk(){
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        String filtroBusqueda = "1234567890";
//        final int NUMERO_CLIENTES_ESPERADOS = 4;
//        List<ClienteFrecuente> clientesConsultados = clientesFrecuentesDAO.consultarClientesPorTelefono(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorCorreoElectronicoOk(){
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        String filtroBusqueda = "dana11@hotmail.com";
//        final int NUMERO_CLIENTES_ESPERADOS = 2;
//        List<ClienteFrecuente> clientesConsultados = clientesFrecuentesDAO.consultarClientesPorCorreoElectronico(filtroBusqueda);
//        
//        assertNotNull(clientesConsultados);
//        
//        assertEquals(NUMERO_CLIENTES_ESPERADOS, clientesConsultados.size());
//    }
//    
//    @Test
//    public void testConsultarClientePorIdOk(){
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//        final Long ID_CLIENTE_BUSCADO = 1L;
//        final String NOMBRE_CLIENTE_BUSCADO = "Dana Melissa";
//
//        ClienteFrecuente clienteConsultado = clientesFrecuentesDAO.buscarClientePorId(ID_CLIENTE_BUSCADO);
//        
//        assertNotNull(clienteConsultado);
//        
//        assertEquals(NOMBRE_CLIENTE_BUSCADO, clienteConsultado.getNombre());
//    }
//    
//    @Test
//    public void testEditarClienteOk(){
//        ClientesFrecuentesDAO clientesFrecuentesDAO = new ClientesFrecuentesDAO();
//
//        NuevoClienteFrecuenteDTO nuevoClienteDTO = new NuevoClienteFrecuenteDTO("Juan","Perez","Gom","juan@example.com","1234567890");
//
//        Cliente clienteRegistrado = clientesFrecuentesDAO.registrarCliente(nuevoClienteDTO);
//
//        ClienteFrecuenteDTO clienteDTO = new ClienteFrecuenteDTO();
//        clienteDTO.setId(clienteRegistrado.getId());
//        clienteDTO.setNombre("Juan Carlos");
//        clienteDTO.setApellidoPaterno("Perez");
//        clienteDTO.setApellidoMaterno("Gomez");
//        clienteDTO.setCorreoElectronico("juan.carlos@example.com");
//        clienteDTO.setTelefono("0987654321");
//
//        ClienteFrecuente clienteEditado = clientesFrecuentesDAO.editarCliente(clienteDTO);
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
