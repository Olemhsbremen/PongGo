/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class SecondPanel extends JPanel{
    
    CardLayout c1;
    
    public SecondPanel(CardLayout c1) {
        
        this.c1 = c1;
        setBackground(Color.blue);      
    }
    
}
