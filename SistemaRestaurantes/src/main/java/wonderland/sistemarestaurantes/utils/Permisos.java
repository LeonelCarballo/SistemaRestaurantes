/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.utils;

/**
 *
 * @author Dana Chavez
 */
public class Permisos {
    
    public static boolean esAdministrador() {
        return SesionActual.getIdRol() == 1;
    }

    public static boolean esMesero() {
        return SesionActual.getIdRol() == 2;
    }

    public static boolean esCocinero() {
        return SesionActual.getIdRol() == 3;
    }
    
}
