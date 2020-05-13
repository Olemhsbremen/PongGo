/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    GamePanel jp3 = new GamePanel(c1);
    
    public int screenwidth = 800;
    public int screenheight = 700;
    
    public GUI() {
        
        setSize(screenwidth, screenheight);
        setTitle("PonGO!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(c1);

        add(jp1, "1");
        jp1.btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c1.next(getContentPane());
            }
        });

        add(jp2, "2");
        jp2.btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c1.next(getContentPane());
            }
        });
        
        add(jp3, "3");

        setVisible(true);

    }
    
}
