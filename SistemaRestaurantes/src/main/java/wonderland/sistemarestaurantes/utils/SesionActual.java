/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.utils;

import wonderland.sistemarestaurantesdominio.dtos.EmpleadoDTO;

/**
 *
 * @author Dana Chavez
 */
public class SesionActual {
    
    private static EmpleadoDTO empleado;

    public static void setEmpleado(EmpleadoDTO e) {
        empleado = e;
    }

    public static EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public static Long getIdRol() {
        return empleado != null ? empleado.getIdRol() : null;
    }
   
}
