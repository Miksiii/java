/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs230.v04.javamail;

/**
 *
 * @author Milan
 */
public class Main {

    /**
     * Main method
     */
    public Main() {
        Mailer mailer = new Mailer();
        mailer.sendMail("milan.hakaj.1674@metropolitan.ac.rs", 
                        "This is subject", 
                        "This is message body"
                       );
        
        mailer.sendMailWithAttachment("milan.hakaj.1674@metropolitan.ac.rs", 
                                      "This is attachment",
                                      "Message body",
                                      "Name of file", 
                                      "attachments/gospodin.png"
                                     );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
