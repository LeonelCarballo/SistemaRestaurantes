package wonderland.sistemarestaurantespersistencia.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.EstadoComanda;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantespersistencia.IComandasDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author Dana Chavez
 */
public class ComandasDAO implements IComandasDAO {          

    @Override
    public Comanda crearNuevarComanda(NuevaComandaDTO nuevaComanda) throws PersistenciaException {

        EntityManager entityManager = ManejadorConexiones.getEntityManager();
              
        try{
            entityManager.getTransaction().begin();

            Comanda comanda = new Comanda();
            comanda.setFolio(generarFolio());
            comanda.setEstadoComanda(nuevaComanda.getEstadoComanda());
            comanda.setFechaHoraCreacion(Calendar.getInstance());
            comanda.setMesa(nuevaComanda.getMesa());
            comanda.setCliente(nuevaComanda.getCliente());

            entityManager.persist(comanda);
            entityManager.getTransaction().commit();

            return comanda;

        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo registrar la comanda" + e);           
        } finally {
            entityManager.close();
        }    
    }

    public String generarFolio() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        Calendar calendar = Calendar.getInstance();
        String fecha = String.format("%04d%02d%02d", calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
        int consecutivo = obtenerNumeroConsecutivo(entityManager, fecha);
        return "OB-" + fecha + "-" + String.format("%03d", consecutivo);
    }

    private int obtenerNumeroConsecutivo(EntityManager entityManager, String fecha) throws PersistenciaException {
                          
        try{
            String jpql = "SELECT MAX(c.folio) FROM Comanda c WHERE c.folio LIKE :fecha";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("fecha", "OB-" + fecha + "-%");

            String ultimoFolio = (String) query.getSingleResult();

            if (ultimoFolio != null) {
                String consecutivoStr = ultimoFolio.substring(12);
                return Integer.parseInt(consecutivoStr) + 1;
        } else {
            return 1;
        }
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo generar folio correctamente" + e);           
        } finally {
            entityManager.close();
        }      
    }

    @Override
    public Comanda asociarClienteAComanda(Comanda comanda, ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            entityManager.getTransaction().begin();

            comanda.setCliente(cliente);
            Comanda comandaActualizada = entityManager.merge(comanda);
            entityManager.getTransaction().commit();
        return comandaActualizada;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo asociar cliente a la comanda" + e);           
        } finally {
            entityManager.close();
        }  
    }

    @Override
    public Comanda obtenerComandaPorId(Long idComanda) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try{
            Comanda comanda = entityManager.find(Comanda.class, idComanda);
            return comanda;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo obtener la comanda" + e);           
        } finally {
            entityManager.close();
        } 
    }

    @Override
    public ComandaDTO obtenerComandaActivaPorMesa(Long idMesa) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try{
            String jpql = "SELECT c FROM Comanda c WHERE c.mesa.id = :idMesa AND c.estadoComanda = :estado";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("idMesa", idMesa);
            query.setParameter("estado", EstadoComanda.ABIERTA);

            Comanda comanda = (Comanda) query.getSingleResult();

            ComandaDTO comandaDTO = new ComandaDTO(comanda);

            return comandaDTO;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo obtener la comanda" + e);           
        } finally {
            entityManager.close();
        } 
    }

    @Override
    public Comanda modificarEstadoComanda(ComandaDTO comandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Comanda comanda = entityManager.find(Comanda.class, comandaDTO.getId());
            comanda.setEstadoComanda(EstadoComanda.ENTREGADA);
            entityManager.merge(comanda);

            entityManager.getTransaction().commit();

            Comanda comandaActualizada = comanda;

            return comandaActualizada;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo modificar el estado de la comanda" + e);           
        } finally {
            entityManager.close();
        } 
    }

    @Override
    public Comanda cancelarComanda(ComandaDTO comandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Comanda comanda = entityManager.find(Comanda.class, comandaDTO.getId());
            comanda.setEstadoComanda(EstadoComanda.CANCELADA);
            entityManager.merge(comanda);

            entityManager.getTransaction().commit();

            Comanda comandaActualizada = comanda;

            return comandaActualizada;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudo cancelar la comanda" + e);           
        } finally {
            entityManager.close();
        } 
    }

    @Override
    public List<ComandaDTO> obtenerComandas() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
 
        try{
            String jpqlQuery = "SELECT v FROM Comanda v ORDER BY v.fechaHoraCreacion ASC";

            TypedQuery<Comanda> query = entityManager.createQuery(jpqlQuery, Comanda.class);
            List<Comanda> comandas = query.getResultList();

            List<ComandaDTO> comandasDTO = new ArrayList<>();

            for (Comanda comanda : comandas) {
                ComandaDTO comandaDTO = new ComandaDTO(comanda);
                comandasDTO.add(comandaDTO);
            }

            return comandasDTO;    
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudieron obtener las comandas" + e);           
        } finally {
            entityManager.close();
        }  
    }

    @Override
    public List<ComandaDTO> obtenerComandasPorFechas(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            List<Comanda> comandas = entityManager.createQuery(
                    "SELECT c FROM Comanda c WHERE c.fechaHoraCreacion BETWEEN :inicio AND :fin",
                    Comanda.class)
                    .setParameter("inicio", fechaInicio)
                    .setParameter("fin", fechaFin)
                    .getResultList();
            entityManager.getTransaction().commit();

            List<ComandaDTO> comandasDTO = new ArrayList<>();

            for (Comanda comanda : comandas) {
                ComandaDTO comandaDTO = new ComandaDTO(comanda);
                comandasDTO.add(comandaDTO);
            }

            return comandasDTO;
        } catch (Exception e){
            entityManager.getTransaction().rollback();           
            throw new PersistenciaException("No se pudieron obtener las comandas" + e);           
        } finally {
            entityManager.close();
        } 
    }     
}
