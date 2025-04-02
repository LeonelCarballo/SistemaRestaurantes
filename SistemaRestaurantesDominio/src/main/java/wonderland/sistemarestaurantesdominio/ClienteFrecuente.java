/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantesdominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dana Chavez
 */

@Entity
@Table(name = "clientes_frecuentes")
public class ClienteFrecuente extends Cliente {
    
    @Transient
    private Integer puntosFidelidad;
    
    @Transient
    private Float gastoTotalAcumulado;

    public Integer getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(Integer puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public Float getGastoTotalAcumulado() {
        return gastoTotalAcumulado;
    }

    public void setGastoTotalAcumulado(Float gastoTotalAcumulado) {
        this.gastoTotalAcumulado = gastoTotalAcumulado;
    }
}
