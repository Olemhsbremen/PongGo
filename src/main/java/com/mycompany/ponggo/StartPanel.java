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
 * @author pitpa
 */
public class StartPanel extends JPanel {

    CardLayout c1;
    JButton btn1 = new JButton();
    BufferedImage image;

    public StartPanel(CardLayout c1) {

        try {
            this.image = ImageIO.read(new File("Start.png"));
        } catch (IOException ex) {
            System.out.println("Hat nicht funktioniert");
        }

        JPanel jp = new JPanel();
        this.c1 = c1;

        setBackground(Color.red);

        setLayout(null);
        btn1.setText("press to start");
        btn1.setBackground(Color.white);
        btn1.setBounds(1, 1, 1, 1);
        add(btn1);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

}
