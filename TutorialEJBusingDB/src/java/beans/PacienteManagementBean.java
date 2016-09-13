/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import entities.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ozkrp
 */
@Stateless
public class PacienteManagementBean implements PacienteManagementBeanLocal {

    @PersistenceContext(unitName = "TutorialEJBusingDBPU")
    private EntityManager em;
    
    @Override
    public List<Paciente> getAllPacientes() {
        System.out.println("instanciar getAllPacientes en el Managementbean.");
        return em.createNamedQuery("Paciente.findAll", Paciente.class).getResultList();
    }

    @Override
    public void deletePaciente(int idPaciente) {
        System.out.println("instanciar el elemento deletePaciente: " + idPaciente);
        try { 
            Paciente paciente = em.find(Paciente.class, idPaciente);
            System.out.println("retrieve paciente en borrarPaciente: " + paciente.toString());
            if (paciente != null)
                System.out.println("paciente en borrarPaciente es distinto a nulo, intentara borrar ");
                em.remove(paciente);
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }

    @Override
    public void updatePaciente(Paciente paciente) {
        System.out.println("instanciar el elemento updatePaciente: " + paciente.getNombre());
        try {
            em.merge(paciente);
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }
    
    

}
