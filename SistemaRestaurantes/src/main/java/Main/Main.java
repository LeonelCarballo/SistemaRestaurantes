/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import wonderland.sistemarestaurantes.IniciarSesion;
import wonderland.sistemarestaurantes.VentanaPrincipal;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesnegocio.IEmpleadosBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.EmpleadosBO;
import wonderland.sistemarestaurantespersistencia.IEmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.daos.EmpleadosDAO;

/**
 *
 * @author leoca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlPresentacion control = new ControlPresentacion();
        IEmpleadosDAO empleadosDAO = new EmpleadosDAO();
        IEmpleadosBO empleadosBO = new EmpleadosBO(empleadosDAO);
        IniciarSesion iniciarSesion = new IniciarSesion(control,empleadosBO);
        iniciarSesion.setVisible(true);
        
    }
    
}
