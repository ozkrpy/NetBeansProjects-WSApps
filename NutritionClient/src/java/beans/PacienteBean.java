package beans;

import entities.Paciente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import utilities.PatientManager;

/**
 *
 * @author ozkrp
 */
@Named(value = "pacienteBean")
@SessionScoped
public class PacienteBean implements Serializable {

    int pacienteId;
    
    //variables de objetos
    private Paciente pacienteActual; //current
    PatientManager manager; //helper
    
    //variables de pagina
    private int indiceItemSeleccionado; //selectedItemIndex
    private int contadorRegistros; //recordCount
    private int tamanoPagina; //pageSize
    DataModel pacientes;
    
    public PacienteBean() {
        manager = new PatientManager();
        pacienteId = 1;
    }
    
    public PacienteBean(int pacienteIdentificador) {
        manager = new PatientManager();
        this.pacienteId = pacienteIdentificador;
        
    }
    
    public Paciente getSelected() {
        if (pacienteActual == null) {
            pacienteActual = new Paciente();
            indiceItemSeleccionado = -1;
        }
        return pacienteActual;
    }
    
    public DataModel getPacientes() {
        if (pacientes == null) {
            pacientes = new ListDataModel(manager.getPacientes());
        }
        return pacientes;
    }
    
    void recrearModelo(){
        pacientes = null;
    }
    
//    public boolean isHasNextPage() {
//        if (tamanoPagina <= contadorRegistros) {
//            return true;
//        }
//        return false;
//    }
    
//    public boolean isHasPreviousPage() {
//        if (pacienteId-tamanoPagina > 0) {
//            return true;
//        }
//        return false;
//    }
    
    //setea la pagina browse para la navegacion
    public String prepareView() {
        pacienteActual = (Paciente) getPacientes().getRowData();
        return "detallePaciente";
    }
    
    //setea la pagina de index para la carga
    public String prepareList() {
        //recrearModelo();
        return "pacientes";
    }
    
}
