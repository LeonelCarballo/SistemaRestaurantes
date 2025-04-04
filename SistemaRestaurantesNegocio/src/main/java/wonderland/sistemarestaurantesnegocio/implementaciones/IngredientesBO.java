/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.UnidadMedida;
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
            throw new NegocioException("Debes proporcionar el nombre del ingrediente");
        }

        if (nuevoIngrediente.getNombre().equalsIgnoreCase("Nombre")) {
            throw new NegocioException("Debes proporcionar el nombre del ingrediente");
        }

        if (nuevoIngrediente.getStock() < 0) {
            throw new NegocioException("Debes proporcionar una cantidad válida en stock");
        }

        if (Float.isNaN(nuevoIngrediente.getStock())) {
            throw new NegocioException("Se ingresó la cantidad incorrectamente");
        }

        if (nuevoIngrediente.getUnidadMedida() == null) {
            throw new NegocioException("Debes proporcionar la unidad de medida (Piezas, gr o ml)");
        }
        
        if (existeIngrediente(nuevoIngrediente.getNombre(), nuevoIngrediente.getUnidadMedida(), nuevoIngrediente.getId()) == true) {
            throw new NegocioException("Ya existe un ingrediente con el mismo nombre y unidad de medida");
        }

        return this.ingredientesDAO.registrarIngrediente(nuevoIngrediente);
    }

    @Override
    public List<Ingrediente> consultarIngredientes() throws NegocioException {
        return this.ingredientesDAO.consultarIngredientes();
    }

    @Override
    public Ingrediente editarIngrediente(NuevoIngredienteDTO nuevoIngredienteDTO) throws NegocioException {

        if (existeIngrediente(nuevoIngredienteDTO.getNombre(), nuevoIngredienteDTO.getUnidadMedida(), nuevoIngredienteDTO.getId()) == true) {
            throw new NegocioException("Ya existe un ingrediente con el mismo nombre y unidad de medida");
        }

        if (nuevoIngredienteDTO.getNombre() == null || nuevoIngredienteDTO.getNombre().isEmpty()) {
            throw new NegocioException("Debes proporcionar el nombre del ingrediente");
        }

        return this.ingredientesDAO.editarNombre(nuevoIngredienteDTO);
    }

    public boolean existeIngrediente(String nombre, UnidadMedida unidadMedida, Long idExcluido) throws NegocioException {
        List<Ingrediente> ingredientes = ingredientesDAO.consultarIngredientes();
        return ingredientes.stream()
                .anyMatch(i -> i.getNombre().equalsIgnoreCase(nombre)
                && i.getUnidadMedida().equals(unidadMedida));
    }

    @Override
    public Ingrediente aumentarStock(NuevoIngredienteDTO nuevoIngredienteDTO) throws NegocioException {

        return this.ingredientesDAO.aumentarStock(nuevoIngredienteDTO);
    }

    @Override
    public List<Ingrediente> consultarIngredientesPorNombre(String filtroNombre) throws NegocioException {
        
        return this.ingredientesDAO.consultarIngredientesPorNombre(filtroNombre);
        
    }
}
