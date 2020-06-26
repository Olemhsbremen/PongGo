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
    Sound Lied = new Sound();

    
    //Variablen für die Größe des JFrames
    public int screenwidth = 800;
    public int screenheight = 700;

    public GUI() {
        Lied.Background("src\\main\\java\\Lieder\\Stayin_Alive.wav");
     
        
        setSize(screenwidth, screenheight);
        setTitle("PonGO!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(c1);
        
        //Hinzufügen des StartPanles
        add(jp1, "1");
        jp1.btn1.addActionListener(new ActionListener() {
            
            //Action Listener für den Wechsel auf das GamePanel
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== jp1.btn1) {
                    Lied.Button();
                }
                c1.next(getContentPane());
                jp2.requestFocusInWindow();
                jp2.setGameStart(true);
            }
        });
        
        //Hinzufügen des GamePanels
        add(jp2, "2");

        setVisible(true);

    }
    
}
