/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author payde
 */
public class ProductoMapper {
     public static Producto toProducto(ProductoSeleccionadoDTO productoSeleccionadoDTO) {
        Producto producto = new Producto();
        producto.setId(productoSeleccionadoDTO.getIdProducto());
        producto.setNombre(productoSeleccionadoDTO.getNombreProducto());
        producto.setPrecio(productoSeleccionadoDTO.getPrecioUnitario());
        return producto;
    }

    public static ProductoSeleccionadoDTO toDTO(Producto producto) {
        ProductoSeleccionadoDTO productoSeleccionadoDTO = new ProductoSeleccionadoDTO();
        productoSeleccionadoDTO.setIdProducto(producto.getId());
        productoSeleccionadoDTO.setNombreProducto(producto.getNombre());
        productoSeleccionadoDTO.setPrecioUnitario(producto.getPrecio());
        productoSeleccionadoDTO.setCantidad(Integer.SIZE); 
        return productoSeleccionadoDTO;
    }
}
