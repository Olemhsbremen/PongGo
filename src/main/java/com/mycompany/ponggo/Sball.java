/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jakob Theis
 */

public class Sball
{
    public int bx;
    public int by;
    public int radius ;
    public int bges ;
    public int gradX ;
    public int gradY ;
    public Color farbe;
    
    public Sball(Color a, int x, int y, int z, int grad)
    {
        farbe = a;
        bx = x;
        by = y;
        radius = z;
        gradX = grad;
        gradY = grad;

    }
        
    public void paint(Graphics g)
    {
        g.setColor(farbe);
        g.fillOval((bx - radius),(by - radius), 2 * radius, 2 * radius);
            
    }
}
    

