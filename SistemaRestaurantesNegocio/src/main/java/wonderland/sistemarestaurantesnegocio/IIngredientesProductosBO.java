/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import java.util.List;
import wonderland.sistemarestaurantesdominio.IngredienteProducto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author payde
 */
public interface IIngredientesProductosBO {
   
    public IngredienteProducto registrarIngredienteProducto(IngredienteProductoDTO ingredienteProductoDTO) throws NegocioException;

    public abstract List<IngredienteProductoDTO> buscarPorProducto(Long idProducto) throws NegocioException;
    
    public void eliminarIngredientesPorProducto(Long idProducto)throws NegocioException;
}
