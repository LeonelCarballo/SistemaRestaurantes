
package wonderland.sistemarestaurantesnegocio;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author payde
 */
public interface IProductosBO {
    
     public Producto registrarProducto(NuevoProductoDTO nuevoProducto) throws NegocioException;
     
     public abstract List<Producto> obtenerTodos() throws NegocioException;
    
     public abstract List<Producto> obtenerProductoPorTipo(TipoProducto tipo) throws NegocioException;

     public Producto editarProducto(NuevoProductoDTO productoDTO) throws NegocioException;
     
     public abstract List<Producto> buscarPorNombre(String nombre) throws NegocioException;
}
