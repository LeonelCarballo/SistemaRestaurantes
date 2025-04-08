/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import wonderland.sistemarestaurantesdominio.Empleado;

/**
 *
 * @author Dana Chavez
 */
public interface IEmpleadosDAO {
    public abstract Empleado iniciarSesion(String usuario, String contrasena);
}
