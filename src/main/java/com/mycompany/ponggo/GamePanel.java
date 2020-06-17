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

    public boolean moveup = false;
    public boolean movedown = false;
    public boolean gmoveup = false;
    public boolean gmovedown = false;

    public int x = 20;
    public int y = 300;

    public int gx = 755;
    public int gy = 300;

    Timer move;

    public GamePanel(CardLayout c1) {

        this.c1 = c1;

        setLayout(null);
        setSize(800, 700);
        addKeyListener(this);

        move = new Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (moveup == true) {

                    if (y >= 20) {
                        y -= 2;
                    }

                } else if (movedown == true) {

                    if (y <= getWidth() - 255) {
                        y += 2;
                    }
                }

                if (gmoveup == true) {

                    if (gy >= 20) {
                        gy -= 2;
                    }

                } else if (gmovedown == true) {

                    if (gy <= getWidth() - 255) {
                        gy += 2;
                    }
                }

            }
        }, 0, 6);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveup = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            movedown = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            gmoveup = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gmovedown = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveup = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            movedown = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            gmoveup = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gmovedown = false;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Hintergrund
        g.setColor(new Color(67, 181, 189));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.white);

        //Spieler links
        g.fillRect(x, y, 13, 120);
        //Spieler rechts
        g.fillRect(gx, gy, 13, 120);

        repaint();

    }

}
