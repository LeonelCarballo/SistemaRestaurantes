/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leoca
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_comanda")
    private Long id;
    
    @Column (name = "folio", nullable = false , length = 15)
    private String folio;
    
    @Enumerated (EnumType.STRING)
    @Column (name = "estado" , nullable = false)
    private EstadoComanda estadoComanda; 
    
    @Temporal (TemporalType.TIMESTAMP)
    @Column (name = "fechaHora_creacion" , nullable = false)
    private Calendar fechaHora_creacion;
    
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    public Comanda() {
    }

    public Comanda(Long id, String folio, EstadoComanda estadoComanda, Calendar fechaHora_creacion) {
        this.id = id;
        this.folio = folio;
        this.estadoComanda = estadoComanda;
        this.fechaHora_creacion = fechaHora_creacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public EstadoComanda getEstadoComanda() {
        return estadoComanda;
    }

    public void setEstadoComanda(EstadoComanda estadoComanda) {
        this.estadoComanda = estadoComanda;
    }

    public Calendar getFechaHora_creacion() {
        return fechaHora_creacion;
    }

    public void setFechaHora_creacion(Calendar fechaHora_creacion) {
        this.fechaHora_creacion = fechaHora_creacion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comanda[ id=" + id + " ]";
    }
    
}
