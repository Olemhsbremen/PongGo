/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class SecondPanel extends JPanel{
    
    CardLayout c1;
    JButton btn2 = new JButton();
    
    public SecondPanel(CardLayout c1) {
        
        this.c1 = c1;
        setBackground(Color.blue);      
        
        setLayout(null);
        btn2.setText("zum Spiel");
        btn2.setBackground(Color.white);
        btn2.setBounds(325, 330, 150, 20);
        add(btn2);
    }
    
}
