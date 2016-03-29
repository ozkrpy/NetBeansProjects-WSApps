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
 * retorna la respuesta para su manejo en la aplicacion.
 */
public class Respuesta {

    private int codigo;
    private String mensaje;
    private String referencia;

    public Respuesta(int codigo, String mensaje, String referencia) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.referencia = referencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    
    
}
