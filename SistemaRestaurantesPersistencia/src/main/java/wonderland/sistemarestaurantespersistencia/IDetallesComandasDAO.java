/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.DetalleComanda;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;

/**
 *
 * @author payde
 */
public interface IDetallesComandasDAO {
    
    public abstract DetalleComanda guardarDetalleComanda(DetalleComandaDTO detalleComanda);
    
    public abstract DetalleComanda guardarDetallesComandas(List<DetalleComandaDTO> detalleComanda);
    
}
