/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudes.findAll", query = "SELECT s FROM Solicitudes s"),
    @NamedQuery(name = "Solicitudes.findByNumeroSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.numeroSolicitud = :numeroSolicitud"),
    @NamedQuery(name = "Solicitudes.findByDescripcionSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.descripcionSolicitud = :descripcionSolicitud"),
    @NamedQuery(name = "Solicitudes.findByUsuario", query = "SELECT s FROM Solicitudes s WHERE s.usuario = :usuario")})
public class Solicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_solicitud")
    private String numeroSolicitud;
    @Size(max = 50)
    @Column(name = "descripcion_solicitud")
    private String descripcionSolicitud;
    @Size(max = 32)
    @Column(name = "usuario")
    private String usuario;

    public Solicitudes() {
    }

    public Solicitudes(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSolicitud != null ? numeroSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudes)) {
            return false;
        }
        Solicitudes other = (Solicitudes) object;
        if ((this.numeroSolicitud == null && other.numeroSolicitud != null) || (this.numeroSolicitud != null && !this.numeroSolicitud.equals(other.numeroSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.entidades.Solicitudes[ numeroSolicitud=" + numeroSolicitud + " ]";
    }
    
}
