/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.servicios.Beans;

/**
 *
 * @author ozkrpy
 */
@WebService(serviceName = "Servicios")
public class Servicios {
    Beans bean = new Beans();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarUsuarios")
    public String validarUsuarios(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        if (user.equals("oscar") && (pass.equals("oscar"))) {
            return "OK";
        }
        return "ER";  
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validaUsuarioObjeto")
    public Respuesta validaUsuarioObjeto(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        bean.escribeLogs("validaUsuarioObjeto", "invocado el servicio");
        bean.escribeLogs("validaUsuarioObjeto", "user: " + user + " - pass: " + pass);
        Respuesta respuesta = new Respuesta(0, "ER", "se inicializo correctamente en el WS");
        if (user.equals("oscar") && (pass.equals("oscar"))) {
            bean.escribeLogs("validaUsuarioObjeto", "usuario valido");
            respuesta.setCodigo(1);
            respuesta.setMensaje("OK");
            respuesta.setReferencia("Usuario validado en el WS");
        } else {
            bean.escribeLogs("validaUsuarioObjeto", "usuario no valido");
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperaLista")
    public String[] recuperaLista(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        String[] solicitudes;
        if (user.equals("oscar") && (pass.equals("oscar"))) {
            solicitudes = new String[] {
                "2386",
                "2340",
                "2333",
                "2305"
            };
        } else { 
            solicitudes = new String[] {
                "VACIO"
            };
        }
        return solicitudes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperaTareas")
    public Tarea recuperaTareas(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "numeroSolicitud") String numeroSolicitud) {
        Tarea tarea = null;
        if (user.equals("oscar") && (pass.equals("oscar"))) {
            if (numeroSolicitud.equals("2386")) {
                tarea = new Tarea ("12940","DARIO RAMON BOBADILLA COLMAN","18/06/2012 11:19","18473","83","CREDITOS HASTA 5.000.000",
                "8","7","DESEMBOLSO","Pendiente","28/06/2012 11:54","CBARRIOS","CYNTHIA BARRIOS","DESEMBOLSO","","");
            } else if (numeroSolicitud.equals("2340")) {
                tarea = new Tarea ("154047","MARIA DANIELA RIVERO DANIEL","15/06/2012 12:35","18339","8","CREDITOS HASTA 15.000.000",
                "1","27","APERTURA","Pendiente","8/01/2012 11:54","MEZAA","AGUSTIN MEZA","APERTURA","","");                
            } else if (numeroSolicitud.equals("2305")) {
                tarea = new Tarea ("140589","ARTURO FABIAN AYALA FARINHA","1/07/2012 10:19","18235","3","SOLICITUD DE TARJETA",
                "5","2","SOLICITUD","Pendiente","2/06/2012 11:54","VERAV","VERONICA VERA","SOLICITUD","","");                
            }
        }
        return tarea;
    }
    
    
    
}
