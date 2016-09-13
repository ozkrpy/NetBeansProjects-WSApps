/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessNumber;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ozkrp
 */
@Named(value = "UserNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    int randomInteger;
    int userNumber;
    String response;

    /**
     * Creates a new instance of UserNumberBean
     */
    public UserNumberBean() {
        Random random = new Random();
        randomInteger = new Integer(random.nextInt(10));
        System.out.println("el numero generado es: " + randomInteger);
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getResponse() {
        //if ((userNumber != null) && (userNumber.compareTo(randomInteger) == 0)) {
        if (userNumber == randomInteger) {
            //invalidate user session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            return "Yay! You got it!";
        } else {
            return "<p>Sorry, " + userNumber + " isn't it.</p>" + 
                   "<p>Guess again...</p>";
        }
    }

}
