/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author leoca
 */
public interface IIngredientesBO {
    
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;
    
}
