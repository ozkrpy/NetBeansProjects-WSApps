/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.servicios;

/**
 *
 * @author ozkrp
 */
public class Tarea {
    
    private String personaCodigo;
    private String personaNombre;
    private String solicitudFechaInicio;
    private String solicitudReferencia;
    private String solicitudTipoCodigo;
    private String solicitudTipoDescripcion;
    private String tareaNumero;
    private String tareaTipoCodigo;
    private String tareaTipoDescripcion;
    private String tareaEstado;
    private String tareaFechaAsignacion;
    private String tareaAsignadorCodigo;
    private String tareaAsignadorNombre;
    private String tareaDescripcion;
    private String tareaComentarioRecibido;
    private String tareaComentarioAdicional;

    public Tarea() {
    }

    public Tarea(String personaCodigo, String personaNombre, String solicitudFechaInicio, String solicitudReferencia, String solicitudTipoCodigo, String solicitudTipoDescripcion, String tareaNumero, String tareaTipoCodigo, String tareaTipoDescripcion, String tareaEstado, String tareaFechaAsignacion, String tareaAsignadorCodigo, String tareaAsignadorNombre, String tareaDescripcion, String tareaComentarioRecibido, String tareaComentarioAdicional) {
        this.personaCodigo = personaCodigo;
        this.personaNombre = personaNombre;
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
        this.tareaComentarioRecibido = tareaComentarioRecibido;
        this.tareaComentarioAdicional = tareaComentarioAdicional;
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
    
    
    
}
