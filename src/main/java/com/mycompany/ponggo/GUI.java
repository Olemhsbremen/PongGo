/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class GUI extends JFrame {
    
    CardLayout c1 = new CardLayout();
    StartPanel jp1 = new StartPanel(c1);
    SecondPanel jp2 = new SecondPanel(c1);
    
    public int screenwidth = 1000;
    public int screenheight = 800;
    
    public GUI() {
                        
        setSize(screenwidth, screenheight);
        setTitle("PonGO!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(c1);
        
        add(jp1, "start");
        add(jp2, "second");
        
        
        
        setVisible(true);
                   
    }
    
}
