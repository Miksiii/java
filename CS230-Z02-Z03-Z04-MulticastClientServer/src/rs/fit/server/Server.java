/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.server;

import java.awt.List;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miksi
 */
public class Server {
    
    /* instanciranje potrebnih podataka za komunikaciju preko ms socketa */
    private int PORT_NUM = 5000;
    private String MS_GROUP = "239.255.255.253";
    private MulticastSocket msocket;
    private byte[] bufferReceiver = new byte[1024];
    private DatagramPacket packetUDP;

    /**
     * Konstruktor u kome se kreira novi multicast socket preko kojeg se 
     * pristupa odredjenoj grupi pomocu imena te grupe.
     * @throws IOException 
     */
    public Server() throws IOException {
        System.out.println("[Server] Startovanje multicast servera...");
        msocket = new MulticastSocket(PORT_NUM);
        msocket.joinGroup(InetAddress.getByName(MS_GROUP));
        System.out.println("[Server] je sada pridruzen u ms grupi...");
        receiveMessages();
    }

    /**
     * Konstantno primanje klijentskih poruka odnosno zahteva za proracun 
     * aritmeticke sredine. Ova metoda prima paket, rasclanjuje ga na nekoliko
     * delova od kojeg svaki odgovara po jedna vrednost(username, email, a, b, c),
     * izracuna aritmeticku vrednosti i salje rezultat na mejl klijentu.
     */
    public void receiveMessages() {
        /* paket koji ce primiti server */
        packetUDP = new DatagramPacket(bufferReceiver, bufferReceiver.length);
        
        /**
         * Dokle god server prima pakete od strane klijenata metoda radi posao 
         * iz komentara.
         */
        while(true) {
            try {
                msocket.receive(packetUDP);
                String clientData = new String(packetUDP.getData(), "UTF-8");
                
                /* Rasclanjivanje poruke */
                String[] find   = clientData.split("#");
                /* Pronadji iz poruke detalje kao sto su username, email.. */
                String username = find[1].trim();
                String email    = find[2].trim();
                int prviBr      = Integer.parseInt(find[3].trim());
                int drugiBr      = Integer.parseInt(find[4].trim());
                int treciBr     = Integer.parseInt(find[5].trim());
                
                /* Serverska konzola */
                System.out.println(username + " says: Moj email je " + email + 
                                   ", izracunaj mi aritmeticku sredinu brojeva " +
                                   prviBr + ", " + drugiBr + " i " + treciBr + ".");
                
                /* racunanje airtmeticke sredine i slanje odgovora na mejl */
                izracunajAritmetickuSredinu(username, email, prviBr, drugiBr, treciBr);
                
            } catch (IOException ex) {
                System.out.println("Exception occured.. Doslo je do greske prilikom primanja ili citanja poruke..");
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metoda koja racuna aritmeticku sredinu brojeva prosledjenih od strane
     * klijenta i rezultat salje na mejl.
     * @param username
     * @param email
     * @param prviBr
     * @param drugiBr
     * @param treciBr 
     */
    private void izracunajAritmetickuSredinu(String username, String email, int prviBr, int drugiBr, int treciBr) throws UnknownHostException, IOException {
        int rezultat = (prviBr + drugiBr + treciBr) / 3;
        String body  = "Postovani gospodine/gospodjice " + username + ", \n\n" +
                       "Aritmeticka sredina za brojeve " + prviBr + ", " + drugiBr + ", " + treciBr + " " +
                       "je " + rezultat + "\n\n " + 
                       "Hvala na poverenju, \n Vas metropolitan.";

        MailSender mailSender = new MailSender();
        mailSender.sendMail(email, "Server: aritmeticka sredina", body);
        System.out.println("Server: Zahtev za korisnicko ime " + username + " uspesno obradjen.");
    }
    
}
