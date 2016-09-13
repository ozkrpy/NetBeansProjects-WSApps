package beans;

import entities.Alimentos;
import entities.Paciente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import utilities.FoodManager;
import utilities.PatientManager;

/**
 *
 * @author ozkrp
 */
@Named(value = "alimentoBean")
@SessionScoped
public class AlimentosBean implements Serializable {

    int codigoAlimento;
    
    //variables de objetos
    private Alimentos alimentoActual; //current
    FoodManager manager; //helper
    
    //variables de pagina
    private int indiceItemSeleccionado; //selectedItemIndex
    private int contadorRegistros; //recordCount
    private int tamanoPagina; //pageSize
    DataModel alimentos;
    
    public AlimentosBean() {
        manager = new FoodManager();
        codigoAlimento = 1;
    }
    
    public AlimentosBean(int alimentoId) {
        manager = new FoodManager();
        this.codigoAlimento = alimentoId;
        
    }
    
    public Alimentos getSelected() {
        if (alimentoActual == null) {
            alimentoActual = new Alimentos();
            indiceItemSeleccionado = -1;
        }
        return alimentoActual;
    }
    
    public DataModel getAlimentos() {
        if (alimentos == null) {
            alimentos = new ListDataModel(manager.getFood());
        }
        return alimentos;
    }
    
    void recrearModelo(){
        alimentos = null;
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
        alimentoActual = (Alimentos) getAlimentos().getRowData();
        System.out.println("CLASE: " + AlimentosBean.class.getSimpleName() + " Recupero medida real: " + alimentoActual.getMedidaRealUnidad());
        return "detalleAlimentos";
    }
    
    //setea la pagina de index para la carga
    public String prepareList() {
        //recrearModelo();
        return "alimentos";
    }
    
}
