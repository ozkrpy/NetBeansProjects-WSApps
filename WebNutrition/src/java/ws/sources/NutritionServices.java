/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.sources;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
    
        System.out.println("Invocacion al webservice y metodo datosPaciente");
        
        String biotipo = calculaBiotipo(edad, talla, circunferenciaMunheca, sexo);
        
        return "OK";
        
    }

    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "edad") int edad, @WebParam(name = "sexo") String sexo, @WebParam(name = "talla") double talla, @WebParam(name = "circunferenciaMunheca") int circunferenciaMunheca) {
        System.out.println("Invocacion al webservice y el metodo operation");
        logger("datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + circunferenciaMunheca + " sexo: " + sexo);
        
        String biotipo = calculaBiotipo(edad, talla, circunferenciaMunheca, sexo);
        return biotipo;
    }

    private String calculaBiotipo(int edad, double talla, int circunferenciaMunheca, String sexo) {
        String contextura = "Edad menor a 25 años";
        logger("datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + circunferenciaMunheca + " sexo: " + sexo);
        if (edad>=25) {
            logger("entro al if de mayor a 25");
            double biotipo;
            biotipo = (talla/circunferenciaMunheca);
            /*M: Masculino F: Femenino*/
            if (sexo.equals("M")) {
                logger("entro al if de Masculino");
                if (biotipo > 10.4) 
                    contextura = "Pequeña (Mayor a 10.4)";  
                else if (biotipo > 9.6 && biotipo <= 10.4) 
                    contextura = "Mediana (Entre 9.6 y 10.4)";
                else if (biotipo < 9.6) 
                    contextura = "Grande (Menor a 9.6)";
            } else if (sexo.equals("F")){ 
                logger("entro al if de Femenino");
                if (biotipo > 11) 
                    contextura = "Pequeña (Mayor a 11)";  
                else if (biotipo >= 10.1&& biotipo <= 11) 
                    contextura = "Mediana (Entre 10.1 y 11)";
                else if (biotipo < 10.1) 
                    contextura = "Grande (Menor a 10.1)";
            } else {
                logger("sexo no valido");
                return "Sexo ingresado no es valido";
            }
            
        }
        logger(contextura);
        return "Contextura " + contextura;
    }

    private void logger(String mensaje) {
        System.out.println("APPLOG " + mensaje);
    }
}
