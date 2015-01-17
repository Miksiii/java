/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import rs.fit.metropolitan.twitter.entities.User;

/**
 * Klasa UserDAOImpl koja predstavlja implementaciju interfejsa IUserDAO zaduzen
 * za korisnika (User)
 * @author Milan
 */
public class UserDAOImpl implements IUserDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjekatDB");
    private EntityManager manager  = emf.createEntityManager();
    private List users = new ArrayList<User>();
    
    /**
     * Metoda koja upisuje novog korisnika u bazu na osnovu prosledjenih param.
     * @param username
     * @param password
     * @param email 
     */
    @Override
    public void add(String username, String email, String password) {
        
        try {
        User user = new User();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        user.setUserName(username);
        user.setUserEmail(email);
        user.setUserPassword(password);
        
        manager.persist(user);
        
        tx.commit();
        manager.close();
        emf.close();
        } catch (Exception e) {
            System.out.println("Oops, an error occured while trying to create a new user" + e.getMessage());
        }
    }

    /**
     * Metoda koja pronalazi korisnika iz baze na osnovu prosledjenog email-a
     * i passworda. Metoda vraca objekat korisnika ukoliko se parametri podudaraju
     * sa nekim od rovova iz baze, u suprotnom moze doci do bacanja exceptiona 
     * tipa NoResultFound Exception ili NullPointer Exception.
     * @param email
     * @param password
     * @return User
     */
    @Override
    public User find(String email, String password) {
        
        User user = null;
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        user = manager.createNamedQuery("User.findByEmailAndPass", User.class).
                       setParameter("userEmail", email).
                       setParameter("userPassword", password).
                       getSingleResult(); 
        
        manager.close();
        emf.close();
        
        return user;
    }

    /**
     * Metoda koja vraca ArrayList korisnika
     * @return 
     */
    @Override
    public List<User> all() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        users = manager.createNamedQuery("User.findAll", User.class).
                       getResultList();
        
        manager.close();
        emf.close();
        
        return users;
    }

    
}
