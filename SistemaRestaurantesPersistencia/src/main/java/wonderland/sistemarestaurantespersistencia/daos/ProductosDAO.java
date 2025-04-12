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
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public class ProductosDAO implements IProductosDAO{
    
    @Override
    public Producto registrarProducto(NuevoProductoDTO nuevoProducto) throws PersistenciaException {    
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            Producto producto = new Producto();
            producto.setNombre(nuevoProducto.getNombre());
            producto.setPrecio(nuevoProducto.getPrecio());
            producto.setTipoProducto(nuevoProducto.getTipoProducto());

            entityManager.persist(producto);
            entityManager.getTransaction().commit();

            return producto;    
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }
    
    @Override
    public List<Producto> obtenerTodos() throws PersistenciaException {
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
    public List<Producto> obtenerProductoPorTipo(TipoProducto tipo) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
          
        try{
            List<Producto> productos  = entityManager
                    .createQuery("SELECT p FROM Producto p WHERE p.tipoProducto = :tipo", Producto.class)
                    .setParameter("tipo", tipo)
                    .getResultList();


            return productos; 
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }     
    }
    
    @Override
    public Producto editarProducto(NuevoProductoDTO productoDTO) throws PersistenciaException  {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            Producto productoEncontrado = entityManager.find(Producto.class, productoDTO.getId());

            productoEncontrado.setNombre(productoDTO.getNombre());
            productoEncontrado.setPrecio(productoDTO.getPrecio());
            productoEncontrado.setTipoProducto(productoDTO.getTipoProducto());

            entityManager.merge(productoEncontrado);
            entityManager.getTransaction().commit();

            return productoEncontrado;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
   }
    
    @Override
    public List<Producto> buscarPorNombre(String nombre) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
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
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
    }   
}
