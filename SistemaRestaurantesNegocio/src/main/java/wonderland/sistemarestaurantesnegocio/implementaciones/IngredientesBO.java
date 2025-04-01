/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IIngredientesDAO;

/**
 *
 * @author leoca
 */
public class IngredientesBO implements IIngredientesBO {
    
    private IIngredientesDAO ingredientesDAO;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }
    
    @Override
    public Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException {
        
        if (nuevoIngrediente.getNombre() == null || nuevoIngrediente.getNombre().isEmpty()) {
            throw new NegocioException ("Debes proporcionar el nombre del ingrediente");
        }
        
        if (nuevoIngrediente.getNombre().equalsIgnoreCase("Nombre")) {
            throw new NegocioException ("Debes proporcionar el nombre del ingrediente");
        }
        
        if (nuevoIngrediente.getStock() < 0) {
            throw new NegocioException ("Debes proporcionar una cantidad válida en stock");
        }

        if (Float.isNaN(nuevoIngrediente.getStock())) {
            throw new NegocioException ("Se ingresó la cantidad incorrectamente");
        }
        
        if (nuevoIngrediente.getUnidadMedida()== null) {
            throw new NegocioException ("Debes proporcionar la unidad de medida (Piezas, gr o ml)");
        }
        
        
        
       
        
        return this.ingredientesDAO.registrarIngrediente(nuevoIngrediente);
    }
    
    
    
}
