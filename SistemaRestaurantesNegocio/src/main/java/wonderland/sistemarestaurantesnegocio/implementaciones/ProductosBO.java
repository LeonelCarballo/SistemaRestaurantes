
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantesnegocio.IProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IProductosDAO;

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
        return productosDAO.registrarProducto(nuevoProducto);
    }
       
    @Override
    public List<Producto> obtenerProductoPorTipo(TipoProducto tipo) {
        return productosDAO.obtenerProductoPorTipo(tipo);              
    }
    
}
