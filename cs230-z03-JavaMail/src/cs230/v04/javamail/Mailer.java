/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs230.v04.javamail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Milan
 */
public class Mailer {
    
    private static Session session = null;
    private String sender          = "takmicenjetest@gmail.com";
    private String senderPassword  = "system123";
    private String smtp            = "smtp.gmail.com";
    private int    port            = 465;

    public Mailer() {
        mailSettings();
    }

    /**
     * Metoda u kojoj se definisu parametri za slanje
     */
    private void mailSettings() {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp);               //smtp protokol sa kojeg se salje poruka => sa google.smtp
        props.put("mail.smtp.socketFactory.port", port); //port koji se koristi za sokete
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //
        props.put("mail.smtp.auth", "true");             //username: takmicenjetest, pass: system123
        props.put("mail.smtp.port", port);               //smtp port
        
        //startovanje instance, pokretanje sesije..
        try {
            session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(sender, senderPassword);
               } 
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Metoda koja salje email do recipienta 
     * @param to
     * @param subject
     * @param message 
     */
    public void sendMail(String recipient, String subject, String message) {
        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(sender));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient)); 
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Metoda koja salje mejl sa atacmentom
     * @param to
     * @param subject
     * @param message
     * @param fileName
     * @param fileLocation 
     */
    public void sendMailWithAttachment(String recipient, String subject, String message, String fileName, String fileLocation) {
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(sender));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            mimeMessage.setSubject(subject);
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(message);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = fileLocation;
            DataSource source = new FileDataSource(fileLocation);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            mimeMessage.setContent(multipart);
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
