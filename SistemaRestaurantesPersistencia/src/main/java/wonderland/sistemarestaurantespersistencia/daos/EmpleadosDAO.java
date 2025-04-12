/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import wonderland.sistemarestaurantesdominio.Empleado;
import wonderland.sistemarestaurantespersistencia.IEmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public class EmpleadosDAO implements IEmpleadosDAO {

    @Override
    public Empleado iniciarSesion(String usuario, String contrasena) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try {
            String jpqlQuery = "SELECT e FROM Empleado e WHERE e.usuario = :usuario AND e.contrasena = :contrasena";
            TypedQuery<Empleado> query = entityManager.createQuery(jpqlQuery, Empleado.class);
            query.setParameter("usuario", usuario);
            query.setParameter("contrasena", contrasena);

            return query.getSingleResult(); 
        } catch (NoResultException e) {
            return null; 
        }
    }
    
}
