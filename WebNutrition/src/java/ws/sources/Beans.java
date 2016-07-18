/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.sources;

/**
 *
 * @author ozkrp
 */
public class Beans {
    
    private static final String TAG = "BEANS";
    
    public static String calculaBiotipo(int edad, double talla, int circunferenciaMunheca, String sexo) {
        String contextura = "Edad menor a 25 años";
        logger(TAG, "datos entrada - edad: " + edad + " talla: " + talla + " cia. munheca: " + circunferenciaMunheca + " sexo: " + sexo);
        if (edad>=25) {
            logger(TAG, "entro al if de mayor a 25");
            double biotipo;
            biotipo = (talla/circunferenciaMunheca);
            /*M: Masculino F: Femenino*/
            if (sexo.equals("M")) {
                logger(TAG, "entro al if de Masculino");
                if (biotipo > 10.4) 
                    contextura = "Pequeña (Mayor a 10.4)";  
                else if (biotipo > 9.6 && biotipo <= 10.4) 
                    contextura = "Mediana (Entre 9.6 y 10.4)";
                else if (biotipo < 9.6) 
                    contextura = "Grande (Menor a 9.6)";
            } else if (sexo.equals("F")){ 
                logger(TAG, "entro al if de Femenino");
                if (biotipo > 11) 
                    contextura = "Pequeña (Mayor a 11)";  
                else if (biotipo >= 10.1&& biotipo <= 11) 
                    contextura = "Mediana (Entre 10.1 y 11)";
                else if (biotipo < 10.1) 
                    contextura = "Grande (Menor a 10.1)";
            } else {
                logger(TAG, "sexo no valido");
                return "Sexo ingresado no es valido";
            }
            
        }
        logger(TAG, contextura);
        return "Contextura " + contextura;
    }
    
    public static double calculaPesoIdeal (int edad, int talla) {
        double pesoIdeal = 0.0;
            
        
        
        
        return pesoIdeal;
    }
    
    public static void logger(String entorno, String mensaje) {
        System.out.println(entorno + " " + mensaje);
    }
    
}
