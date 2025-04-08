/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesnegocio.implementaciones;

import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantespersistencia.IComandasDAO;

/**
 *
 * @author Dana Chavez
 */
public class ComandasBO implements IComandasBO {
    
    private IComandasDAO comandasDAO;
    
    @Override
    public Comanda asociarClienteAComanda(ComandaDTO comandaDTO) throws NegocioException {
        return this.comandasDAO.asociarClienteAComanda(comandaDTO);
    }
    
}
