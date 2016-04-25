/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.operations;

/**
 *
 * @author ozkrpy
 */
public class Solicitud {

    private String numero_solicitud;
    private String descripcion_solicitud;

    public Solicitud() {
    }

    
    public Solicitud(String title, String description) {
        super();
        this.numero_solicitud = title;
        this.descripcion_solicitud = description;
    }

    public String getNumero_solicitud() {
        return numero_solicitud;
    }

    public void setNumero_solicitud(String numero_solicitud) {
        this.numero_solicitud = numero_solicitud;
    }

    public String getDescripcion_solicitud() {
        return descripcion_solicitud;
    }
    
    public void setDescripcion_solicitud(String descripcion_solicitud) {
        this.descripcion_solicitud = descripcion_solicitud;
    }
}
