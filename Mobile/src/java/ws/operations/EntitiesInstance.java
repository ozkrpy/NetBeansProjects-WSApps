package ws.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ws.entities.Solicitudes;
import ws.operations.Beans;

/**
 *
 * @author ozkrp
 */
public class EntitiesInstance {

    public EntityManagerFactory emf;
    private final String TAG = "EntitiesInstance";

    public EntityManager getEntityManager() {
        Beans.escribeLogs(TAG, "entro al metodo: getEntityManager");
        if (emf == null) {
            Beans.escribeLogs(TAG, "if emf es nulo");
            try { 
                emf = Persistence.createEntityManagerFactory("MobilePU");
            } catch (Exception e) {
                Beans.escribeLogs(TAG, "Exception entityManagerFactory: " + e.getMessage());
            }
        }
        return emf.createEntityManager();
    }

    public List<Object[]> getSolicitudes(String user) {
        Beans.escribeLogs(TAG, "entro al metodo: getSolicitudes");
        EntityManager em = getEntityManager();
        Beans.escribeLogs(TAG, "invoco al getEntityManager");

        try {
            Query query = em.createNativeQuery("SELECT s.numero_solicitud, s.descripcion_solicitud FROM Solicitudes s WHERE s.estado_solicitud = 'PE' AND s.usuario = '" + user + "'");
            List<Object[]> resultadoNamedQuery = query.setParameter("usuario", user).getResultList();
            Beans.escribeLogs(TAG, "ejecuto el named query solicitudes");
            return resultadoNamedQuery;
        } catch (EntityNotFoundException entityEx) {
            Beans.escribeLogs(TAG, "Entitty Exception: " + entityEx.toString());
        } catch (Exception ex) {
            Beans.escribeLogs(TAG, "Exception: " + ex.toString());
        } finally {
            em.close();
        }
        return null;
    }
    
    public List<Object[]> getTarea(String numeroSolicitud) {
        Beans.escribeLogs(TAG, "entro al metodo: getTarea para la solicitud: " + numeroSolicitud);
        EntityManager em = getEntityManager();
        Beans.escribeLogs(TAG, "ejecute el getEntityManager");

        try {
            Query query = em.createNamedQuery("Tareas.findBySolicitudNumeroTarea");
            query.setParameter("solicitudNumero", numeroSolicitud);
            List<Object[]> resultadoNamedQuery = query.getResultList();
     
            Beans.escribeLogs(TAG, "ejecuto el named query solicitudes, recupero:" + resultadoNamedQuery.toString());
            return resultadoNamedQuery;
        } catch (Exception ex) {
            Beans.escribeLogs(TAG, "Exception: " + ex.toString());
        } finally {
            em.close();
        }
        return null;
    }
    
    public Respuesta updateSolicitud(String numeroSolicitud, String nuevoEstado, String usuarioNuevo) {
        Beans.escribeLogs(TAG, "entro al metodo: updateSolicitud para la solicitud: " + numeroSolicitud);
        Respuesta respuesta = new Respuesta(0, "ER", "Inicializado en entidades");
        EntityManager em = getEntityManager();
        Beans.escribeLogs(TAG, "ejecute el getEntityManager");
        
        em.getTransaction().begin();
        String queryTexto = "UPDATE Solicitudes s SET s.usuario = '" + usuarioNuevo + "', s.estadoSolicitud = '" + nuevoEstado + "' WHERE s.numeroSolicitud = '" + numeroSolicitud + "'";
        Beans.escribeLogs(TAG, "QUERY: " + queryTexto);
        try {
            Query query = em.createQuery("UPDATE Solicitudes s SET s.usuario = '" + usuarioNuevo + "', s.estadoSolicitud = '" + nuevoEstado + "' WHERE s.numeroSolicitud = '" + numeroSolicitud + "'");
            int updatedCount = query.executeUpdate();
            if (updatedCount > 0) {
                Beans.escribeLogs(TAG, "se actualizaron registros");
                respuesta.setCodigo(1);
                respuesta.setMensaje("OK");
                respuesta.setReferencia("Se actualizo correctamente al usuario: " + usuarioNuevo);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            Beans.escribeLogs("Excepcion", "Error: " + e.getMessage());
        } finally {
            em.close();
        }
        return respuesta;
    }
}
