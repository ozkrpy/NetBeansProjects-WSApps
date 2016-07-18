package ws.operations;

import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ws.operations.Beans;

@WebService(serviceName = "Services")
public class Services {

    private String user;
    private String pass;
    private String doingWhat;
            
    @WebMethod(operationName = "validarUsuario")
    public Respuesta validarUsuario(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario) {
        Respuesta respuesta = new Respuesta(0, "ER", "se inicializo correctamente en el WS");
        String metodo = "validarUsuario";
        Beans.escribeLogs(metodo, respuesta.getReferencia());
        if (validarDatosEntrada(datosUsuario)) {
            respuesta.setCodigo(1);
            respuesta.setMensaje("OK");
        }   
        respuesta.setReferencia(doingWhat);
        Beans.escribeLogs(metodo, "Validacion retorno: " + doingWhat);
        return respuesta;
    }
    
    @WebMethod(operationName = "recuperaSolicitudesPendientes")
    public ArrayList<Solicitud> instanciaEntidades(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario) {
        ArrayList<Solicitud> resultado = new ArrayList<Solicitud>();
        String metodo = "recuperaListaParametroObjeto";
        Beans.escribeLogs(metodo, "invocado el metodo de recuperacion de listas");
        if (validarDatosEntrada(datosUsuario)) {
            try { 
                EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
                List<Object[]> listaRecuperada = instanciaSolicitudes.getSolicitudes(user);
                if (listaRecuperada == null) {
                    Beans.escribeLogs("PersistenceLayerInvocation", "solicitudes retorno null");
                    return null;
                } else {
                    for (Object[] a : listaRecuperada) {
                        Beans.escribeLogs("PersistenceLayerInvocation", "Numero Solicitud: " + a[0] + " Descripcion: " + a[1]);
                        Solicitud solicitud = new Solicitud();
                        solicitud.setNumero_solicitud(a[0].toString());
                        solicitud.setDescripcion_solicitud(a[1].toString());
                        resultado.add(solicitud);
                    }
                    return resultado;
                }
            } catch (Exception e) {
                Beans.escribeLogs("PersistenceLayerInvocation", "Fallo al instanciar solicitudes: " + e.getMessage());
            }
        } else {
            Beans.escribeLogs(metodo, "Validacion retorno: " + doingWhat);
            return null;
        }
        return resultado;
    }

    @WebMethod(operationName = "recuperaTarea")
    public Tarea recuperaTarea(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario, @WebParam(name = "numeroSolicitud") String numeroSolicitud) {
        Tarea tarea = new Tarea();
        String metodo = "recuperaTarea";
        Beans.escribeLogs(metodo, "Inicio la recuperacion de tareas.");
        if (validarDatosEntrada(datosUsuario)) {
            if (numeroSolicitud != null) {
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
                Beans.escribeLogs(metodo, "Validacion solicitud retorno: numeroSolicitud nula");
                return null;
            }
        } else {
            Beans.escribeLogs(metodo, "Validacion usuario retorno: " + doingWhat);
            return null;
        }
        return null;
    }

    @WebMethod(operationName = "actualizaEstadoSolicitud")
    public Respuesta actualizaEstadoSolicitud(@WebParam(name = "datosUsuario") DatosUsuario datosUsuario, @WebParam(name = "numeroSolicitud") String numeroSolicitud, @WebParam(name = "estadoAprobacion") String estadoAprobacion) {
        Respuesta respuesta = new Respuesta(0, "ER", "Sin modificacion en el WS.");
        String metodo = "actualizaEstadoSolicitud";
        String usuarioNuevo = "";
        Beans.escribeLogs(metodo, respuesta.getReferencia());
        if (validarDatosEntrada(datosUsuario)) {
            if (numeroSolicitud != null && estadoAprobacion != null) {
                Beans.escribeLogs(metodo, "entro al if de datos correctos");
                EntitiesInstance instanciaSolicitudes = new EntitiesInstance();
                Respuesta objetoRecuperado = new Respuesta(0, "ER", "Instancia inicial");
                if (user.equals("oscar")) {
                    usuarioNuevo = "osvaldo";
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
                Beans.escribeLogs(metodo, "Datos ingresados son nulos.");
                respuesta.setReferencia("Datos ingresados son nulos.");
            }
        } else {
            Beans.escribeLogs(metodo, doingWhat);
            respuesta.setReferencia(doingWhat);
        }
        return respuesta;
    }

    private boolean validarDatosEntrada (DatosUsuario userData) {
        doingWhat = "Inicio verificacion de los datos";
        if (userData == null) {
            doingWhat = "Parametro de entrada es nulo";
            return false;
        } else {
            doingWhat = "Parametro no es nulo";
            user = userData.getUser().toString().trim();
            pass = userData.getPass().toString().trim();
            if ((user == null) || (pass == null) || (user.length() == 0) || (pass.length() == 0)) {
                doingWhat = "Objeto contenia informacion incompleta";
                return false;
            } else {
                doingWhat = "Se cargaron correctamente los datos de usuario y contrasenha";
                if (Beans.validarLogin(user, pass)) {
                    doingWhat = "Usuario / contrasenha validos";
                    return true;
                } else {
                    doingWhat = "Usuario / contrasenha no fueron validados";
                    return false;
                }
            }
        }
    }
}
