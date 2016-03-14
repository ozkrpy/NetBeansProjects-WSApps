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
