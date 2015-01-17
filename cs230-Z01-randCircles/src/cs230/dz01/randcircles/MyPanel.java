/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs230.dz01.randcircles;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klasa koja je odgovorna za iscrtavanje po ekranu
 */
class MyPanel extends JPanel implements ActionListener {
    
    Timer timer;
    static ArrayList circles = new ArrayList<Circle>();

    /**
     * Konstruktor
     */
    public MyPanel() {
        circleAdd(new Circle());
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        });
        timer.start();
    }

    /**
     * Glavna metoda koja iscrtava krugove na panelu
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics g2d = (Graphics2D) g;
        for(int i = 0; i < circles.size(); i++) {
            Circle tempCircle = (Circle) circles.get(i);
            tempCircle.draw(g2d);
        }
    }
    
    /**
     * Metoda koja dodaje krug u array listu i pokrece thread
     * @param c 
     */
    public static void circleAdd(Circle newCircle) {
        if(circles.size() == 0) {
            System.out.println("Adding circle to ArrayList..");
            circles.add(newCircle);
            Runnable runnable = newCircle;
            Thread t = new Thread(runnable);
            t.start();
        }
    }
    
    /**
     * Metoda koja brise krug iz array liste
     * @param c 
     */
    public static void circleRemove(Circle circle) {
        System.out.println("Removing circle from ArrayList..");
        circles.remove(circle);        
    } 

    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
