/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Ole Middendorf
 */
public class Sound {
    
    //Hintergrundmusik wird gelesen, kontinuierlich wiederholt und in der GUI aufgerufen
    public void Background() {
        
        File sound;
        sound = new File("src\\main\\java\\Lieder\\Stayin_Alive.wav");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputstream = AudioSystem.getAudioInputStream(sound);
                        clip.open(inputstream);
                        clip.loop(clip.LOOP_CONTINUOUSLY);
                        Thread.sleep(clip.getMicrosecondLength() / 1000);  
                                // auch mit Thread.sleep(231000); möglich

                    } catch (Exception e) {
                        System.out.println("Hintergrundmusik läuft nicht");
                    }
            }
        }).start();
    }
    
    //Sound für den Knopf wird gelesen und dann in dem AktionListener eingefügt
    public void Button() {
        
        File sound;
        sound = new File("src\\main\\java\\Lieder\\Knopf.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception ex) {
            System.out.println("Audio nicht abgespielt");
        }
        
    }
    
    /*Sound für die Kollision des Balls mit den gegenüberliegenden Wänden
        und dann im Gamepanel passend eingefügt*/
    public void FehlerButton() {
        
        File sound;
        sound = new File("src\\main\\java\\Lieder\\Wandsound.wav");

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception ex) {
            System.out.println("Audio nicht abgespielt");
        }
        
    }
}