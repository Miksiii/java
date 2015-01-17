/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import rs.fit.metropolitan.twitter.entities.Post;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
public class PostDAOImpl implements IPostDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjekatDB");
    private EntityManager manager  = emf.createEntityManager();
    private List userPosts = new ArrayList<Post>();

    /**
     * Metoda koja upisuje novoregistrovanog korisnika u bazu
     * @param user
     * @param message 
     */
    @Override
    public void add(User user, String message) {
        try {
        Post post = new Post();
        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        post.setUserId(user);
        post.setUserName(user.getUserName());
        post.setPostMessage(message);
        Calendar cal = java.util.Calendar.getInstance(); 
        Date timeNow = new Date(cal.getTimeInMillis());        
        post.setPostDate(timeNow);  
        
        manager.persist(post);
        
        tx.commit();
        manager.close();
        emf.close();
        } catch (Exception e) {
            System.out.println("Oops, an error occured while trying to sent a message." + e.getMessage());
        }
    }

    /**
     * Metoda koja vraca listu svih poruka za koje se korisnik pretplatio
     * @return 
     */
    @Override
    public List<Post> all() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        userPosts = manager.createNamedQuery("Post.findAllFollowers", Post.class).
                       getResultList();
        
        manager.close();
        emf.close();
        
        return userPosts;
    }
    
}
