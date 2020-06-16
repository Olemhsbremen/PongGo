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
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class GamePanel extends JPanel implements KeyListener {

    CardLayout c1;

    public boolean moveup = false;
    public boolean movedown = false;
    
    public int x = 20;
    public int y = 300;

    public GamePanel(CardLayout c1) {

        this.c1 = c1;

        setLayout(null);
        setSize(800, 700);
        addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("hello world");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("goodbye world");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(new Color(67, 181, 189));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.white);
        g.fillRect(x, y, 10, 100);
    }

}
