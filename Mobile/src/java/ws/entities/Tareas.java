/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozkrp
 */
@Entity
@Table(name = "tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t"),
    @NamedQuery(name = "Tareas.findBySolicitudNumero", query = "SELECT t FROM Tareas t WHERE t.solicitudNumero = :solicitudNumero"),
    @NamedQuery(name = "Tareas.findByPersonaCodigo", query = "SELECT t FROM Tareas t WHERE t.personaCodigo = :personaCodigo"),
    @NamedQuery(name = "Tareas.findByPersonaNombre", query = "SELECT t FROM Tareas t WHERE t.personaNombre = :personaNombre"),
    @NamedQuery(name = "Tareas.findBySolicitudFechaInicio", query = "SELECT t FROM Tareas t WHERE t.solicitudFechaInicio = :solicitudFechaInicio"),
    @NamedQuery(name = "Tareas.findBySolicitudReferencia", query = "SELECT t FROM Tareas t WHERE t.solicitudReferencia = :solicitudReferencia"),
    @NamedQuery(name = "Tareas.findBySolicitudTipoCodigo", query = "SELECT t FROM Tareas t WHERE t.solicitudTipoCodigo = :solicitudTipoCodigo"),
    @NamedQuery(name = "Tareas.findBySolicitudTipoDescripcion", query = "SELECT t FROM Tareas t WHERE t.solicitudTipoDescripcion = :solicitudTipoDescripcion"),
    @NamedQuery(name = "Tareas.findByTareaNumero", query = "SELECT t FROM Tareas t WHERE t.tareaNumero = :tareaNumero"),
    @NamedQuery(name = "Tareas.findByTareaTipoCodigo", query = "SELECT t FROM Tareas t WHERE t.tareaTipoCodigo = :tareaTipoCodigo"),
    @NamedQuery(name = "Tareas.findByTareaTipoDescripcion", query = "SELECT t FROM Tareas t WHERE t.tareaTipoDescripcion = :tareaTipoDescripcion"),
    @NamedQuery(name = "Tareas.findByTareaEstado", query = "SELECT t FROM Tareas t WHERE t.tareaEstado = :tareaEstado"),
    @NamedQuery(name = "Tareas.findByTareaFechaAsignacion", query = "SELECT t FROM Tareas t WHERE t.tareaFechaAsignacion = :tareaFechaAsignacion"),
    @NamedQuery(name = "Tareas.findByTareaAsignadorCodigo", query = "SELECT t FROM Tareas t WHERE t.tareaAsignadorCodigo = :tareaAsignadorCodigo"),
    @NamedQuery(name = "Tareas.findByTareaAsignadorNombre", query = "SELECT t FROM Tareas t WHERE t.tareaAsignadorNombre = :tareaAsignadorNombre"),
    @NamedQuery(name = "Tareas.findByTareaDescripcion", query = "SELECT t FROM Tareas t WHERE t.tareaDescripcion = :tareaDescripcion"),
    @NamedQuery(name = "Tareas.findByTareaComentarioRecibido", query = "SELECT t FROM Tareas t WHERE t.tareaComentarioRecibido = :tareaComentarioRecibido"),
    @NamedQuery(name = "Tareas.findByTareaComentarioAdicional", query = "SELECT t FROM Tareas t WHERE t.tareaComentarioAdicional = :tareaComentarioAdicional")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "solicitud_numero")
    private String solicitudNumero;
    @Size(max = 10)
    @Column(name = "persona_codigo")
    private String personaCodigo;
    @Size(max = 100)
    @Column(name = "persona_nombre")
    private String personaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "solicitud_fecha_inicio")
    private String solicitudFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "solicitud_Referencia")
    private String solicitudReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "solicitud_Tipo_Codigo")
    private String solicitudTipoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "solicitud_Tipo_Descripcion")
    private String solicitudTipoDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tarea_Numero")
    private String tareaNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tarea_Tipo_Codigo")
    private String tareaTipoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tarea_Tipo_Descripcion")
    private String tareaTipoDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tarea_Estado")
    private String tareaEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tarea_Fecha_Asignacion")
    private String tareaFechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tarea_Asignador_Codigo")
    private String tareaAsignadorCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tarea_Asignador_Nombre")
    private String tareaAsignadorNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tarea_Descripcion")
    private String tareaDescripcion;
    @Size(max = 100)
    @Column(name = "tarea_Comentario_Recibido")
    private String tareaComentarioRecibido;
    @Size(max = 100)
    @Column(name = "tarea_Comentario_Adicional")
    private String tareaComentarioAdicional;
    @JoinColumn(name = "solicitud_numero", referencedColumnName = "numero_solicitud", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Solicitudes solicitudes;

    public Tareas() {
    }

    public Tareas(String solicitudNumero) {
        this.solicitudNumero = solicitudNumero;
    }

    public Tareas(String solicitudNumero, String solicitudFechaInicio, String solicitudReferencia, String solicitudTipoCodigo, String solicitudTipoDescripcion, String tareaNumero, String tareaTipoCodigo, String tareaTipoDescripcion, String tareaEstado, String tareaFechaAsignacion, String tareaAsignadorCodigo, String tareaAsignadorNombre, String tareaDescripcion) {
        this.solicitudNumero = solicitudNumero;
        this.solicitudFechaInicio = solicitudFechaInicio;
        this.solicitudReferencia = solicitudReferencia;
        this.solicitudTipoCodigo = solicitudTipoCodigo;
        this.solicitudTipoDescripcion = solicitudTipoDescripcion;
        this.tareaNumero = tareaNumero;
        this.tareaTipoCodigo = tareaTipoCodigo;
        this.tareaTipoDescripcion = tareaTipoDescripcion;
        this.tareaEstado = tareaEstado;
        this.tareaFechaAsignacion = tareaFechaAsignacion;
        this.tareaAsignadorCodigo = tareaAsignadorCodigo;
        this.tareaAsignadorNombre = tareaAsignadorNombre;
        this.tareaDescripcion = tareaDescripcion;
    }

    public String getSolicitudNumero() {
        return solicitudNumero;
    }

    public void setSolicitudNumero(String solicitudNumero) {
        this.solicitudNumero = solicitudNumero;
    }

    public String getPersonaCodigo() {
        return personaCodigo;
    }

    public void setPersonaCodigo(String personaCodigo) {
        this.personaCodigo = personaCodigo;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getSolicitudFechaInicio() {
        return solicitudFechaInicio;
    }

    public void setSolicitudFechaInicio(String solicitudFechaInicio) {
        this.solicitudFechaInicio = solicitudFechaInicio;
    }

    public String getSolicitudReferencia() {
        return solicitudReferencia;
    }

    public void setSolicitudReferencia(String solicitudReferencia) {
        this.solicitudReferencia = solicitudReferencia;
    }

    public String getSolicitudTipoCodigo() {
        return solicitudTipoCodigo;
    }

    public void setSolicitudTipoCodigo(String solicitudTipoCodigo) {
        this.solicitudTipoCodigo = solicitudTipoCodigo;
    }

    public String getSolicitudTipoDescripcion() {
        return solicitudTipoDescripcion;
    }

    public void setSolicitudTipoDescripcion(String solicitudTipoDescripcion) {
        this.solicitudTipoDescripcion = solicitudTipoDescripcion;
    }

    public String getTareaNumero() {
        return tareaNumero;
    }

    public void setTareaNumero(String tareaNumero) {
        this.tareaNumero = tareaNumero;
    }

    public String getTareaTipoCodigo() {
        return tareaTipoCodigo;
    }

    public void setTareaTipoCodigo(String tareaTipoCodigo) {
        this.tareaTipoCodigo = tareaTipoCodigo;
    }

    public String getTareaTipoDescripcion() {
        return tareaTipoDescripcion;
    }

    public void setTareaTipoDescripcion(String tareaTipoDescripcion) {
        this.tareaTipoDescripcion = tareaTipoDescripcion;
    }

    public String getTareaEstado() {
        return tareaEstado;
    }

    public void setTareaEstado(String tareaEstado) {
        this.tareaEstado = tareaEstado;
    }

    public String getTareaFechaAsignacion() {
        return tareaFechaAsignacion;
    }

    public void setTareaFechaAsignacion(String tareaFechaAsignacion) {
        this.tareaFechaAsignacion = tareaFechaAsignacion;
    }

    public String getTareaAsignadorCodigo() {
        return tareaAsignadorCodigo;
    }

    public void setTareaAsignadorCodigo(String tareaAsignadorCodigo) {
        this.tareaAsignadorCodigo = tareaAsignadorCodigo;
    }

    public String getTareaAsignadorNombre() {
        return tareaAsignadorNombre;
    }

    public void setTareaAsignadorNombre(String tareaAsignadorNombre) {
        this.tareaAsignadorNombre = tareaAsignadorNombre;
    }

    public String getTareaDescripcion() {
        return tareaDescripcion;
    }

    public void setTareaDescripcion(String tareaDescripcion) {
        this.tareaDescripcion = tareaDescripcion;
    }

    public String getTareaComentarioRecibido() {
        return tareaComentarioRecibido;
    }

    public void setTareaComentarioRecibido(String tareaComentarioRecibido) {
        this.tareaComentarioRecibido = tareaComentarioRecibido;
    }

    public String getTareaComentarioAdicional() {
        return tareaComentarioAdicional;
    }

    public void setTareaComentarioAdicional(String tareaComentarioAdicional) {
        this.tareaComentarioAdicional = tareaComentarioAdicional;
    }

    public Solicitudes getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Solicitudes solicitudes) {
        this.solicitudes = solicitudes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudNumero != null ? solicitudNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.solicitudNumero == null && other.solicitudNumero != null) || (this.solicitudNumero != null && !this.solicitudNumero.equals(other.solicitudNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.entities.Tareas[ solicitudNumero=" + solicitudNumero + " ]";
    }
    
}
