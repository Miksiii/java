/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.klijent;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rs.fit.server.Server;

/**
 *
 * @author miksi
 */
public class KlijentB extends JFrame {
    
    /* instanciranje podataka potrebnih za komunikaciju preko ms socketa */
    private int PORT_NO = 5000;
    private String MS_GRUPA = "239.255.255.253";
    private String username = "miksi";
    private MulticastSocket msocket;
    private byte[] bufferReceiver = new byte[1024];
    private DatagramPacket packetUDP;
    
    /* jpanel komponente */
    private JTextField prviBr  = new JTextField();
    private JTextField drugiBr = new JTextField();
    private JTextField treciBr = new JTextField();
    private JTextField email = new JTextField();
    private JButton    messageSent  = new JButton("Posalji poruku");
    private JLabel     messageInfo  = new JLabel("");
    
    /**
     * Konstruktor u kome se klijent prikljucuje grupi putem ms socketa i 
     * u kome se vrsi inicijalizacija guia
     * @throws IOException 
     */
    public KlijentB() throws IOException {
        System.out.println("[KlijentB] Startovanje multicast klijenta...");
        msocket = new MulticastSocket(PORT_NO);
        msocket.joinGroup(InetAddress.getByName(MS_GRUPA));
        System.out.println("[KlijentB] je sada pridruzen grupi...");
        initGUI();
    }
    
    /**
     * Setovanje osnovnog frame-a kao i komponenti guia
     */
    private void initGUI() {
        JPanel p = new JPanel();
        
        /* unesi korisnicko ime */
        username = (String) JOptionPane.showInputDialog(p, "Unesite korisnicko ime: ");
        
        /* prikazi jframe */
        this.setTitle("KlijentB (" + username + ")");
        this.setSize(250, 450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* setovanje komponenti */
        p.setLayout(new GridLayout(10, 1));
        p.add(new JLabel("Unesite prvi broj"));
        p.add(prviBr);
        p.add(new JLabel("Unesite drugi broj"));
        p.add(drugiBr);
        p.add(new JLabel("Unesite trecibroj"));
        p.add(treciBr);
        p.add(new JLabel("Unesite email "));
        p.add(email);
        p.add(messageSent);
        p.add(messageInfo);
        
        this.add(p);
        
        messageSent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    sentMessage();
                } catch (IOException ex) {
                    Logger.getLogger(KlijentA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /**
     * Metoda koja salje poruku serveru preko multicasta
     * @throws UnknownHostException
     * @throws IOException 
     */
    private void sentMessage() throws UnknownHostException, IOException {
        String mail = email.getText().trim();
        String a = prviBr.getText().trim();
        String b = drugiBr.getText().trim();
        String c = treciBr.getText().trim();
        
        if(!mail.equals("") && !a.equals("") && !b.equals("") && !c.equals("")) {
            /* pripremanje poruke za slanje */
            String clientMessage = "# " + username + " # " + mail + " # " + a + " # " + b + " # " + c + " # ";
            
            /* Pakovanje poruke u paket */
            packetUDP = new DatagramPacket(
                                    clientMessage.getBytes(),
                                    clientMessage.getBytes().length,
                                    InetAddress.getByName(MS_GRUPA),
                                    PORT_NO
                                );
            
            /* slanje poruke */
            msocket.send(packetUDP);
            
            email.setText("");
            prviBr.setText("");
            drugiBr.setText("");
            treciBr.setText("");
            messageInfo.setText("Poruka poslata.");
        } else {
            messageInfo.setText("Popunite sva polja.");
        }
    }
}
