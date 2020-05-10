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
    
    JFrame jf1 = new JFrame();
    JPanel jp0 = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JButton btn1 = new JButton();
    CardLayout c1 = new CardLayout();
    
    public int screenwidth = 1000;
    public int screenheight = 800;
    
    
    public GUI() {
                
        jp0.setLayout(c1);
        
        jp1.add(btn1);
        jp1.setBackground(Color.red);
        jp1.setSize(screenwidth, screenheight);
        
        jp2.setBackground(Color.green);
        jp2.setSize(screenwidth, screenheight);
        
        jp0.add(jp1, "1");
        jp0.add(jp2, "2");
        
        c1.show(jp0, "1");
        
        
        jf1.setSize(screenwidth, screenheight);
        jf1.setTitle("PonGO!");
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf1.setResizable(true);
        jf1.setLocationRelativeTo(null);
        jf1.add(jp0);
        jf1.setVisible(true);
        
        
        
    }
    
}
