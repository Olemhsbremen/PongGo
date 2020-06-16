/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pitpa
 */
public class StartPanel extends JPanel{
    
    CardLayout c1;
    JButton btn1 = new JButton();
    BufferedImage image;

    public StartPanel(CardLayout c1) {
        try {
            this.image = ImageIO.read(new File("Start.png"));
        } catch (IOException ex) {
            System.out.println("Hat nicht funktioniert");
        }

        JPanel jp = new JPanel();
        this.c1 = c1;
        
        
        setBackground(Color.red);

        setLayout(null);
        btn1.setText("press to start");
        btn1.setBackground(Color.white);
        btn1.setBounds(325, 330, 150, 20);
        add(btn1); 
    }
    
    
    //BufferedImage image = null;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //g.fillOval(0, 0, getWidth(), getHeight());
        //getWidth();
        //getHeight();
    }
}











//    public StartPanel() {
//        BufferedImage image = null;
//        File f = null;
//       try{
//            f = new File("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\PongGo");
//            image = ImageIO.read(f);
//        }catch(IOException e){
//            System.out.println("Error: "+e);
//        }
//    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
//    }
//    
//    public void main(String[] args) {
//        Properties prop = new Properties();
//        InputStream input = null;
//        try {
//            File f=new File("Start.png");
//            input = new FileInputStream(f.getPath());
//            prop.load(input);
//            System.out.println(prop.getProperty("Start"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (input != null) {
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//}
// 
