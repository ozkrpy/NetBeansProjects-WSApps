/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "pacienteBean")
@RequestScoped
public class PacienteBean {

    int id;
    String nombre;
    String apellido;
    
    public PacienteBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String confirmar() {
        System.out.println("se guardo");
        if (id == 0) {
            throw new RuntimeException("El id no puede ser " + id);
        }
        return null;
    }
}
