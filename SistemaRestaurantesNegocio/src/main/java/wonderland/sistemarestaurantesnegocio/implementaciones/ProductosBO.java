
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantesnegocio.IProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IProductosDAO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public class ProductosBO implements IProductosBO{
    private IProductosDAO productosDAO;

    public ProductosBO(IProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }
        
    @Override
    public Producto registrarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException {
        try {
            if (nuevoProducto.getNombre() == null || nuevoProducto.getNombre().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el nombre del producto.");
            }
            
            if (nuevoProducto.getNombre().equalsIgnoreCase("Nombre")) {
                throw new NegocioException("Debes proporcionar un nombre válido.");
            }
            
            if (nuevoProducto.getPrecio() <= 0) {
                throw new NegocioException("El precio debe ser mayor a 0.");
            }
            
            if (nuevoProducto.getTipoProducto() == null) {
                throw new NegocioException("Debes seleccionar una categoría para el producto.");
            }
            
            List<Producto> productosExistentes = productosDAO.obtenerTodos();
            String nombreNormalizado = normalizarNombre(nuevoProducto.getNombre());
            
            for (Producto productoExistente : productosExistentes) {
                if (normalizarNombre(productoExistente.getNombre()).equals(nombreNormalizado)) {
                    throw new NegocioException("Ya existe un producto con ese nombre.");
                }
            }
            
            try {
                return productosDAO.registrarProducto(nuevoProducto);
            } catch (PersistenciaException ex) {
                throw new NegocioException("No se pudo registrar el cliente");
            }
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
     }

    private String normalizarNombre(String nombre) {
        return nombre.trim().replaceAll("\\s+", " ").toLowerCase();
    }
        
    @Override
    public List<Producto> obtenerTodos() throws NegocioException {
        try {
            return productosDAO.obtenerTodos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
    
    @Override
    public List<Producto> obtenerProductoPorTipo(TipoProducto tipo) throws NegocioException{
        try {              
            return productosDAO.obtenerProductoPorTipo(tipo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
    
    @Override
    public Producto editarProducto(NuevoProductoDTO productoDTO) throws NegocioException {
        try {
            if (productoDTO.getNombre() == null || productoDTO.getNombre().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el nombre del producto.");
            }
            
            String nombreNormalizado = productoDTO.getNombre().trim().replaceAll("\\s+", "").toLowerCase();
            if (nombreNormalizado.equals("nombre")) {
                throw new NegocioException("Debes proporcionar un nombre válido.");
            }
            
            if (productoDTO.getPrecio() <= 0) {
                throw new NegocioException("El precio debe ser mayor a 0.");
            }
            
            if (productoDTO.getTipoProducto() == null) {
                throw new NegocioException("Debes seleccionar una categoría para el producto.");
            }
            
            List<Producto> todos = productosDAO.obtenerTodos();
            for (Producto existente : todos) {
                String existenteNormalizado = existente.getNombre().trim().replaceAll("\\s+", "").toLowerCase();
                if (existenteNormalizado.equals(nombreNormalizado) && !existente.getId().equals(productoDTO.getId())) {
                    throw new NegocioException("Ya existe un producto con ese nombre.");
                }
            }
            return productosDAO.editarProducto(productoDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
    
    @Override
     public List<Producto> buscarPorNombre(String nombre) throws NegocioException{
        try {
            return productosDAO.buscarPorNombre(nombre);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
}
