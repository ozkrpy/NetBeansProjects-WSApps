/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.operations;

/**
 *
 * @author ozkrp
 */
public class Beans {

    public static void escribeLogs(String modulo, String mensaje) {
        System.out.println(modulo + "_LOG: " + mensaje);
    }
    
    public static boolean validarLogin(String usuario, String password) {
        if ((usuario.equals("oscar") && password.equals("oscar")) || (usuario.equals("osvaldo") && password.equals("osvaldo"))) {
            return true;
        }
        return false;
    }
}
