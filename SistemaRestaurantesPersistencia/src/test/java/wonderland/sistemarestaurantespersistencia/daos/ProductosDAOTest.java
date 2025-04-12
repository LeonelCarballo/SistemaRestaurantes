package wonderland.sistemarestaurantespersistencia.daos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public class ProductosDAOTest {
    
    public ProductosDAOTest() {
    }
    
//    private final ProductosDAO productosDAO = new ProductosDAO();
//
//    @Test
//    public void testRegistrarProductoOk() throws PersistenciaException {
//        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO();
//        nuevoProducto.setNombre("Hamburguesa");
//        nuevoProducto.setPrecio(95.0f);
//        nuevoProducto.setTipoProducto(TipoProducto.PLATILLO);
//
//        Producto productoRegistrado = productosDAO.registrarProducto(nuevoProducto);
//
//        assertNotNull(productoRegistrado);
//        assertNotNull(productoRegistrado.getId());
//        assertEquals("Hamburguesa", productoRegistrado.getNombre());
//        assertEquals(95.0f, productoRegistrado.getPrecio());
//        assertEquals(TipoProducto.PLATILLO, productoRegistrado.getTipoProducto());
//    }
//
//    @Test
//    public void testEditarProductoOk() throws PersistenciaException {
//       
//        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO();
//        nuevoProducto.setNombre("Agua");
//        nuevoProducto.setPrecio(15.0f);
//        nuevoProducto.setTipoProducto(TipoProducto.BEBIDA);
//
//        Producto producto = productosDAO.registrarProducto(nuevoProducto);
//
//      
//        nuevoProducto.setId(producto.getId());
//        nuevoProducto.setNombre("Agua Natural");
//        nuevoProducto.setPrecio(17.0f);
//
//        Producto productoEditado = productosDAO.editarProducto(nuevoProducto);
//
//        assertEquals("Agua Natural", productoEditado.getNombre());
//        assertEquals(17.0f, productoEditado.getPrecio());
//        assertEquals(producto.getId(), productoEditado.getId());
//    }
//
//    @Test
//    public void testBuscarProductoPorNombreOk() throws PersistenciaException {
//        String nombreBuscado = "hamburguesa";
//        List<Producto> resultados = productosDAO.buscarPorNombre(nombreBuscado);
//
//        assertNotNull(resultados);
//        assertTrue(resultados.size() >= 1);
//
//        boolean contieneNombre = resultados.stream()
//                .anyMatch(p -> p.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase()));
//        assertTrue(contieneNombre);
//    }
//
//    @Test
//    public void testObtenerProductoPorTipoOk() throws PersistenciaException {
//        TipoProducto tipo = TipoProducto.PLATILLO;
//        List<Producto> productos = productosDAO.obtenerProductoPorTipo(tipo);
//
//        assertNotNull(productos);
//        assertTrue(productos.stream().allMatch(p -> p.getTipoProducto().equals(tipo)));
//    }
//
//    @Test
//    public void testObtenerTodosLosProductosOk() throws PersistenciaException {
//        List<Producto> productos = productosDAO.obtenerTodos();
//
//        assertNotNull(productos);
//        assertFalse(productos.isEmpty());
//    }
}
