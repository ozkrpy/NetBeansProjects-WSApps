/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.operations;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.operations.Beans;

/**
 *
 * @author ozkrp
 */
@WebService(serviceName = "Services")
public class Services {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarUsuario")
    public Respuesta validarUsuario(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario) {
        Respuesta respuesta = new Respuesta(0, "ER", "se inicializo correctamente en el WS");
        String metodo = "validarUsuario";
        Beans.escribeLogs(metodo, respuesta.getReferencia());
        if (datosUsuario == null) {
            Beans.escribeLogs(metodo, "Parametro de entrada es nulo");
            respuesta.setReferencia("Parametro de entrada es nulo");
        } else {
            String user = datosUsuario.getUser().toString().trim();
            String pass = datosUsuario.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                Beans.escribeLogs(metodo, "entro al if de datos nulos");
                respuesta.setReferencia("Datos del objeto son nulos");
            } else {
                Beans.escribeLogs(metodo, "entro al else datos no son nulos");
                if (Beans.validarLogin(user, pass)) {
                    Beans.escribeLogs(metodo, "entro al if de datos correctos");
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setReferencia("Usuario valido");
                } else {
                    Beans.escribeLogs(metodo, "entro al if de datos erroneos");
                    respuesta.setReferencia("Datos incorrectos.");
                }
            }    
        }
        return respuesta;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperaSolicitudesPendientes")
    public ArrayList<Solicitud> instanciaEntidades(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario) {
        ArrayList<Solicitud> resultado = new ArrayList<Solicitud>();
        Beans.escribeLogs("instanciaEntidades", "Inicio");
        String metodo = "recuperaListaParametroObjeto";
        Beans.escribeLogs(metodo, "invocado el metodo de recuperacion de listas");
        if (datosUsuario == null) {
            Beans.escribeLogs(metodo, "Parametro de entrada es nulo");
            return null;
        } else {
            String user = datosUsuario.getUser().toString().trim();
            String pass = datosUsuario.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                Beans.escribeLogs(metodo, "entro al if de datos nulos");
                return null;
            } else {
                Beans.escribeLogs(metodo, "entro al else datos no son nulos");
                if (Beans.validarLogin(user, pass)) {
                    Beans.escribeLogs(metodo, "entro al if de datos correctos");
                    
                    //lista = Beans.retornaListaSolicitudes();
                    try { 
                        EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
                        List<Object[]> listaRecuperada = instanciaSolicitudes.getSolicitudes(user);
                        if (listaRecuperada == null) {
                            Beans.escribeLogs("instanciaEntidades", "solicitudes retorno null");
                        } else {
                            for (Object[] a : listaRecuperada) {
                                System.out.println("Numero Solicitud: " + a[0] + " Descripcion: " + a[1]);
                                Solicitud solicitud = new Solicitud();
                                solicitud.setNumero_solicitud(a[0].toString());
                                solicitud.setDescripcion_solicitud(a[1].toString());
                                resultado.add(solicitud);
                            }
                            return resultado;
                        }
                    } catch (Exception e) {
                        Beans.escribeLogs("instanciaEntidades", "Fallo al instanciar solicitudes: " + e.getMessage());
                    }

        
                    //Item itemExtra = new Item(); itemExtra.setTitle("2333"); itemExtra.setDescription("SOLICITUD EXPLICITAMENTE PREPROCESADA"); lista.add(itemExtra);
                } else {
                    Beans.escribeLogs(metodo, "entro al if de datos erroneos");
                    return null;
                    
                }
            }    
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperaTarea")
    public Tarea recuperaTarea(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario, @WebParam(name = "numeroSolicitud") String numeroSolicitud) {
        Tarea tarea = null;
        Beans.escribeLogs("instanciaEntidades", "Inicio");
        String metodo = "recuperaListaParametroObjeto";
        Beans.escribeLogs(metodo, "invocado el metodo de recuperacion de listas");
        if (datosUsuario == null) {
            Beans.escribeLogs(metodo, "Parametro de entrada es nulo");
            return null;
        } else {
            String user = datosUsuario.getUser().toString().trim();
            String pass = datosUsuario.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                Beans.escribeLogs(metodo, "entro al if de datos nulos");
                return null;
            } else {
                Beans.escribeLogs(metodo, "entro al else datos no son nulos");
                if (Beans.validarLogin(user, pass)) {
                    Beans.escribeLogs(metodo, "entro al if de datos correctos");
                    
                    /* MIENTRAS TANTO */
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
                    
                    
                } else {
                    Beans.escribeLogs(metodo, "entro al if de datos erroneos");
                    return null;
                    
                }
            }    
        }
        return tarea;
    }
}
