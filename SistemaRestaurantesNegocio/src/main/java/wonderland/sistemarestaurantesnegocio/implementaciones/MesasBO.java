/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.NuevaMesaDTO;
import wonderland.sistemarestaurantesnegocio.IMesasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IMesasDAO;

/**
 *
 * @author Dana Chavez
 */
public class MesasBO implements IMesasBO {
    
    private IMesasDAO mesasDAO;
    
    public static final int LIMITE_MESAS = 80;
    
    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }

    @Override
    public List<Mesa> agregarMesas(NuevaMesaDTO nuevaMesa) throws NegocioException {
        return mesasDAO.agregarMesas(nuevaMesa);
    }

    @Override
    public List<Mesa> mostrarMesas() throws NegocioException {
        
        return this.mesasDAO.mostrarMesas();
    }
    
    
    
}
