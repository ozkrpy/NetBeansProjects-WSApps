/*
 * Author: Oscar Ruffinelli
 * Date created: 04/04/2016
 * Modified: Oscar Ruffinelli 04/04/2016 
 *
 */
package ws.operations;

import java.util.Date;

/**
 *
 * @author Oscar Ruffinelli
 * @version 1.0
 * 
 */
public class DatosUsuario {
    private String user;
    private String pass;
    private String fecha;

    public DatosUsuario() {
    }

    public DatosUsuario(String user, String pass, String fecha) {
        this.user = user;
        this.pass = pass;
        this.fecha = fecha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
