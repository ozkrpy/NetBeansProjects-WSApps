/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportegrafico;

/**
 *
 * @author ozkrp
 */
public class Jugador {
    
    private int id;
    private String nombre;
    private String consola;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String consola) {
        this.id = id;
        this.nombre = nombre;
        this.consola = consola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }
    
    
    
}
