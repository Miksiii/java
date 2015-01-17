/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.beans;

import java.util.List;
import javax.ejb.Local;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.Post;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
@Local
public interface BusinessStatelessBeanLocal {
    void createUser(String username, String email, String password);
    void createPost(User user, String message);
    void subscribe(User user, String followerUsername, int followId, String followUsername);
    void unsubscribe(User user, int followerId);
    boolean validateUser(String email, String password);
    User currentUser(String email, String password);
    List<User> usersList();
    List<Post> postsList();
    List<Follow> subscribedList(User user);
    List<Follow> subscribersList(int userId);
    List<Follow> followers(int userId);
}
