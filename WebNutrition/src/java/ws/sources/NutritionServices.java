/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.sources;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.sources.Beans;

/**
 *
 * @author ozkrp
 */
@WebService(serviceName = "NutritionServices")
public class NutritionServices {
    
    

    @WebMethod(operationName = "datosPaciente")
    public String datosPaciente(@WebParam(name = "nombrePaciente") String nombrePaciente, @WebParam(name = "edad") int edad, @WebParam(name = "sexo") String sexo
                              , @WebParam(name = "pesoActual") double pesoActual, @WebParam(name = "pesoHabitual") double pesoHabitual, @WebParam(name = "talla") double talla
                              , @WebParam(name = "circunferenciaMunheca") int circunferenciaMunheca, @WebParam(name = "circunferenciaCintura") double circunferenciaCintura
                              , @WebParam(name = "diagnosticoMedico") String diagnosticoMedico) {

        final String TAG = "datosPaciente";
        Beans.logger(TAG, "Invocacion al webservice y metodo datosPaciente");
        String biotipo = Beans.calculaBiotipo(edad, talla, circunferenciaMunheca, sexo);
        return "OK";
        
    }

    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "edad") int edad, @WebParam(name = "sexo") String sexo, @WebParam(name = "talla") double talla, @WebParam(name = "circunferenciaMunheca") int circunferenciaMunheca) {
        final String TAG = "operation";
        Beans.logger(TAG, "OPERATION datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + circunferenciaMunheca + " sexo: " + sexo);
        String biotipo = Beans.calculaBiotipo(edad, talla, circunferenciaMunheca, sexo);
        return biotipo;
    }
}
