/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.dao;

import java.util.List;
import rs.fit.metropolitan.twitter.entities.Post;
import rs.fit.metropolitan.twitter.entities.User;

/**
 * Interfejs DAO sloja IPostDAO zaduzen za poruke (Post) koje korisnik salje.
 * @author Milan
 */
public interface IPostDAO {
    void add(User user, String message);
    List<Post> all();
}
