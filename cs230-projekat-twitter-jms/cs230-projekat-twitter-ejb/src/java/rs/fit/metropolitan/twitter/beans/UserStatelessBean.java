/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

/**
 *
 * @author Milan
 */
@Stateless

public class UserStatelessBean implements UserStatelessBeanLocal {
    @Resource(mappedName = "jms/myTwitterQueue")
    private Queue myTwitterQueue;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    private boolean session;
    private int id;
    private String username;
    private String email;
    private String password;
    
    /**
     * Seter za atribut session koji ukazuje na to da li je sesija aktivna ili ne
     * @param session 
     */
    @Override
    public void setSession(boolean session) {
        this.session = session;
    }
    
    /**
     * Seter za id korisnika
     * @param id 
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Seter za korisniko ime
     * @param username 
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Seter za email
     * @param email 
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Seter za password
     * @param password 
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Geter za stanje atributa sesija koji ukazuje na to da li je sesija aktivna 
     * ili ne
     * @return 
     */
    @Override
    public boolean getSession() {
        return session;
    }

    /**
     * Geter za id korisnika
     * @return 
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * Geter za korisnicko ime
     * @return 
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Geter za email
     * @return 
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Geter za passwrd
     * @return 
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Metoda u kojoj se nalazi createProducer i send metod koji salju JMS 
     * poruku na odredjenu destinaciju, u odredjeni Queue. Poruka se najpre razdvaja
     * na dva dela te se na odredistu iz nje vadi korisnicko ime kako bi se znalo
     * ko je poruku poslao.
     * @param message
     * @param username 
     */
    @Override
    public void sendJMSMessageToMyTwitterQueue(String message, String username) {
        try {
            String newMessage = "# " + username + " # " + message;
            context.createProducer().send(myTwitterQueue, newMessage);
        } catch (JMSRuntimeException t) {
            System.out.println(t.toString());
        }
    }  
}
