/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs230.dz01.randcircles;

import static cs230.dz01.randcircles.MyPanel.circles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja reprezentuje krug kojeg je potrebno iscrtati
 * @author Milan
 */
public class Circle implements Runnable {

    private double x, y;
    private int width, height;
    private Random rand = new Random();
    private float r = rand.nextFloat();
    private float g = rand.nextFloat();
    private float b = rand.nextFloat();
    private Color colorRGB;
    
    
    /**
     * Konstruktor klase Circle
     */
    public Circle() {
        this.width  = 80;
        this.height = 80;
        this.colorRGB = new Color(r, g, b);
        randomPos(0, 720, 0, 520);
    }
    
    /**
     * Metoda koja iscrtava objekat klase circle
     * @param g 
     */
    public void draw(Graphics g) {
        Graphics g2d = (Graphics2D) g;
        g2d.setColor(colorRGB);
        g2d.fillOval((int) x, (int) y, width, height);
    }
    
    /**
     * Metoda koja daje random vrednost za x i y koordinate
     */
    private void randomPos(int xmin, int xmax, int ymin, int ymax) {
        x = xmin + (int)(Math.random() * ((xmax - xmin) + 1));
        y = ymin + (int)(Math.random() * ((ymax - ymin) + 1));
    }
    
    /**
     * Runnable metod koji overrajduje isti u interfejsu runnable a koji 
     * radi u pozadini
     */
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
                for(int i = 0; i < circles.size(); i++) {
                    Circle tempCircle = (Circle) circles.get(i);
                    MyPanel.circleRemove(tempCircle);
                    MyPanel.circles.add(new Circle());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
