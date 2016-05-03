/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.operations;

import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
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
        Tarea tarea = new Tarea();
        Beans.escribeLogs("instanciaEntidades", "Inicio");
        String metodo = "recuperaTarea";
        Beans.escribeLogs(metodo, "invocado el metodo de recuperacion de tareas");
        if (datosUsuario == null || numeroSolicitud == null) {
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
                    
                    EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
                    List<Object[]> objetoRecuperado = instanciaSolicitudes.getTarea(numeroSolicitud);
                    Beans.escribeLogs(metodo, "termino la ejecucion de instanciacion de entidad");
                    if (objetoRecuperado == null) {
                        Beans.escribeLogs(metodo, "tarea retorno null");
                    } else {
                        Beans.escribeLogs(metodo, "la tarea recuperada no es nula");
                        for (Object[] a : objetoRecuperado) {
                            tarea.setPersonaCodigo(a[0].toString());
                            tarea.setPersonaNombre(a[1].toString());
                            tarea.setSolicitudFechaInicio(a[2].toString());
                            tarea.setSolicitudReferencia(a[3].toString());
                            tarea.setSolicitudTipoCodigo(a[4].toString());
                            tarea.setSolicitudTipoDescripcion(a[5].toString());
                            tarea.setTareaNumero(a[6].toString());
                            tarea.setTareaTipoCodigo(a[7].toString());
                            tarea.setTareaTipoDescripcion(a[8].toString());
                            tarea.setTareaEstado(a[9].toString());
                            tarea.setTareaFechaAsignacion(a[10].toString());
                            tarea.setTareaAsignadorCodigo(a[11].toString());
                            tarea.setTareaAsignadorNombre(a[12].toString());
                            tarea.setTareaDescripcion(a[13].toString());
                            tarea.setTareaComentarioRecibido("");
                            tarea.setTareaComentarioAdicional("");
                        }
                        Beans.escribeLogs("imprimeTarea", "recuperoTarea: " + tarea.getPersonaCodigo().toString());
                        return tarea;
                    }
                } else {
                    Beans.escribeLogs(metodo, "entro al if de datos erroneos");
                    return null;
                    
                }
            }    
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizaEstadoSolicitud")
    public Respuesta actualizaEstadoSolicitud(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario, @WebParam(name = "numeroSolicitud") String numeroSolicitud, @WebParam(name = "estadoAprobacion") String estadoAprobacion) {
        Respuesta respuesta = new Respuesta(0, "ER", "se inicializo correctamente en el WS");
        String metodo = "actualizaEstadoSolicitud";
        String usuarioNuevo = "";
        Beans.escribeLogs(metodo, respuesta.getReferencia());
        if (datosUsuario == null || numeroSolicitud == null || estadoAprobacion == null) {
            Beans.escribeLogs(metodo, "Parametro de entrada es nulo");
            respuesta.setReferencia("Parametro de entrada es nulo");
        } else {
            String user = datosUsuario.getUser().toString().trim();
            String pass = datosUsuario.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                Beans.escribeLogs(metodo, "entro al if de datos nulos");
                respuesta.setReferencia("Datos del usuario son nulos");
            } else {
                Beans.escribeLogs(metodo, "entro al else datos no son nulos");
                if (Beans.validarLogin(user, pass)) {
                    Beans.escribeLogs(metodo, "entro al if de datos correctos");
                    EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
                    Respuesta objetoRecuperado = new Respuesta(0, "ER", "Instancia inicial");
                    if (user.equals("oscar")) {
                        usuarioNuevo = "vero";
                    } else {
                        usuarioNuevo = "oscar";
                    }
                    objetoRecuperado = instanciaSolicitudes.updateSolicitud(numeroSolicitud,estadoAprobacion,usuarioNuevo);
                    if (objetoRecuperado == null) {
                        Beans.escribeLogs("instanciaEntidades", "solicitudes retorno null");
                        respuesta.setReferencia("Se produjo un error al actualizar la solicitud");
                    } else {
                        Beans.escribeLogs("retorno", "estado: " + objetoRecuperado.getMensaje());
                        respuesta.setCodigo(objetoRecuperado.getCodigo());
                        respuesta.setMensaje(objetoRecuperado.getMensaje());
                        respuesta.setReferencia(objetoRecuperado.getReferencia());
                    }            
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
    @WebMethod(operationName = "dummy")
    public Respuesta dummy() {
        Respuesta objetoRecuperado = new Respuesta(0, "ER", "Instancia inicial");
        EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
        objetoRecuperado = instanciaSolicitudes.updateSolicitud("2305","UP","upd");
        if (objetoRecuperado == null) {
            Beans.escribeLogs("instanciaEntidades", "solicitudes retorno null");
        } else {
            Beans.escribeLogs("retorno", "estado: " + objetoRecuperado.getMensaje());            
        }            
        return objetoRecuperado;
    }
}
