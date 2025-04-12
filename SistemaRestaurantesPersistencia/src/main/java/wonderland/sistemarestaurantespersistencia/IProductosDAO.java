/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia;

import java.util.List;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantespersistencia.persistenciaexception.PersistenciaException;

/**
 *
 * @author payde
 */
public interface IProductosDAO {
    
    public Producto registrarProducto(NuevoProductoDTO nuevoProducto) throws PersistenciaException;
    
    public abstract List<Producto> obtenerTodos() throws PersistenciaException;
    
    public abstract List<Producto> obtenerProductoPorTipo(TipoProducto tipo) throws PersistenciaException;
    
    public Producto editarProducto(NuevoProductoDTO nuevoProducto) throws PersistenciaException;
    
    public abstract List<Producto> buscarPorNombre(String nombre) throws PersistenciaException;
}
