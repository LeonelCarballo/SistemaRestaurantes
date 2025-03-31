/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;

/**
 *
 * @author leoca
 */
public interface IIngredientesDAO {
    
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente);
    
}
