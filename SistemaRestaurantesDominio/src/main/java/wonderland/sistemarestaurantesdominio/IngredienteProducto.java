/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesdominio;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author payde
 */

@Entity
@Table(name="ingredientes_productos")
public class IngredienteProducto {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name= "id_ingrediente_producto")
    private Long id;
    
    @Column(name= "cantidad", nullable = false)
    private Float cantidad;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    @ManyToOne()
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;
    
    public IngredienteProducto() {
    }

    public IngredienteProducto(Long id, Float cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IngredienteProducto other = (IngredienteProducto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "IngredienteProducto{" + "id=" + id + '}';
    }
 
}
