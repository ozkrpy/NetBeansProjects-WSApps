/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ManagerBeans.ManagerBeanLocal;
import entities.Paciente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ozkrp
 */
@Named(value = "pacienteBean")
@RequestScoped
public class PacienteBean {
    
    private List<Paciente> listaPacientes;
    
    @EJB
    private ManagerBeanLocal manager;

    /**
     * Creates a new instance of PacienteBean
     */
    public PacienteBean() {
    }

    @PostConstruct
    public void init() {
        listaPacientes = manager.listadoPacientes();
    }
    
    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    
}
