/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import wonderland.sistemarestaurantesdominio.Empleado;
import wonderland.sistemarestaurantesdominio.dtos.EmpleadoDTO;
import wonderland.sistemarestaurantesnegocio.IEmpleadosBO;
import wonderland.sistemarestaurantespersistencia.IEmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.daos.EmpleadosDAO;

/**
 *
 * @author Dana Chavez
 */
public class EmpleadosBO implements IEmpleadosBO {
    
    private IEmpleadosDAO empleadosDAO;

    public EmpleadosBO(IEmpleadosDAO empleadosDAO) {
        this.empleadosDAO = empleadosDAO;
    }

    @Override
    public EmpleadoDTO iniciarSesion(String usuario, String contrasena) {
        Empleado empleado = empleadosDAO.iniciarSesion(usuario, contrasena);

        if (empleado != null) {
            return new EmpleadoDTO(
                empleado.getId(),
                empleado.getUsuario(),
                empleado.getRol().getId()
            );
        }

        return null;
    }
}
