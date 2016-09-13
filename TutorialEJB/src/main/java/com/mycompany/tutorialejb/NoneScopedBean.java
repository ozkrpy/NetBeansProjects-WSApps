/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorialejb;

import javax.inject.Named;
import javax.faces.bean.NoneScoped;

/**
 *
 * NoneScoped sobrevive por lo que sobreviva el bean que lo inicializa
 */
@Named(value = "noneScopedBean")
@NoneScoped
public class NoneScopedBean {

    /**
     * Creates a new instance of NoneScopedBean
     */
    public NoneScopedBean() {
    }
    
}
