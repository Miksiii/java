/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.beans;

import javax.ejb.Local;

/**
 *
 * @author Milan
 */
@Local
public interface UserStatelessBeanLocal {
    void setSession(boolean session);
    void setId(int id);
    void setUsername(String username);
    void setEmail(String email);
    void setPassword(String password);
    //void sentMessageToQueue(String message);
    boolean getSession();
    int getId();
    String getUsername();
    String getEmail();
    String getPassword();
    void sendJMSMessageToMyTwitterQueue(String message, String username);
    
}
