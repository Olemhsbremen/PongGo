/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
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

    CardLayout c1;

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

    //Timer für die Bewegung der beiden SpielerS
    Timer move;

    public GamePanel(CardLayout c1) {

        this.c1 = c1;

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
        g.setColor(new Color(67, 181, 189));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);

        //Spieler 1 (links)
        g.fillRect(xsp1, ysp1, 14, 120);
        
        //Spieler 2 (rechts)
        g.fillRect(xsp2, ysp2, 14, 120);

        repaint();

    }

}
