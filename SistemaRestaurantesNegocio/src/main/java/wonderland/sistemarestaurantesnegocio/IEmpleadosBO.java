/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio;

import wonderland.sistemarestaurantesdominio.dtos.EmpleadoDTO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public interface IEmpleadosBO {
    
    public abstract EmpleadoDTO iniciarSesion(String usuario, String constrasena) throws NegocioException;
    
}
