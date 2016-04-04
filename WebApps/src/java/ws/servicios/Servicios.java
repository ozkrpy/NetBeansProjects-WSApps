/**
 * Aplicacion Web encargada de efectuar las transacciones directamente con la base de datos.
 * 
 * Author: Oscar Ruffinelli
 * Date created: 18/02/2016
 * Modified: Oscar Ruffinelli 28/03/2016  
 *
 */
package ws.servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.servicios.Beans;

/**
 *
 * @author Oscar Ruffinelli
 * @version 1.1
 * 
 */
@WebService(serviceName = "Servicios")
public class Servicios {
    Beans bean;
    /**
     * Metodo:
     * - Registro de login (Validacion usuario/contraseña)
     *   . Metodo que recibe como parametros los datos del usuario (login/pass) y debe validarlos contra la DB.
     *   . Retorna un objeto respuesta (Codigo, mensaje, referencia) que indique si es un usuario valido.
     *   . La carga de solicitudes pendientes en la vista se realizara en base al usuario y su rol definido.
     * Pendiente de desarrollo conector a la DB, validacion de roles.
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
     * Metodo:
     * - Recuperar listado de Solicitudes pendientes por usuario.
     *   . Metodo invocado directamente despues de la validacion del login, y que debe retornar una lista de Solicitudes pendientes.
     *   . Recibe como parametros usuario y contraseña del usuario logueado en la aplicacion.
     *   . Retorna una lista de String con el codigo de la solicitud.
     * Pendiente de desarrollo:
     * . El conector a la DB que consulte y recupere las solicitudes pendientes.
     * . Que el retorno sea una lista de objetos, conteniendo los datos (Numero de Solicitud, y descripcion de la solicitud).
     */
    @WebMethod(operationName = "recuperaLista")
    public String[] recuperaLista(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        String[] solicitudes;
        if (user.equals("oscar") && (pass.equals("oscar"))) {
            bean.escribeLogs("recuperaLista", "recibio los parametros, user: " + user + " pass: " + pass);
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
     * Metodo:
     * - Recuperar detalle de tarea vigente asociada a la solicitud 
     *   . Crea y retorna un objeto tarea con los datos relacionados al numero de solicitud que se recibio como parametro.
     *   . Recibe como parametros los datos de user/pass, y numero de la solicitud en cuestion.
     *   . Retorna un objeto Tarea con todos los datos de la solicitud.
     * Pendiente de desarrollo:
     * . Conector a la DB
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

    /**
     * Metodo:
     * - Gestionar siguiente estado de la tarea
     * . De acuerdo a la seleccion que haya realizado el usuario se debera invocar al procedimiento almacenado encargado de: 
     *   . Aprobar
     *   . Rechazar
     *   . Anular
     * . Recibe como parametros el user/pass, numero de solicitud, estado seleccionado desde la aplicacion (Aprobar, Rechazar, Cancelar), comentario de la evaluacion.
     * . Retorna un objeto respuesta (Codigo, mensaje, referencia) que indique si la operacion en la DB fue exitosa.
     * Pendiente de desarrollo:
     * . Implementacion del conector y la invocacion a los metodos de acuerdo al parametro de entrada.
     */
    @WebMethod(operationName = "invocaSiguienteEstado")
    public Respuesta invocaSiguienteEstado(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "numeroSolicitud") String numeroSolicitud, @WebParam(name = "estadoEvaluacion") String estadoEvaluacion, @WebParam(name = "comentarioAprobacion") String comentarioAprobacion) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarUsuarioParametroObjeto")
    public Respuesta validarUsuarioParametroObjeto(@WebParam(name = "datosUser") DatosUsuario datosUser) {
        Respuesta respuesta = new Respuesta(0, "ER", "se inicializo correctamente en el WS");
        String metodo = "validarUsuarioParametroObjeto";
        Beans.escribeLogs(metodo, respuesta.getReferencia());
        if (datosUser == null) {
            Beans.escribeLogs(metodo, "Parametro de entrada es nulo");
            respuesta.setReferencia("Parametro de entrada es nulo");
        } else {
            String user = datosUser.getUser().toString().trim();
            String pass = datosUser.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                Beans.escribeLogs(metodo, "entro al if de datos nulos");
                respuesta.setReferencia("Datos del objeto son nulos");
            } else {
                Beans.escribeLogs(metodo, "entro al else datos no son nulos");
                if (user.equals("oscar") && pass.equals("oscar")) {
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
    
}
