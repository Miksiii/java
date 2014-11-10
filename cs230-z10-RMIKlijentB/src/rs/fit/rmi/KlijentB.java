package rs.fit.rmi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milan
 */
public class KlijentB extends JFrame {

    private ILek lekObj;
    private JTextArea lekNaziv       = new JTextArea();
    private JTextArea lekDoza        = new JTextArea();
    private JTextArea lekProizvodjac = new JTextArea();
    private JButton   refreshList    = new JButton("Osvezi listu");
    
    
    /**
     * Konstruktor u kome se vrsi inicijalizacija RMI-a i GUI-a
     * @throws RemoteException
     * @throws NotBoundException 
     */
    public KlijentB() throws RemoteException, NotBoundException {
        inicijalizacijaRMI();
        inicijalizacijaGUI();
        inicijalizacijaKomponenti();
        /* Ukoliko jos uvek nema unetih lekova ispisi poruku */
        if(RMIListSize() == 0) {
            lekNaziv.setText("Lista sa podacima je prazna.");
        }
    }
   
    /**
     * Pokretacka metoda
     * @param args
     * @throws RemoteException
     * @throws NotBoundException 
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        new KlijentB();
    }
    
    /**
     * Metoda u kojoj se vrsi pretrazivanje objekta na udaljenom RMI serveru
     * @throws RemoteException
     * @throws NotBoundException 
     */
    private void inicijalizacijaRMI() throws RemoteException, NotBoundException {
        Registry registar = LocateRegistry.getRegistry("localhost", 2099);
        lekObj = (ILek) registar.lookup("lekObj");
        System.out.println("Objekat lek je uspesno pronadjen na rmi serveru");
    }
    
    /**
     * Inicijalizacija osnovnog frame-a
     */
    private void inicijalizacijaGUI() {
        this.setTitle("RMI Klijent B: Prikaz podataka o lekovima");
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Inicijalizacija gui komponenata
     * @throws RemoteException 
     */
    private void inicijalizacijaKomponenti() throws RemoteException {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        /* titlovi */
        panel.add(new JLabel("Naziv:"));
        panel.add(new JLabel("Doza:"));
        panel.add(new JLabel("Proizvodjac:"));
        /* vrednosti kolona */
        panel.add(lekNaziv);
        panel.add(lekDoza);
        panel.add(lekProizvodjac);
        /* dugme za osvezavanje */
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(refreshList, BorderLayout.SOUTH);
        this.add(panel);
        
        refreshList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    for(int i = 0; i<RMIListSize(); i++) {
                        
                        String naziv = RMIFetchAll().get(i)[0];
                        String doza  = RMIFetchAll().get(i)[1];
                        String proizvodjac = RMIFetchAll().get(i)[2];
                        
                        lekNaziv.setText(naziv);
                        lekDoza.setText(doza);
                        lekProizvodjac.setText(proizvodjac);
                        
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(KlijentB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    /**
     * Metoda koja vraca velicinu liste lekova
     * @return
     * @throws RemoteException 
     */
    private int RMIListSize() throws RemoteException {
        return lekObj.fetchAll().size();
    }
    
    /**
     * Metoda koja poziva udaljeni objekat odnosno njegovu metodu koja vraca
     * listu svih unetih podataka o lekovima
     * @return
     * @throws RemoteException 
     */
    private List<String[]> RMIFetchAll() throws RemoteException {
        return lekObj.fetchAll();
    }
}
