/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.fabrica;

import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.IngredientesBO;
import wonderland.sistemarestaurantespersistencia.IClientesDAO;
import wonderland.sistemarestaurantespersistencia.IIngredientesDAO;
import wonderland.sistemarestaurantespersistencia.daos.ClientesDAO;
import wonderland.sistemarestaurantespersistencia.daos.IngredientesDAO;

/**
 *
 * @author Dana Chavez
 */
public class FabricaObjetosNegocio {
    
     public static IClientesBO crearVideojuegosBO(){
        IClientesDAO clientesDAO = new ClientesDAO();
        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }
     
     public static IIngredientesBO CrearIngredientesBO(){
        IIngredientesDAO ingredientesDAO = new IngredientesDAO();
        IIngredientesBO ingredientesBO = new IngredientesBO(ingredientesDAO);
        return ingredientesBO;
    }
    
}
