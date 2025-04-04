
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
     
     public abstract List<Producto> obtenerProductoPorTipo(TipoProducto tipo) throws NegocioException;
}
