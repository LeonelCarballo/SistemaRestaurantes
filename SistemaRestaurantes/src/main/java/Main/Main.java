/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import wonderland.sistemarestaurantes.VentanaPrincipal;
import wonderland.sistemarestaurantes.control.ControlPresentacion;

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
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(control);
        ventanaPrincipal.setVisible(true);
        
    }
    
}
