/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.servicios;

/**
 *
 * @author ozkrp
 */
public class Beans {

    public Beans() {
    }
    
    public void escribeLogs(String modulo, String mensaje) {
        System.out.println(modulo + "_LOG: " + mensaje);
    }
    
}
