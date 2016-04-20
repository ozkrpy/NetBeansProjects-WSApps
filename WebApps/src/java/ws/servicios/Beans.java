/*
 * Author: Oscar Ruffinelli
 * Date created: 18/02/2016
 * Modified: Oscar Ruffinelli 28/03/2016 
 *
 */
package ws.servicios;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oscar Ruffinelli
 * @version 1.0
 *
 */
public class Beans {

    /**
     *
     * @param modulo debe recibir el nombre del modulo desde donde se invoca.
     * @param mensaje mensaje que registrar.
     *
     * Metodo de impresion para registrar datos al log del servidor.
     */
    public static ArrayList<Item> retornaListaSolicitudes() {
        escribeLogs("Beans", "Entro al modulo de Beans, retorna solicitudes");
        ArrayList<Item> lista = new ArrayList<Item>();

        Item item1 = new Item();
        item1.setTitle("2386");
        item1.setDescription("CREDITOS HASTA 5.000.000");
        Item item2 = new Item();
        item2.setTitle("2340");
        item2.setDescription("CREDITOS HASTA 15.000.000");
        Item item3 = new Item();
        item3.setTitle("2305");
        item3.setDescription("SOLICITUD DE TARJETA");

        lista.add(item1);
        lista.add(item2);
        lista.add(item3);

        escribeLogs("Beans", "cargo la lista para retornar");
        return lista;
    }

    public static void escribeLogs(String modulo, String mensaje) {
        System.out.println(modulo + "_LOG: " + mensaje);
    }

    public static boolean validarLogin(String usuario, String password) {
        if (usuario.equals("oscar") && password.equals("oscar")) {
            return true;
        }
        return false;
    }

    public static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        escribeLogs("Beans", "entro al metodo: getEntityManager");
        if (emf == null) {
            escribeLogs("Beans", "if emf es nulo");
            emf = Persistence.createEntityManagerFactory("WebAppsPU");
        }
        return emf.createEntityManager();
    }

    public static Item[] getUsers() {
        escribeLogs("Beans", "entro al metodo: getusers");
        EntityManager em = getEntityManager();
        escribeLogs("Beans", "invoco al getEntityManager");

        try {
            javax.persistence.Query q = em.createQuery("select c from solicitudes as c");
            escribeLogs("Beans", "ejecuto el query de retorno de solicitudes");
            return (Item[]) q.getResultList().toArray(new Item[0]);
        } catch (Exception ex) {
            escribeLogs("Beans", "Error: " + ex.getMessage());

        } finally {
            em.close();
        }
        return null;
    }
}
