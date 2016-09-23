/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBeans;

import entities.AlimentoBasico;
import entities.Alimentos;
import entities.Dieta;
import entities.DietaPK;
import entities.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ManagerBean implements ManagerBeanLocal {

    @PersistenceContext(unitName = "com.mycompany_Nutricion_war_1.0-SNAPSHOTPU")
    EntityManager em;

    @Override
    public List<Paciente> listadoPacientes() {
        List<Paciente> listado = em.createNamedQuery("Paciente.findAll", Paciente.class).getResultList();
        return listado;
    }

    @Override
    public List<Alimentos> listadoAlimentos() {
        List<Alimentos> listado = em.createNamedQuery("Alimentos.findAll", Alimentos.class).getResultList();
        return listado;
    }

    @Override
    public Alimentos detalleAlimento(int codigo) {
        //Alimentos detalle = em.createNamedQuery("Alimentos.findByCodigoAlimento", Alimentos.class).setParameter("codigoAlimento", codigo).getFirstResult();
        Alimentos detalle = em.find(Alimentos.class, codigo);
        System.out.println(ManagerBean.class.getSimpleName() + " detalleAlimento() recupero: " + detalle.getCodigoAlimento());
        return detalle;
    }

    @Override
    public List<AlimentoBasico> nombreAlimentos() {
        List<Alimentos> alimentosNombre = em.createNamedQuery("Alimentos.findAll", Alimentos.class).getResultList();
        List<AlimentoBasico> listadoNombreAlimento = new ArrayList<AlimentoBasico>();
        for (int i = 0; i < alimentosNombre.size(); i++) {
            listadoNombreAlimento.add(new AlimentoBasico(alimentosNombre.get(i).getCodigoAlimento(), alimentosNombre.get(i).getDescripcionAlimento()));
        }
        return listadoNombreAlimento;
    }

    @Override
    public int agregarAlimentoDieta(int codigoDieta, int codigoAlimento, int cantidad, int codigoPaciente) {

        try {
            Paciente paciente = em.find(Paciente.class, codigoPaciente);
            if (codigoDieta == 0) {
                int codigoDietaTemp = Integer.valueOf(em.createNamedQuery("Dieta.maxCodigoDieta").getSingleResult().toString());
                System.out.println(ManagerBean.class.getSimpleName() + " recupero como MAX codigo dieta: " + codigoDietaTemp);
                codigoDieta = codigoDietaTemp + 1;
                System.out.println(ManagerBean.class.getSimpleName() + " el codigo de la dieta es CERO, y se reseteo a " + codigoDieta);
            }
            
            System.out.println(ManagerBean.class.getSimpleName() + " invoco agregarAlimentoDieta con los parametros - alimento: " + codigoAlimento + ", cantidad: " + cantidad + ", paciente: " + codigoPaciente + ", codigoDieta: " + codigoDieta);
            
            DietaPK dietaPk = new DietaPK();
            dietaPk.setCodigoDieta(codigoDieta);
            dietaPk.setCantidadAlimento(cantidad);
            dietaPk.setCodigoAlimento(codigoAlimento);
            
            Dieta dieta = new Dieta();
            dieta.setDietaPK(dietaPk);
            dieta.setCodigoPaciente(paciente);
            
            em.persist(dieta);
            
            System.out.println(ManagerBean.class.getSimpleName() + " datos persistidos: " + dieta.toString());
            
        } catch (Exception e) {
            throw new UnsupportedOperationException("No se pudo insertar Dieta.");
        }
        
        return codigoDieta;
    }

    @Override
    public List listadoDietas() {
        List recuperaDietas = em.createNamedQuery("Dieta.findAllCodigoDieta").getResultList();
        System.out.println(ManagerBean.class.getSimpleName() + " listadoDietas() recupero dietas: " + recuperaDietas.toString());
        return recuperaDietas;
    }

    @Override
    public List<Dieta> detalleDieta(int codigoDieta) {
        List<Dieta> listadoDietas = em.createNamedQuery("Dieta.findByCodigoDieta", Dieta.class).setParameter("codigoDieta", codigoDieta).getResultList();
        System.out.println(ManagerBean.class.getSimpleName() + " detalleDieta() recupero dietas: " + listadoDietas.toString());
        return listadoDietas;
    }

}
