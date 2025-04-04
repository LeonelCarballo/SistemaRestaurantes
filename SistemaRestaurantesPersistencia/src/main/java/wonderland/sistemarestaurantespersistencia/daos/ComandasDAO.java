/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.NuevaComandaDTO;
import wonderland.sistemarestaurantespersistencia.IComandasDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;

/**
 *
 * @author Dana Chavez
 */
public class ComandasDAO implements IComandasDAO {

    @Override
    public Comanda crearNuevarComanda(NuevaComandaDTO nuevaComanda) {
        
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        entityManager.getTransaction().begin();
        
        Comanda comanda = new Comanda();
        comanda.setFolio(generarFolio());
        comanda.setEstadoComanda(nuevaComanda.getEstadoComanda());
        comanda.setFechaHoraCreacion(Calendar.getInstance());
        comanda.setMesa(nuevaComanda.getMesa());
        comanda.setCliente(nuevaComanda.getCliente());
        comanda.setDetallesComandas(nuevaComanda.getDetallesComandas());
        
        entityManager.persist(comanda);
        entityManager.getTransaction().commit();
        
        return comanda;
    }

    public String generarFolio() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        Calendar calendar = Calendar.getInstance();
        String fecha = String.format("%04d%02d%02d", calendar.get(Calendar.YEAR), 
                                         calendar.get(Calendar.MONTH) + 1, 
                                         calendar.get(Calendar.DAY_OF_MONTH));
        int consecutivo = obtenerNumeroConsecutivo(entityManager, fecha);
        return "OB-" + fecha + "-" + String.format("%03d", consecutivo);
    }

    private int obtenerNumeroConsecutivo(EntityManager entityManager, String fecha) {
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
    }
    
}
