/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantespersistencia.IDetallesComandasDAO;
import wonderland.sistemarestaurantespersistencia.conexiones.ManejadorConexiones;

/**
 *
 * @author payde
 */
public class DetallesComandasDAO implements IDetallesComandasDAO {
    
    @Override
    public DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComandaDTO) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Producto producto = em.find(Producto.class, detalleComandaDTO.getProducto().getId());
            Comanda comanda = em.find(Comanda.class, detalleComandaDTO.getComanda().getId());

            DetalleComanda detalle = new DetalleComanda();
            detalle.setProducto(producto);
            detalle.setComanda(comanda);
            detalle.setCantidadProducto(detalleComandaDTO.getCantidadProducto());
            detalle.setPrecio(detalleComandaDTO.getPrecio());
            detalle.setNota(detalleComandaDTO.getNota());

            em.persist(detalle);

            tx.commit();
            return detalle;

        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Error al guardar detalle de comanda", ex);
        }
    }

    @Override
    public DetalleComanda guardarDetallesComandas(List<DetalleComandaDTO> listaDto) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        DetalleComanda ultimoGuardado = null;

        try {
            tx.begin();

            for (DetalleComandaDTO detalleComandaDTO : listaDto) {
                Producto producto = em.find(Producto.class, detalleComandaDTO.getProducto().getId());
                Comanda comanda = em.find(Comanda.class, detalleComandaDTO.getComanda().getId());

                DetalleComanda detalle = new DetalleComanda();
                detalle.setProducto(producto);
                detalle.setComanda(comanda);
                detalle.setCantidadProducto(detalleComandaDTO.getCantidadProducto());
                detalle.setPrecio(detalleComandaDTO.getPrecio());
                detalle.setNota(detalleComandaDTO.getNota());

                em.persist(detalle);
                ultimoGuardado = detalle; 
            }

            tx.commit();
            return ultimoGuardado;

        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Error al guardar lista de detalles de comanda", ex);
        }
    }

    @Override
    public List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        String jpql = "SELECT new wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO(" +
                      "dc.producto.nombre, dc.cantidadProducto, dc.precio, dc.nota) " +
                      "FROM DetalleComanda dc WHERE dc.comanda.id = :idComanda";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("idComanda", comandaDTO.getId());

        return query.getResultList();
    }

    @Override
    public void editarDetalleComanda(Long idComanda, ProductoSeleccionadoDTO productoSeleccionado) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        String jpql = "SELECT dc FROM DetalleComanda dc WHERE dc.comanda.id = :idComanda AND dc.producto.nombre = :nombreProducto";
        DetalleComanda detalle = entityManager.createQuery(jpql, DetalleComanda.class)
            .setParameter("idComanda", idComanda)
            .setParameter("nombreProducto", productoSeleccionado.getNombreProducto())
            .getSingleResult();

        detalle.setCantidadProducto(productoSeleccionado.getCantidad());
        detalle.setPrecio(productoSeleccionado.getPrecioUnitario());
        detalle.setNota(productoSeleccionado.getNotas());

        entityManager.merge(detalle);
        entityManager.getTransaction().commit();
        
    }



}
