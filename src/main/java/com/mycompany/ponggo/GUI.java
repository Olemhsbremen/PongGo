/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class GUI extends JFrame {
    
    JFrame jf1 = new JFrame();
    StartPanel jp1 = new StartPanel();
    CardLayout c1 = new CardLayout();
    
    public int screenwidth = 1000;
    public int screenheight = 800;
    
    
    public GUI() {
        
        jf1.setSize(screenwidth, screenheight);
        jf1.setTitle("PonGO!");
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setLayout(c1);
        jf1.setResizable(true);
        jf1.setLocationRelativeTo(null);
        jf1.setVisible(true); 
        
    }
    
}
