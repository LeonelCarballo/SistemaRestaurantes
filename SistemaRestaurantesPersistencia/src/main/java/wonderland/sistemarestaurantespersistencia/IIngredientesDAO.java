/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;

/**
 *
 * @author leoca
 */
public interface IIngredientesDAO {
    
    public abstract Ingrediente registrarIngrediente(NuevoIngredienteDTO nuevoIngrediente);
    
    public abstract List<Ingrediente> consultarIngredientes();
    
    public abstract Ingrediente buscarIngredienteId(Long idCliente);   
    
    public abstract Ingrediente editarNombre(NuevoIngredienteDTO nuevoIngredienteDTO);
    
    public abstract Ingrediente aumentarStock(NuevoIngredienteDTO nuevoIngredienteDTO);
    
    public abstract List<Ingrediente> consultarIngredientesPorNombre(String nombre);
}
