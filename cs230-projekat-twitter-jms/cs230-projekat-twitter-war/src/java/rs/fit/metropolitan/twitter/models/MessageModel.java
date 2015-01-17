/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.models;

import java.util.Date;
import rs.fit.metropolitan.twitter.entities.User;

/**
 *
 * @author Milan
 */
public class MessageModel {
    
    private String username;
    private String message;
    private Date date;

    public MessageModel(String username, String message, Date date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
