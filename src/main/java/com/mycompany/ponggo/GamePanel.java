/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 * @author JakobTheis
 */
public class GamePanel extends JPanel implements KeyListener {
    
    //Start Boolean des GamePanels
    private boolean gameStart = false;
    
    private boolean gameWinP1 = false;
    private boolean gameWinP2 = false;
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

    //Variablen für den Spielstand
    private int pointsplayer1 = 0;
    private int pointsplayer2 = 0;
    private Font schriftart;

    //Farbgradient für den Hintergrund des Gamepanels
    GradientPaint p = new GradientPaint(100, 100, new Color(202, 122, 42), 800, 30, new Color(111, 58, 6));

    public GamePanel(CardLayout c1) throws FontFormatException {
        
        
        

        this.c1 = c1;
        setLayout(null);
        addKeyListener(this);

        try {
            //Schriftart des Spielstandes
            schriftart = Font.createFont(Font.TRUETYPE_FONT, new File("Schrift.ttf")).deriveFont(45f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Schrift.ttf")));
        } catch (IOException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Ball mit definierten Parametern
        ball = new Sball(Color.white, 400, 350, 12, 1);

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

                updateBallPhysics();
            }
        }, 100, 3);

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
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            gameStart = true;
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

        //Spielstand
        g.setFont(schriftart);
        g.drawString("" + pointsplayer1, getWidth() / 2 - 80, 65);
        g.drawString("" + pointsplayer2, getWidth() / 2 + 40, 65);
        if(gameWinP1){
            g.drawString("Spieler 1 Gewinnt", getWidth()-615, (getHeight()/3) * 2);   
        }
        else{
            g.fillOval((ball.bx - ball.radius/2), +(ball.by - ball.radius/2), 2 * ball.radius, 2 * ball.radius);
        }
        if(gameWinP2){
            g.drawString("Spieler 2 Gewinnt", getWidth()-615, (getHeight()/3) * 2);
        }
        else{
            g.fillOval((ball.bx - ball.radius/2), +(ball.by - ball.radius/2), 2 * ball.radius, 2 * ball.radius);
        }
        repaint();

    }

    private void updateBallPhysics(){
                Sound Lied = new Sound();
                
                if (gameWinP1||gameWinP2){
                    gameStart = false;
                    move.cancel();
                    move.purge();
                }
                
                else {
                
                //Ballbewegung und Kollisions Erkennung
                // Wechsel der Richtung Obere Wand
                if (ball.by - ball.radius <= 0) {
                    ball.gradY = 1;
                }
                // Wechsel der Richtung Untere Wand
                if (ball.by + ball.radius > getHeight()) {
                    ball.gradY = -1;
                }
                // "Neustart" Fehler Spieler rechts
                if (ball.bx >= getWidth()) {
                    ball.bx = (getWidth()) / 2 - ball.radius;
                    ball.by = (getHeight()) / 2 - ball.radius;
                    Lied.FehlerButton();
                    if (pointsplayer1 < 4) {
                        pointsplayer1+=1;
                        ball.gradX = -1;
                    }
                    else{
                        pointsplayer1+=1;
                        gameWinP1 = true;
                    }
                    // "Neustart" Fehler Spieler links
                }
                if (ball.bx <= 0) {
                    ball.bx = (getWidth()) / 2 - ball.radius;
                    ball.by = (getHeight()) / 2 - ball.radius;
                    Lied.FehlerButton();
                    if (pointsplayer2 < 4) {
                        pointsplayer2+=1;
                        ball.gradX = 1;
                    }
                    else{
                        pointsplayer2+=1;
                        gameWinP2 = true;
                    }
                    

                }
                //Kollision Spieler Links und Ball
                if (ball.bx < xsp1 + 24 && ball.bx > xsp1 && ball.by < ysp1 + 120 && ball.by > ysp1) {
                    ball.gradX = 1;
                    Lied.Button();
                }
                //Kollision Spieler Rechts und Ball
                if (ball.bx < xsp2 && ball.bx + ball.radius > xsp2 && ball.by + ball.radius < ysp2 + 120 && ball.by > ysp2) {
                    ball.gradX = -1;
                    Lied.Button();
                }
                //zur Bewegung Hochgesetze x und y Werte des Balles
                if(gameStart) {
                    ball.bx += ball.gradX;
                    ball.by += ball.gradY;
                }
                }
    }
            
            
    public void setGameStart(boolean value){
        
        this.gameStart = value;
        
    }
}
