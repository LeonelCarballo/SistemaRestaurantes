
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.IngredienteProducto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public interface IIngredienteProductoDAO {
    
    public IngredienteProducto registrarIngredienteProducto(IngredienteProductoDTO ingredienteProductoDTO) throws PersistenciaException;

    public abstract List<IngredienteProducto> buscarPorProducto(Long idProducto) throws PersistenciaException;
    
    public void eliminarIngredientesPorProducto(Long idProducto) throws PersistenciaException;
}
