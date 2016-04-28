package ws.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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
            Query query = em.createNativeQuery("SELECT s.numero_solicitud, s.descripcion_solicitud FROM Solicitudes s WHERE s.usuario = '" + user + "'");
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
}
