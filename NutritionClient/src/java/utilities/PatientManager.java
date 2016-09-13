/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Paciente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ozkrp
 */
public class PatientManager {

    Session session = null;

    public PatientManager() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getPacientes() {
        List<Paciente> pacientes = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Paciente");
            pacientes = (List<Paciente>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return pacientes;
    }

    public Paciente getPacientePorID(int pacienteId) {

        Paciente paciente = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Paciente as paciente where paciente.idpaciente = " + pacienteId);
            paciente = (Paciente) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paciente;
    }

}
