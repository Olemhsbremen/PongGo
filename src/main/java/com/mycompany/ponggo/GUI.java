/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author pitpa
 */
public class GUI extends JFrame {

    CardLayout c1 = new CardLayout();
    StartPanel jp1 = new StartPanel(c1);
    GamePanel jp2 = new GamePanel(c1);

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
                jp2.requestFocusInWindow();
            }
        });

        add(jp2, "2");

        setVisible(true);

    }

}
