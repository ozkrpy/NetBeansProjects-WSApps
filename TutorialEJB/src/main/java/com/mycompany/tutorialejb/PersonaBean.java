/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorialejb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "personaBean")
@RequestScoped
public class PersonaBean {

    private List<Persona> personas;
    
    public PersonaBean() {
    }
    
    @PostConstruct
    public void init () {
        System.out.println("instanciar el elemento personas.");
        personas = new ArrayList<Persona>();
        personas.add(new Persona(1,"nombre1","departamento1"));
        personas.add(new Persona(1,"nombre2","departamento2"));
        personas.add(new Persona(1,"nombre3","departamento3"));
        personas.add(new Persona(1,"nombre4","departamento4"));
        personas.add(new Persona(1,"nombre5","departamento5"));
        personas.add(new Persona(1,"nombre6","departamento6"));
        System.out.println("se termino de instanciar el elemento personas.");
    }
    
    public List<Persona> getPersonas() {
        System.out.println("instanciar getPersonas");
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        System.out.println("instanciar setPersonas");
        this.personas = personas;
    }

}
