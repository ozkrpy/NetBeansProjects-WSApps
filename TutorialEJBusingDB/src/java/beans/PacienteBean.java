/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Paciente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;

@Named(value = "pacienteaBean")
@ApplicationScoped
public class PacienteBean {

    private List<Paciente> pacientes;
    //se debe instanciar la interfaz no directamente el bean de entidad
    @EJB
    private PacienteManagementBeanLocal pacienteManagementBeanLocal;
    private Paciente pacienteSeleccionado;
    
    public PacienteBean() {
    }
    
    @PostConstruct
    public void init () {
        System.out.println("instanciar el elemento pacienteBean.");
        pacientes = pacienteManagementBeanLocal.getAllPacientes();
        System.out.println("se termino de instanciar el elemento pacienteBean.");
    }
    
    public List<Paciente> getPacientes() {
        System.out.println("instanciar getPacientes");
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        System.out.println("instanciar setPacientes");
        this.pacientes = pacientes;
    }    
    
    public String borrarPaciente(int idPaciente) {
        System.out.println("instanciar el elemento borrarPaciente: " + idPaciente);
        pacienteManagementBeanLocal.deletePaciente(idPaciente);
        pacientes = pacienteManagementBeanLocal.getAllPacientes();
        return null;
    }

    public Paciente getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }
    
    public void seleccionaPaciente(Paciente p) {
        System.out.println("instanciar el elemento seleccionaPaciente: " + p.getNombre());
        pacienteSeleccionado = p;
    }
    
    public String actualizaPaciente() {
        System.out.println("instanciar el elemento borrarPaciente: " + pacienteSeleccionado.getNombre());
        pacienteManagementBeanLocal.updatePaciente(pacienteSeleccionado);
        pacienteSeleccionado = null;
        return null;
    }
}
