/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs230.dz01.randcircles;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Pokretacka klasa
 * @author Milan
 */
public class Main extends JFrame {

    JPanel myPanel = new MyPanel();
    
    /**
     * Main metoda u kojoj se setuje glavni panel
     */
    public Main() {
        this.setContentPane(myPanel);
    }
    /**
     * Main, glavna pokretacka metoda
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jframeGet();
    }
    
    /**
     * Metoda u kojoj se setuje jframe
     */
    private static void jframeGet() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jf = new Main();
        jf.setSize(800, 600);
        jf.setTitle("Random circles");
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}

