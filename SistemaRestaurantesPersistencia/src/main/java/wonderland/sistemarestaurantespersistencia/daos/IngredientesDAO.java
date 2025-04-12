/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantespersistencia.IIngredientesDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author leoca
 */
public class IngredientesDAO implements IIngredientesDAO {

    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre(nuevoIngrediente.getNombre());
            ingrediente.setStock(nuevoIngrediente.getStock());
            ingrediente.setUnidadMedida(nuevoIngrediente.getUnidadMedida());

            entityManager.persist(ingrediente);
            entityManager.getTransaction().commit();

        return ingrediente;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }

    @Override
    public List<Ingrediente> consultarIngredientes() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            String jpqlQuery = "SELECT i FROM Ingrediente i ORDER BY i.nombre ASC";

            TypedQuery<Ingrediente> query = entityManager.createQuery(jpqlQuery, Ingrediente.class);
            List<Ingrediente> ingredientes = query.getResultList();
            return ingredientes;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }
    
    @Override
    public List<Ingrediente> obtenerTodos() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            TypedQuery<Ingrediente> query = entityManager.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class);
            return query.getResultList();
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }

    @Override
    public Ingrediente editarNombre(NuevoIngredienteDTO nuevoIngredienteDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            Ingrediente ingredienteEncontrado = buscarIngredienteId(nuevoIngredienteDTO.getId());
            ingredienteEncontrado.setNombre(nuevoIngredienteDTO.getNombre());
            ingredienteEncontrado.setStock(nuevoIngredienteDTO.getStock());
            ingredienteEncontrado.setUnidadMedida(nuevoIngredienteDTO.getUnidadMedida());

            entityManager.merge(ingredienteEncontrado);
            entityManager.getTransaction().commit();

            return ingredienteEncontrado;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }

    @Override
    public Ingrediente aumentarStock(NuevoIngredienteDTO nuevoIngredienteDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            Ingrediente ingredienteEncontrado = buscarIngredienteId(nuevoIngredienteDTO.getId());
            ingredienteEncontrado.setNombre(nuevoIngredienteDTO.getNombre());
            ingredienteEncontrado.setStock(nuevoIngredienteDTO.getStock());
            ingredienteEncontrado.setUnidadMedida(nuevoIngredienteDTO.getUnidadMedida());

            entityManager.merge(ingredienteEncontrado);
            entityManager.getTransaction().commit();

            return ingredienteEncontrado;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }

    @Override
    public Ingrediente buscarIngredienteId(Long idIngrediente) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
            return ingrediente;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }

    @Override
    public List<Ingrediente> consultarIngredientesPorNombre(String nombre) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            String jpqlQuery = "SELECT i FROM Ingrediente i WHERE i.nombre LIKE :nombre ORDER BY i.nombre ASC";

            TypedQuery<Ingrediente> query = entityManager.createQuery(jpqlQuery, Ingrediente.class);
            query.setParameter("nombre", "%" + nombre + "%"); // El % permite buscar coincidencias parciales

            List<Ingrediente> ingredientes = query.getResultList();
            return ingredientes;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }   
    }
}
