/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorialejb;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ozkrp
 */
@Named(value = "exampleBean")
@RequestScoped
public class ExampleBean {

    private String tipo;
    private int total;
    private double doble;

    public double getDoble() {
        return doble;
    }

    public void setDoble(double doble) {
        this.doble = doble;
    }
    private boolean checkeo;
    private Date fecha;

    public ExampleBean() {
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isCheckeo() {
        return checkeo;
    }

    public void setCheckeo(boolean checkeo) {
        this.checkeo = checkeo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void validarNumero (FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println("validarNumero invocada.");
        int fecha = (int) value;
        System.out.println("Numero: " + fecha);
        
        if (fecha == 123) {
            FacesMessage message = new FacesMessage("Numero correcto.");
        } else {
            FacesMessage message = new FacesMessage("numero incorrecto.");
            throw new ValidatorException(message);
        }
    }
    
}
