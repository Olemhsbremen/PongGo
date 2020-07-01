/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ole Middendorf
 */


public class StartPanel extends JPanel {

    CardLayout c1;
    JButton btn1 = new JButton();
    BufferedImage image;

    public StartPanel(CardLayout c1) {
        
        
        JPanel jp = new JPanel();
        this.c1 = c1;
        
        //Einstellungen für den Button
        setLayout(null);
        btn1.setBackground(Color.white);
        btn1.setBounds(1, 1, 1, 1);
        add(btn1);
        
        //Bild wird gelesen und aufgerufen
        try {
            this.image = ImageIO.read(new File("Start.png"));
        } catch (IOException ex) {
            System.out.println("Hat nicht funktioniert");
        }
    }

    //Bild wird an das JPanel angepasst
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
