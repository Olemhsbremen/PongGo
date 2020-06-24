/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */

public class GamePanel extends JPanel implements KeyListener {
    
    //Layout des GamePanels
    CardLayout c1;
    
    Timer move;
    
    Sball ball;

    //Bewegungsvariablen Spieler1
    private boolean player1up = false;
    private boolean player1down = false;
    
    //Bewegungsvariablen Spieler2
    private boolean player2up = false;
    private boolean player2down = false;

    //Variablen zur Posistionserkennung Spieler1
    private int xsp1 = 20;
    private int ysp1 = 300;
    
    //Variablen zur Posistionserkennung Spieler2
    private int xsp2 = 755;
    private int ysp2 = 300;
    
    
    //Farbgradient für den Hintergrund des Gamepanels
    GradientPaint p = new GradientPaint(100, 100, new Color(202, 122, 42), 800, 30, new Color(111, 58, 6));
    
    
//     public class Sball
//    {
// 
//        public Sball(Color a, int x, int y, int z,int gradx,int grady)
//        {
//            farbe = a;
//            bx = x;
//            by = y;
//            radius = z;
//            gradX = gradx;
//            gradY = grady;
//            
//        }
//    }
    public GamePanel(CardLayout c1) {
        
        Sound Lied = new Sound();
        
        
        
        this.c1 = c1;
        
        //Ball mit definierten Parametern
        ball = new Sball(Color.white, getWidth()/2, getHeight()/2 ,12,1);

        setLayout(null);
        addKeyListener(this);

        //Beschreibung der Bewegung der beiden Spieler
        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                //Bewegung nach oben Spieler1
                if (player1up == true) {

                    if (ysp1 >= 20) {
                        ysp1 -= 2;
                    }
                    
                //Bewegung nach unten Spieler1
                } else if (player1down == true) {

                    if (ysp1 <= getWidth() - 255) {
                        ysp1 += 2;
                    }
                }
                
                //Bewegung nach oben Spieler2
                if (player2up == true) {

                    if (ysp2 >= 20) {
                        ysp2 -= 2;
                    }
                    
                //Bewegung nach unten Spieler2    
                } else if (player2down == true) {

                    if (ysp2 <= getWidth() - 255) {
                        ysp2 += 2;
                    }
                }
                
                //Ballbewegung und Kollisions Erkennung
                
                // Wechsel der Richtung Obere Wand
                if (ball.by - ball.radius <= 0)
                {
                    ball.gradY = 1;
                } 
                // Wechsel der Richtung Untere Wand
                if (ball.by + ball.radius > getHeight()){
                    ball.gradY = -1;
                }
                // "Neustart" Fehler Spieler rechts
                if (ball.bx >= getWidth()){
                    ball.bx= (getWidth())/2-ball.radius;
                    ball.by= (getHeight())/2-ball.radius;
                    Lied.FehlerButton();
                    
                    ball.gradX= -1;
                // "Neustart" Fehler Spieler links
                }
                if (ball.bx <= 0 ){
                    ball.bx= (getWidth())/2-ball.radius;
                    ball.by= (getHeight())/2-ball.radius;
                    Lied.FehlerButton();
                    
                    ball.gradX= 1;
                }
                //Kollision Spieler Links und Ball
                if (ball.bx < xsp1 +24 && ball.bx > xsp1 && ball.by < ysp1 + 120 && ball.by > ysp1 )
                {
                    ball.gradX = 1;
                    Lied.Button();
                }
                //Kollision Spieler Rechts und Ball
                if (ball.bx < xsp2 && ball.bx + ball.radius > xsp2 && ball.by+ball.radius < ysp2 + 120  && ball.by > ysp2 )
                {
                    ball.gradX = -1;
                    Lied.Button();
                }
                //zur Bewegung Hochgesetze x und y Werte des Balles
                ball.bx += ball.gradX;
                ball.by += ball.gradY;
            }
        }, 0, 4);

    }

    //Keylistener
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Beschreibt was passieren soll, wenn die Tastatur bedient wird.
    @Override
    public void keyPressed(KeyEvent e) {

        // Setzen der Bewegungsvariablen für Spieler1
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player1down = true;

        // Setzen der Bewegungsvariablen für Spieler2
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2down = true;
        }

    }

    //Beschreibt was passieren soll, wenn die Tasten wieder losgelassen werden.
    @Override
    public void keyReleased(KeyEvent e) {

        // Zurücksetzen der Bewegungsvariablen für Spieler1
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player1down = false;

        // Zurücksetzen der Bewegungsvariablen für Spieler2
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2down = false;
        }

    }

    //Zeichnung der verschiedenen Komponenten des Spiels
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Hintergrund
        g2d.setPaint(p);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);

        //Spieler 1 (links)
        g.fillRect(xsp1, ysp1, 14, 120);
        
        //Spieler 2 (rechts)
        g.fillRect(xsp2, ysp2, 14, 120);
        
        //Ball Farbe
        g.setColor(ball.farbe);
        //Ball Zeichnung
        g.fillOval((ball.bx- ball.radius ),(ball.by - ball.radius), 2 * ball.radius, 2 * ball.radius);

        repaint();

    }

}
