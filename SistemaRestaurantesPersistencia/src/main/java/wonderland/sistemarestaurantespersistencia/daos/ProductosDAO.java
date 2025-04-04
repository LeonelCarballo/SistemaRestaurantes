/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import javax.persistence.EntityManager;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantespersistencia.IProductosDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;

/**
 *
 * @author payde
 */
public class ProductosDAO implements IProductosDAO{

    @Override
    public Producto registrarProducto(NuevoProductoDTO nuevoProducto) {    
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        Producto producto = new Producto();
        producto.setNombre(nuevoProducto.getNombre());
        producto.setPrecio(nuevoProducto.getPrecio());
        producto.setTipoProducto(nuevoProducto.getTipoProducto());
        
        entityManager.persist(producto);
        entityManager.getTransaction().commit();

        return producto;     
    }

    @Override
    public List<Producto> obtenerProductoPorTipo(TipoProducto tipo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        List<Producto> productos  = entityManager
                .createQuery("SELECT p FROM Producto p WHERE p.tipoProducto = :tipo", Producto.class)
                .setParameter("tipo", tipo)
                .getResultList();
        
        return productos;
    }
    
//    public List<Producto> buscarPorNombre(String nombreBusqueda) {
//    EntityManager entityManager = ManejadorConexiones.getEntityManager();
//
//    List<Producto> productos = entityManager.createQuery(
//        "SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE :nombre", Producto.class)
//        .setParameter("nombre", "%" + nombreBusqueda.toLowerCase() + "%")
//        .getResultList();
//
//    entityManager.close();
//
//    return productos;
//}
    
}
