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
    List<AlimentoBasico> nombreAlimentosPAVB();
    int agregarAlimentoDieta(int codigoDieta, int codigoAlimento, int cantidad, int codigoPaciente);
    List listadoDietas();
    List<Dieta> detalleDieta(int codigoDieta);
    void borrarAlimentoDieta(int codigoDieta, int codigoAlimento, int cantidad);
    void actualizarDieta(DietaPK dietaModificar, int nuevaCantidad);
}
