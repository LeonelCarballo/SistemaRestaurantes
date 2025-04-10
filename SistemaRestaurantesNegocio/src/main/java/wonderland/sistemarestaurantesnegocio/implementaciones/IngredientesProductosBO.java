/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.ArrayList;
import java.util.List;
import wonderland.sistemarestaurantesdominio.IngredienteProducto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.daos.IngredienteProductoDAO;

import wonderland.sistemarestaurantesnegocio.IIngredientesProductosBO;



public class IngredientesProductosBO implements IIngredientesProductosBO{
    private IngredienteProductoDAO ingredienteProductoDAO;
    private IngredienteProductoDTO ingredienteProductoDTO;
    
    
    public IngredientesProductosBO(IngredienteProductoDAO ingredienteProductoDAO) {
        this.ingredienteProductoDAO = ingredienteProductoDAO;
    }

    @Override
    public IngredienteProducto registrarIngredienteProducto(IngredienteProductoDTO ingredienteProductoDTO) throws NegocioException {
         if (ingredienteProductoDTO == null) {
        throw new NegocioException("No se proporcionó información del ingrediente.");
    }

    if (ingredienteProductoDTO.getIdProducto() == null) {
        throw new NegocioException("Falta el ID del producto.");
    }

    if (ingredienteProductoDTO.getIdIngrediente() == null) {
        throw new NegocioException("Debes seleccionar un ingrediente válido.");
    }

    if (ingredienteProductoDTO.getCantidad() == null) {
        throw new NegocioException("La cantidad debe ser mayor a cero.");
    }
    
        return ingredienteProductoDAO.registrarIngredienteProducto(ingredienteProductoDTO);
    }

    @Override
    public List<IngredienteProductoDTO> buscarPorProducto(Long idProducto) throws NegocioException {
        List<IngredienteProducto> entidades = ingredienteProductoDAO.buscarPorProducto(idProducto);
        List<IngredienteProductoDTO> ingredientesProductosDTOS = new ArrayList<>();

        for (IngredienteProducto entidad : entidades) {
            IngredienteProductoDTO ingredienteProductoDTO = new IngredienteProductoDTO();
            ingredienteProductoDTO.setIdProducto(entidad.getProducto().getId());
            ingredienteProductoDTO.setIdIngrediente(entidad.getIngrediente().getId());
            ingredienteProductoDTO.setIngrediente(entidad.getIngrediente()); 
            ingredienteProductoDTO.setCantidad(entidad.getCantidad());
            ingredientesProductosDTOS.add(ingredienteProductoDTO);
        }
        return ingredientesProductosDTOS;
    }   

    @Override
    public void eliminarIngredientesPorProducto(Long idProducto) throws NegocioException {
        this.ingredienteProductoDAO.eliminarIngredientesPorProducto(idProducto);
    }

    
}
