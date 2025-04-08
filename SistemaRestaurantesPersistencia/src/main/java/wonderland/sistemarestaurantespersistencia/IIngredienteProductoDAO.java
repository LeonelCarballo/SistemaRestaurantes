
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.IngredienteProducto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;

/**
 *
 * @author payde
 */
public interface IIngredienteProductoDAO {
    
    public IngredienteProducto registrarIngredienteProducto(IngredienteProductoDTO ingredienteProductoDTO);

    public abstract List<IngredienteProducto> buscarPorProducto(Long idProducto);
    
    public void eliminarIngredientesPorProducto(Long idProducto);
}
