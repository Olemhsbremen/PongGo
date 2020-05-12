/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class StartPanel extends JPanel{
    
    CardLayout c1;
    JButton btn1 = new JButton();

    public StartPanel(CardLayout c1) {

        this.c1 = c1;
        
        setBackground(Color.red);

        setLayout(null);
        btn1.setText("press to start");
        btn1.setBackground(Color.ORANGE);
        btn1.setBounds(300, 290, 140, 20);

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello world");

            }
        });

        add(btn1);
        
        
        
    }
    
}
