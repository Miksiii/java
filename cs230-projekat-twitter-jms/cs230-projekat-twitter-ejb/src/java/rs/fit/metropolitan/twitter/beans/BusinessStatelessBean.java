/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.beans;

import java.util.List;
import javax.ejb.Stateless;
import rs.fit.metropolitan.twitter.dao.FollowDAOImpl;
import rs.fit.metropolitan.twitter.dao.IFollowDAO;
import rs.fit.metropolitan.twitter.dao.IPostDAO;
import rs.fit.metropolitan.twitter.dao.IUserDAO;
import rs.fit.metropolitan.twitter.dao.PostDAOImpl;
import rs.fit.metropolitan.twitter.dao.UserDAOImpl;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.Post;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
@Stateless
public class BusinessStatelessBean implements BusinessStatelessBeanLocal {

     /**
     * Metoda koja dodaje novog korisnika u bazu nakon uspesnog registrovanja
     * @param username
     * @param email
     * @param password 
     */
    @Override
    public void createUser(String username, String email, String password) {
        IUserDAO userDao = new UserDAOImpl();
        userDao.add(username, email, password);
    }

    /**
     * Metoda se poziva prilikom submitovanja login forme 
     * Metod proverava da li moze da pronadje bilo kakav podatak na osnovu 
     * prosledjenih parametara i ukoliko moze nova sesija moze da otpocne, u 
     * suprotnom korisnik biva obavesten o gresci
     * @param email
     * @param password
     * @return 
     */
    @Override
    public boolean validateUser(String email, String password) {
        IUserDAO userDao = new UserDAOImpl();
        boolean  isValid;
        
        try {
            userDao.find(email, password).getUserEmail();
            isValid = true;
        } catch(Exception e) {
            System.out.println("." + e.getMessage());
            isValid = false;
        }
        
        System.out.println("validate method ending. Result: " + isValid);
        return isValid;
    }

    /**
     * Kada je validacija prilikom logovanja uspesno zavrsena, poziva se ova metoda
     * koja vraca trenutno ulogovanog korisnika odnosno objekat tipa korisnik
     * koji odgovara parametrima prosledjenim u login formi
     * @param email
     * @param password
     * @return User Who is Logged In
     */
    @Override
    public User currentUser(String email, String password) {
        IUserDAO userDao = new UserDAOImpl();
        return userDao.find(email, password);
    }

    /**
     * Metoda vraca listu svih trenutno registrovanih korisnika
     * @return users list
     */
    @Override
    public List<User> usersList() {
        IUserDAO userDao = new UserDAOImpl();
        return userDao.all();
    }

    /**
     * Metoda koja se poziva kada korisnik zeli da napise post. Prilikom 
     * submitovanja forme, poziva se ovaj metod koji upisuje novi post, novu 
     * poruku u tabelu prema prosledjenim parametrima user id koji je tipa korisnik
     * koji predstavlja referencu na drugu tabelu i poruka tipa string
     * @param user
     * @param message 
     */
    @Override
    public void createPost(User user, String message) {
        IPostDAO postDao = new PostDAOImpl();
        postDao.add(user, message);
    }

    /**
     * Metoda koja vraca listu svih postova koje se trenutno nalaze u bazi
     * @return posts list
     */
    @Override
    public List<Post> postsList() {
        IPostDAO postDao = new PostDAOImpl();
        return postDao.all();
    }

    /**
     * Ovo je subscribe metod. Kada korisnik iz liste svih korisnika odluci 
     * da zeli da prati nekog od njih pritiskom na dugme subscribe prosledjuje se 
     * njegov id kao objekat odnosno referenca na tabelu Follow kao i id korisnika
     * kojeg zeli da prati.
     * @param user
     * @param followId 
     */
    @Override
    public void subscribe(User user, String followerUsername, int followId, String followUsername) {
        IFollowDAO followDao = new FollowDAOImpl();
        followDao.add(user, followerUsername, followId, followUsername);
    }

    /**
     * Metoda koja vraca listu svih korisnika koje trenutno ulogovani korisnik prati
     * @param user
     * @return 
     */
    @Override
    public List<Follow> subscribedList(User user) {
        IFollowDAO followDao = new FollowDAOImpl();
        return followDao.showFollowed(user);
    }

    /**
     * Metoda koja vraca listu korisnika koji prate trenutno ulogovanog korisnika
     * @param userId
     * @return 
     */
    @Override
    public List<Follow> subscribersList(int userId) {
        IFollowDAO followDao = new FollowDAOImpl();
        return followDao.showFollowersNum(userId);
    }

    /**
     * Metod koji brise korisnika odnosno osobu na koju se treuntno ulogovani
     * korisnik pretplatio
     * @param user
     * @param followerId 
     */
    @Override
    public void unsubscribe(User user, int followerId) {
        IFollowDAO followDao = new FollowDAOImpl();
        followDao.remove(user, followerId);
    }

    /**
     * Metoda koja vraca listu objekata korisnika pratioca
     * @param user
     * @return 
     */
    @Override
    public List<Follow> followers(int userId) {
        IFollowDAO followDao = new FollowDAOImpl();
        return followDao.showFollowersNames(userId);
    }
    
    

    
}
