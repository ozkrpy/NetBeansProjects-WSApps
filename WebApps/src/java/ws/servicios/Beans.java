/*
 * Author: Oscar Ruffinelli
 * Date created: 18/02/2016
 * Modified: Oscar Ruffinelli 28/03/2016 
 *
 */
package ws.servicios;

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
    public static void escribeLogs(String modulo, String mensaje) {
        System.out.println(modulo + "_LOG: " + mensaje);
    }
    
}
