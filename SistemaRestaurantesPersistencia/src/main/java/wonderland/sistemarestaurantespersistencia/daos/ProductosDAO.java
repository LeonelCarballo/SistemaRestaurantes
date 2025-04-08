/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public List<Producto> obtenerTodos() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            TypedQuery<Producto> query = entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
            List<Producto> productos = query.getResultList();
            return productos;
        } finally {
            entityManager.close();
    }
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
    
    @Override
    public Producto editarProducto(NuevoProductoDTO productoDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        entityManager.getTransaction().begin();

        Producto productoEncontrado = entityManager.find(Producto.class, productoDTO.getId());

        productoEncontrado.setNombre(productoDTO.getNombre());
        productoEncontrado.setPrecio(productoDTO.getPrecio());
        productoEncontrado.setTipoProducto(productoDTO.getTipoProducto());

        entityManager.merge(productoEncontrado);
        entityManager.getTransaction().commit();

        return productoEncontrado;
   }
    
    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        Root<Producto> entidadProducto = criteria.from(Producto.class);

        Predicate nombreLike = builder.like(
            builder.lower(entidadProducto.get("nombre")),
            "%" + nombre.toLowerCase() + "%"
        );

        criteria.select(entidadProducto).where(nombreLike);

        TypedQuery<Producto> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    
}
