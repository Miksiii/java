/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.rmi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Milan
 */
public class KlijentA extends JFrame {

    private ILek lekObj;
    private JTextField lekNaziv       = new JTextField();
    private JTextField lekDoza        = new JTextField();
    private JTextField lekProizvodjac = new JTextField();
    private JButton    actionBtn      = new JButton("Potvrdi");
    private JLabel     actionResponse = new JLabel();
    
    /**
     * Konstruktor u kome se vrsi inicijalizacija RMI-a i grafike
     * @throws RemoteException
     * @throws NotBoundException 
     */
    public KlijentA() throws RemoteException, NotBoundException {
        inicijalizacijaRMI();
        inicijalizacijaGUI();
        inicijalizacijaKomponenti();
    }
    
    /**
     * Pokretacka metoda
     * @param args
     * @throws RemoteException
     * @throws NotBoundException 
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        new KlijentA();
    }
    
    /**
     * Metoda koja vrsi pretrazivanje objekta na udaljenom RMI serveru
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
        this.setTitle("RMI Klijent A: Unesite podatke o leku");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Metoda u kojoj se inicijalizuju ostale komponente gui-a
     */
    private void inicijalizacijaKomponenti(){ 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2)); //rows, cols
        panel.add(new JLabel("Naziv leka: "));
        panel.add(lekNaziv);
        panel.add(new JLabel("Doza leka: "));
        panel.add(lekDoza);
        panel.add(new JLabel("Proizvodjac leka: "));
        panel.add(lekProizvodjac);
        panel.add(new JLabel(""));
        panel.add(actionBtn);
        panel.add(new JLabel(""));
        panel.add(actionResponse);
        this.add(panel);
        
        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    RMIAdd();
                } catch (RemoteException rmiE){
                    actionResponse.setText("Doslo je do greske.");
                    System.out.println("Exception occured => " + rmiE.toString());
                }
            }
        });
    }
    
    /**
     * U ovoj metodi se vrsi pozivanje metode udaljenog objekta za dodavanje
     * novog leka.
     * @throws RemoteException 
     */
    private void RMIAdd() throws RemoteException {
        String naziv = lekNaziv.getText().trim();
        String doza  = lekDoza.getText().trim();
        String proiz = lekProizvodjac.getText().trim();
        
        if(!naziv.equals("") || !doza.equals("") || !proiz.equals("")) {
            lekObj.add(
                    lekNaziv.getText().trim(), 
                    lekDoza.getText().trim(), 
                    lekProizvodjac.getText().trim()
                );

            lekNaziv.setText("");
            lekDoza.setText("");
            lekProizvodjac.setText("");
            actionResponse.setText("Lek uspesno dodat.");
        } else {
            actionResponse.setText("Popunite sva polja.");
        }
    }
     
}
