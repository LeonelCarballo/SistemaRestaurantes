/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.fabrica;

import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;
import wonderland.sistemarestaurantespersistencia.IClientesDAO;
import wonderland.sistemarestaurantespersistencia.daos.ClientesDAO;

/**
 *
 * @author Dana Chavez
 */
public class FabricaObjetosNegocio {
    
     public static IClientesBO crearClientesBO(){
        IClientesDAO clientesDAO = new ClientesDAO();
        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }
    
}
