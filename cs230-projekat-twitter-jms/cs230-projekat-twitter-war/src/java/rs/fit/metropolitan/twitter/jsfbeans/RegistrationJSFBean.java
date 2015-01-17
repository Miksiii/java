/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.jsfbeans;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import rs.fit.metropolitan.twitter.beans.BusinessStatelessBeanLocal;

/**
 *
 * @author Milan
 */
@ManagedBean(name = "registration")
@RequestScoped
public class RegistrationJSFBean {
    @EJB
    private BusinessStatelessBeanLocal businessStatelessBean;
    private String username;
    private String email;
    private String password;

    /**
     * Geter za username
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Seter za username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Geter za email
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * seter za email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
        
    }
    /**
     * Geter za password
     * @return 
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Seter za password 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Metoda se poziva prilikom submitovanja forme za registraciju, vrsi se 
     * validacija na serverskoj strani i ukoliko je sve u redu upisuje 
     * novog korisnika u bazi pozivom metode createUser EJB-a.
     * @return
     * @throws IOException 
     */
    public String getSignUpResponse() throws IOException {
        
        if(username != null && email != null && password != null) {
            businessStatelessBean.createUser(username, email, password);
            return "You have been sucessfully registered. You may now sign in!";
        } else {
            return null;
        }
    }

    
}
