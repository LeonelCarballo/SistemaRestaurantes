/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.daos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
            if (tx.isActive()) {
                tx.rollback();
            }
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
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al guardar lista de detalles de comanda", ex);
        }
    }

    @Override
    public List<ProductoSeleccionadoDTO> obtenerDetalleComandaPorComanda(ComandaDTO comandaDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        String jpql = "SELECT new wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO("
                + "dc.producto, dc.cantidadProducto, dc.precio, dc.nota) "
                + // ← Ahora pasa el producto completo
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

//    @Override
//    public List<DetalleComandaDTO> ActualizarDetallesComanda(List<DetalleComandaDTO> listaDto) {
//        EntityManager em = ManejadorConexiones.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        DetalleComanda ultimoGuardado = null;
//
//        try {
//            tx.begin();
//
//            // Verificar que haya al menos un DTO para obtener la comanda
//            if (listaDto.isEmpty()) {
//                throw new IllegalArgumentException("La lista de detalles no puede estar vacía");
//            }
//
//            Long idComanda = listaDto.get(0).getComanda().getId();
//
//            // 1. Obtener todos los detalles existentes de esta comanda
//            List<DetalleComanda> detallesExistentes = em.createQuery(
//                    "SELECT dc FROM DetalleComanda dc WHERE dc.comanda.id = :idComanda", DetalleComanda.class)
//                    .setParameter("idComanda", idComanda)
//                    .getResultList();
//
//            // 2. Crear mapa para búsqueda rápida (productoId -> DetalleComanda)
//            Map<Long, DetalleComanda> mapaExistentes = detallesExistentes.stream()
//                    .collect(Collectors.toMap(
//                            dc -> dc.getProducto().getId(),
//                            dc -> dc
//                    ));
//
//            // 3. Procesar cada DTO
//            for (DetalleComandaDTO dto : listaDto) {
//                Long idProducto = dto.getProducto().getId();
//                Producto producto = em.find(Producto.class, idProducto);
//                Comanda comanda = em.find(Comanda.class, idComanda);
//
//                if (mapaExistentes.containsKey(idProducto)) {
//                    // Caso 1: El producto ya existe en la comanda
//                    DetalleComanda detalleExistente = mapaExistentes.get(idProducto);
//
//                    if (!detalleExistente.getCantidadProducto().equals(dto.getCantidadProducto())) {
//                        // Solo actualizar si la cantidad cambió
//                        detalleExistente.setCantidadProducto(dto.getCantidadProducto());
//                        detalleExistente.setPrecio(dto.getPrecio());
//                        detalleExistente.setNota(dto.getNota());
//                        em.merge(detalleExistente);
//                        ultimoGuardado = detalleExistente;
//                    }
//                    // Si cantidad es igual, no hacer nada
//                } else {
//                    // Caso 2: Producto nuevo en la comanda
//                    DetalleComanda nuevoDetalle = new DetalleComanda();
//                    nuevoDetalle.setProducto(producto);
//                    nuevoDetalle.setComanda(comanda);
//                    nuevoDetalle.setCantidadProducto(dto.getCantidadProducto());
//                    nuevoDetalle.setPrecio(dto.getPrecio());
//                    nuevoDetalle.setNota(dto.getNota());
//
//                    em.persist(nuevoDetalle);
//                    ultimoGuardado = nuevoDetalle;
//                }
//            }
//
//            tx.commit();
//            return 
//
//        } catch (Exception ex) {
//            if (tx != null && tx.isActive()) {
//                tx.rollback();
//            }
//            throw new RuntimeException("Error al sincronizar detalles de comanda", ex);
//        }
//    }

    @Override
    public DetalleComanda ActualizarDetallesComanda(DetalleComandaDTO detalleComandaDTO) {
        EntityManager em = ManejadorConexiones.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Long idComanda = detalleComandaDTO.getComanda().getId();
            Long idProducto = detalleComandaDTO.getProducto().getId();

            // Buscar si ya existe un detalle para este producto en la comanda
            DetalleComanda detalleExistente = em.createQuery(
                    "SELECT dc FROM DetalleComanda dc WHERE dc.comanda.id = :idComanda AND dc.producto.id = :idProducto",
                    DetalleComanda.class)
                    .setParameter("idComanda", idComanda)
                    .setParameter("idProducto", idProducto)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            Producto producto = em.find(Producto.class, idProducto);
            Comanda comanda = em.find(Comanda.class, idComanda);

            DetalleComanda detalleActualizado;

            if (detalleExistente != null) {
                // Actualizar detalle existente
                detalleExistente.setCantidadProducto(detalleComandaDTO.getCantidadProducto());
                detalleExistente.setPrecio(detalleComandaDTO.getPrecio());
                detalleExistente.setNota(detalleComandaDTO.getNota());
                em.merge(detalleExistente);
                detalleActualizado = detalleExistente;
            } else {
                // Crear nuevo detalle
                DetalleComanda nuevoDetalle = new DetalleComanda();
                nuevoDetalle.setProducto(producto);
                nuevoDetalle.setComanda(comanda);
                nuevoDetalle.setCantidadProducto(detalleComandaDTO.getCantidadProducto());
                nuevoDetalle.setPrecio(detalleComandaDTO.getPrecio());
                nuevoDetalle.setNota(detalleComandaDTO.getNota());

                em.persist(nuevoDetalle);
                detalleActualizado = nuevoDetalle;
            }

            tx.commit();
            return detalleActualizado;

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error al actualizar detalle de comanda", ex);
        }
    }

    
    
    
    

}
