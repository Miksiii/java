package rs.fit.rmi;

 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author profesor
 */
public class Klijent extends JFrame {

    private IStudentServer student;
    private JButton dugme = new JButton("Uzmi rezultat");
    private JTextField naziv = new JTextField();
    private JTextField rezultat = new JTextField();

    public Klijent() throws RemoteException, NotBoundException {
        inicijalizacijaRMI();
        inicijalizacija();
        this.setTitle("RMI klijent");
        this.setSize(250, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);


    }

    private void inicijalizacija() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Naziv studenta"));
        panel.add(naziv);
        panel.add(new JLabel("Rezultat studenta"));
        panel.add(rezultat);
        add(panel);
        add(dugme, BorderLayout.SOUTH);

        dugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getRezultat();
                } catch (RemoteException ex) {
                    Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void getRezultat() throws RemoteException {
       
        double rez = student.pronadjiRezultat(naziv.getText().trim());

        if (rez < 0) {
            rezultat.setText("Nije pronadjeno");
        } else {
            rezultat.setText(""+rez);
        }

    }

    private void inicijalizacijaRMI() throws RemoteException, NotBoundException {
        Registry registar = LocateRegistry.getRegistry("localhost", 2099);
        student = (IStudentServer) registar.lookup("studentObj");
        System.out.println("Student objekat na serveru nadjen!");
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        new Klijent();
    }
}
