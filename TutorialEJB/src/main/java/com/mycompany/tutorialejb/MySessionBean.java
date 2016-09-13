/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorialejb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author ozkrp
 */
@Named(value = "mySessionBean")
@SessionScoped
public class MySessionBean implements Serializable {

    private int myNumber = new Random().nextInt();

    
    public int getMyNumber() {
        System.out.println("getMyNumber : " + myNumber);
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        System.out.println("setMyNumber : " + myNumber);
        this.myNumber = myNumber;
    }

}
