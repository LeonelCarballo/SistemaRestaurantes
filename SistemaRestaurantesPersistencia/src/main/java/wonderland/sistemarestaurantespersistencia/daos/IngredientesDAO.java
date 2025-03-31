/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import javax.persistence.EntityManager;
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

}
