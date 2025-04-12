/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.Empleado;
import wonderland.sistemarestaurantesdominio.dtos.EmpleadoDTO;
import wonderland.sistemarestaurantesnegocio.IEmpleadosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IEmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.daos.EmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

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
    public EmpleadoDTO iniciarSesion(String usuario, String contrasena) throws NegocioException {
        try {
            Empleado empleado = empleadosDAO.iniciarSesion(usuario, contrasena);
            
            if (empleado != null) {
                return new EmpleadoDTO(
                        empleado.getId(),
                        empleado.getUsuario(),
                        empleado.getRol().getId()
                );
            }
            
            return null;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo registrar el cliente");
        }
    }
}
