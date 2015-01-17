/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.dao;

import java.util.List;
import rs.fit.metropolitan.twitter.entities.User;

/**
 * Interfejs DAO sloja IUserDAO zaduzen za korisnika (User)
 * @author Milan
 */
public interface IUserDAO {
    public void add(String username, String email, String password);
    public User find(String email, String password);
    public List<User> all();
}
