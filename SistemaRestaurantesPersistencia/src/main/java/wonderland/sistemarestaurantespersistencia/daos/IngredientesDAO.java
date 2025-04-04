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

/**
 *
 * @author leoca
 */
public class IngredientesDAO implements IIngredientesDAO {

    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        entityManager.getTransaction().begin();

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nuevoIngrediente.getNombre());
        ingrediente.setStock(nuevoIngrediente.getStock());
        ingrediente.setUnidadMedida(nuevoIngrediente.getUnidadMedida());

        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();

        return ingrediente;
    }

    @Override
    public List<Ingrediente> consultarIngredientes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        String jpqlQuery = "SELECT i FROM Ingrediente i ORDER BY i.nombre ASC";

        TypedQuery<Ingrediente> query = entityManager.createQuery(jpqlQuery, Ingrediente.class);
        List<Ingrediente> ingredientes = query.getResultList();
        return ingredientes;
    }

    @Override
    public Ingrediente editarNombre(NuevoIngredienteDTO nuevoIngredienteDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Ingrediente ingredienteEncontrado = buscarIngredienteId(nuevoIngredienteDTO.getId());
        ingredienteEncontrado.setNombre(nuevoIngredienteDTO.getNombre());
        ingredienteEncontrado.setStock(nuevoIngredienteDTO.getStock());
        ingredienteEncontrado.setUnidadMedida(nuevoIngredienteDTO.getUnidadMedida());
        
        entityManager.merge(ingredienteEncontrado);
        entityManager.getTransaction().commit();
        
        return ingredienteEncontrado;
    }

    @Override
    public Ingrediente aumentarStock(NuevoIngredienteDTO nuevoIngredienteDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Ingrediente ingredienteEncontrado = buscarIngredienteId(nuevoIngredienteDTO.getId());
        ingredienteEncontrado.setNombre(nuevoIngredienteDTO.getNombre());
        ingredienteEncontrado.setStock(nuevoIngredienteDTO.getStock());
        ingredienteEncontrado.setUnidadMedida(nuevoIngredienteDTO.getUnidadMedida());
        
        entityManager.merge(ingredienteEncontrado);
        entityManager.getTransaction().commit();
        
        return ingredienteEncontrado;
    }
    
    @Override
    public Ingrediente buscarIngredienteId(Long idIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
        return ingrediente;
    }

    

}

