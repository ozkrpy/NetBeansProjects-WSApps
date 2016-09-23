/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerBeans;

import entities.AlimentoBasico;
import entities.Alimentos;
import entities.Dieta;
import entities.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ozkrp
 */
@Local
public interface ManagerBeanLocal {
    
    List<Paciente> listadoPacientes(); 
    List<Alimentos> listadoAlimentos(); 
    Alimentos detalleAlimento(int codigo);
    List<AlimentoBasico> nombreAlimentos();
    int agregarAlimentoDieta(int codigoDieta, int codigoAlimento, int cantidad, int codigoPaciente);
    List listadoDietas();
    List<Dieta> detalleDieta(int codigoDieta);
}
