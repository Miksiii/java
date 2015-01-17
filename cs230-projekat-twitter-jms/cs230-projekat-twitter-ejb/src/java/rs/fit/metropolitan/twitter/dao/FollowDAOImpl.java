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
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
public class FollowDAOImpl implements IFollowDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjekatDB");
    private EntityManager manager  = emf.createEntityManager();
    private List<Follow> followedUsers = new ArrayList<Follow>();
    private List<Follow> userFollowers = new ArrayList<Follow>();
    private List<Follow> followers = new ArrayList<Follow>();

    /**
     * Metoda koja dodaje novog korisnika u tabelu Follow koji predstavlja 
     * korisnika koji se subscribe-ovao na odredjenog korisnika.
     * @param user => userId followera
     * @param followerUsername => username followera
     * @param followId => id osobe koju prati
     * @param followUsername => username osobe koju prati
     */
    @Override
    public void add(User user, String followerUsername, int followId, String followUsername) {
        try {
            Follow follow = new Follow();

            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            
            follow.setUserId(user);
            follow.setUserName(followerUsername);
            follow.setFollowUser(followId);
            follow.setFollowUserName(followUsername);
            manager.persist(follow);

            tx.commit();
            manager.close();
            emf.close();
        } catch (Exception e) {
            System.out.println("Oops, an error occured while trying to sent a message." + e.getMessage());
        }

    }

    /**
     * Metoda koja vraca listu korisnika na koje smo se subscribe-ovali
     * @param user
     * @return following list
     */
    @Override
    public List<Follow> showFollowed(User user) {
        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        followedUsers = manager.createNamedQuery("Follow.findFollowedUsers", Follow.class).
                       setParameter("userId", user).
                       getResultList(); 
        
        manager.close();
        emf.close();
        
        return followedUsers;
    }

    /**
     * Metoda koja prikazuje broj korisnika koji su pratioci trenutnog
     * @param user
     * @return 
     */
    @Override
    public List<Follow> showFollowersNum(int userId) {
        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        userFollowers = manager.createNamedQuery("Follow.findUserFollowers", Follow.class).
                       setParameter("userId", userId).
                       getResultList(); 
        
        manager.close();
        emf.close();
        
        return userFollowers;
    
    }

    /**
     * Metoda koja je vezana za unsubscribe
     * @param user
     * @param userId
     */
    @Override
    public void remove(User user, int userId) {
        Follow follower = null;
                
        System.out.println("Deleting follower..");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        follower = manager.createNamedQuery("Follow.findFollowerByFollowUserAndUserRef", Follow.class).
                setParameter("userId", user).
                setParameter("followUser", userId).
                getSingleResult();
        
        manager.remove(follower);
        System.out.println("Follower deleted 4.." + userId);
        tx.commit();
        manager.close();
        emf.close();
        
    }

    @Override
    public List<Follow> showFollowersNames(int userId) {

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        followers = manager.createNamedQuery("Follow.findFollowers", Follow.class).
                       setParameter("userId", userId).
                       getResultList(); 
        
        manager.close();
        emf.close();
        
        return followers;
    }
    
}
