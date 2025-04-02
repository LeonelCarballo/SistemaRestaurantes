package wonderland.sistemarestaurantesdominio.dtos;

import wonderland.sistemarestaurantesdominio.TipoProducto;

/**
 *
 * @author payde
 */
public class NuevoProductoDTO {
    private String nombre;
    private float precio;
    private TipoProducto tipoProducto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
}
