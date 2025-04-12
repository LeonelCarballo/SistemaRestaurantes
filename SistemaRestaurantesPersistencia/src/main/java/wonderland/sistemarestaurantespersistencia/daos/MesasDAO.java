/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.NuevaMesaDTO;
import wonderland.sistemarestaurantespersistencia.IMesasDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

public class MesasDAO implements IMesasDAO {    
    @Override
    public List<Mesa> agregarMesas(NuevaMesaDTO nuevaMesa) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            List<Mesa> mesas = new ArrayList<>();

            entityManager.getTransaction().begin();
            Integer ultimaMesa = obtenerUltimaMesa(entityManager);
            if (nuevaMesa.getNumeroMesa() == null) {
                nuevaMesa.setNumeroMesa(ultimaMesa + 1);
            }
            for (int i = 0; i < 20; i++) {
                Mesa mesa = new Mesa();
                mesa.setNumeroMesa(nuevaMesa.getNumeroMesa() + i);  
                mesa.setEstado(EstadoMesa.DISPONIBLE);
                entityManager.persist(mesa); 
                mesas.add(mesa); 
            }
            entityManager.getTransaction().commit();

            return mesas;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
    }

    @Override
    public List<Mesa> mostrarMesas() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            String jpqlQuery = "SELECT v FROM Mesa v ORDER BY v.numeroMesa ASC";

            TypedQuery<Mesa> query = entityManager.createQuery(jpqlQuery, Mesa.class);
            List<Mesa> mesas = query.getResultList();

            return mesas;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
    }

    public Integer obtenerUltimaMesa(EntityManager entityManager) throws PersistenciaException {
        try{
            String jpql = "SELECT MAX(m.numeroMesa) FROM Mesa m";
            Query query = entityManager.createQuery(jpql);

            Integer ultimaMesa = (Integer) query.getSingleResult();

            if (ultimaMesa == null) {
                return 0; 
            }
            return ultimaMesa;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
    }

    @Override
    public Mesa cambiarEstadoMesa(Long idMesa, EstadoMesa nuevoEstado) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            String jpql = "SELECT m FROM Mesa m WHERE m.id = :id";
            TypedQuery<Mesa> query = entityManager.createQuery(jpql, Mesa.class);
            query.setParameter("id", idMesa);

            Mesa mesa = query.getSingleResult();

            mesa.setEstado(nuevoEstado);

            Mesa mesaActualizada = entityManager.merge(mesa);

            entityManager.getTransaction().commit();

            return mesaActualizada;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar el cliente" + e);           
        } finally {
            entityManager.close();
        }  
    }     
}
