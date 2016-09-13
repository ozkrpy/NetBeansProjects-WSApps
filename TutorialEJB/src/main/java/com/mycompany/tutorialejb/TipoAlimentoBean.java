/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorialejb;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author ozkrp
 */
@Named(value = "tipoAlimentoBean")
@RequestScoped
public class TipoAlimentoBean {

    private String codigoTipoAlimento;
    private Double descripcionTipoAlimento;
    private String password;
    private String texto;
    private boolean booleano;
    private int[] itemsSeleccionados;
    private int itemRadio;
    private int itemListbox;
    private int[] itemsListbox;
    private int oneMenu;
    private List<Persona> listaPersonas;
    private List<String> listaCadena;
    private String cadena;
    private Map<String, String> mapeo;
    
    //definicion para que este bean pueda invocar a otro bean
    @ManagedProperty(value="#{mySessionBean}")
    private MySessionBean mySessionBean = new MySessionBean();
    
    public TipoAlimentoBean() {
    }
    
    @PostConstruct
    public void init() {
        listaCadena = new ArrayList<String>();
        listaCadena.add("cadena1");
        listaCadena.add("cadena2");
        listaCadena.add("cadena3");
        listaCadena.add("cadena4");
        
        mapeo = new HashMap<String, String>();
        mapeo.put("cadena1","mapa1");
        mapeo.put("cadena2","mapa2");
        mapeo.put("cadena3","mapa3");
        mapeo.put("cadena4","mapa4");
    }

    public MySessionBean getMySessionBean() {
        return mySessionBean;
    }

    public void setMySessionBean(MySessionBean mySessionBean) {
        this.mySessionBean = mySessionBean;
    }
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public Map<String, String> getMapeo() {
        return mapeo;
    }

    public void setMapeo(Map<String, String> mapeo) {
        this.mapeo = mapeo;
    }
    

    public List<String> getListaCadena() {
        return listaCadena;
    }

    public void setListaCadena(List<String> listaCadena) {
        this.listaCadena = listaCadena;
    }
    
    public String getCodigoTipoAlimento() {
        return codigoTipoAlimento;
    }

    public void setCodigoTipoAlimento(String codigoTipoAlimento) {
        this.codigoTipoAlimento = codigoTipoAlimento;
    }

    public Double getDescripcionTipoAlimento() {
        return descripcionTipoAlimento;
    }

    public void setDescripcionTipoAlimento(Double descripcionTipoAlimento) {
        this.descripcionTipoAlimento = descripcionTipoAlimento;
    }
    
    public String guardarDatos(int numeroParametro) {
//        String valorRetorno = "Se guardaron los datos: " + this.codigoTipoAlimento + ", " + this.getDescripcionTipoAlimento();
//        System.out.println("Se selecciono en la lista: ");
//        for(int i:itemsSeleccionados) {
//            System.out.println(i + ", ");
//        }
//        System.out.println("Se selecciono en Many checkbox: ");
//        for(int i:itemsListbox) {
//            System.out.println(i + ", ");
//        }
//        System.out.println("Radio seleccionado: " + this.itemRadio);
//      
        try {
            System.out.println("Guardando el numero: " + numeroParametro);
        } catch (Exception e) {
            return "falla";
        }
        //NAVEGACION IMPLICITA retorna 'show' para que al ejecutarse el metodo el texto reconocido sea la siguiente pagina a la que se va a navegar.
        //?faces-redirect=true indica que la pagina debe aparecer en el navegador
        return "show?faces-redirect=true"; 
        
        //NAVEGACION EXPLICITA retorna el nombre de la regla para que al ejecutarse el metodo el texto reconocido sea la siguiente pagina a la que se va a navegar.
        //return "exito"; 
    }
    
    public void metodoListener (ActionEvent e) {
        //System.out.println("Se selecciono: " + this.booleano);
        
    }
    
    public List<Persona> getListaPersonas() {
        return this.listaPersonas;        
    }
    


    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public int getOneMenu() {
        return oneMenu;
    }

    public void setOneMenu(int oneMenu) {
        this.oneMenu = oneMenu;
    }

    public int[] getItemsListbox() {
        return itemsListbox;
    }

    public void setItemsListbox(int[] itemsListbox) {
        this.itemsListbox = itemsListbox;
    }

    public int getItemListbox() {
        return itemListbox;
    }

    public void setItemListbox(int itemListbox) {
        this.itemListbox = itemListbox;
    }

    public int getItemRadio() {
        return itemRadio;
    }

    public void setItemRadio(int itemRadio) {
        this.itemRadio = itemRadio;
    }

    public int[] getItemsSeleccionados() {
        return itemsSeleccionados;
    }

    public void setItemsSeleccionados(int[] itemsSeleccionados) {
        this.itemsSeleccionados = itemsSeleccionados;
    }
    
    public boolean isBooleano() {
        return booleano;
    }

    public void setBooleano(boolean booleano) {
        this.booleano = booleano;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    

    

}
