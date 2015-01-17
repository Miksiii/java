/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.dao;

import java.util.List;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
public interface IFollowDAO {
    void add(User user, String followerUsername, int followId, String followUsername);
    void remove(User user, int userId);
    List<Follow> showFollowed(User user);
    List<Follow> showFollowersNum(int userId); //prikazuje samo broj followera
    List<Follow> showFollowersNames(int userId);
}
