/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.IngredienteProducto;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantespersistencia.IIngredienteProductoDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */ 
public class IngredienteProductoDAO implements IIngredienteProductoDAO{
    
    @Override
    public IngredienteProducto registrarIngredienteProducto(IngredienteProductoDTO ingredienteProductoDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin(); // ← INICIA TRANSACCIÓN

        IngredienteProducto relacion = new IngredienteProducto();

        Producto producto = entityManager.find(Producto.class, ingredienteProductoDTO.getIdProducto());
        if (producto == null) {
            throw new PersistenceException("El producto no existe");
        }
        relacion.setProducto(producto);

        Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteProductoDTO.getIdIngrediente());
        if (ingrediente == null) {
            throw new PersistenceException("El ingrediente no existe");
        }
        relacion.setIngrediente(ingrediente);

        relacion.setCantidad(ingredienteProductoDTO.getCantidad());

        entityManager.persist(relacion);
        entityManager.getTransaction().commit();

        return relacion;
    }

    @Override
    public List<IngredienteProducto> buscarPorProducto(Long idProducto){
        
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpql = "SELECT ip FROM IngredienteProducto ip WHERE ip.producto.id = :idProducto";
        TypedQuery<IngredienteProducto> query = entityManager.createQuery(jpql, IngredienteProducto.class);
        query.setParameter("idProducto", idProducto);
        
        return query.getResultList();
    }

    @Override
    public void eliminarIngredientesPorProducto(Long idProducto) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("DELETE FROM IngredienteProducto ip WHERE ip.producto.id = :idProducto");
        query.setParameter("idProducto", idProducto);
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}

    

