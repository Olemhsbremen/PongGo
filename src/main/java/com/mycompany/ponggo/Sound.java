/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ponggo;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Lenovo
 */
public class Sound {
    
    double gain;
    Clip clip;
    FloatControl gainControl;
    
    /*public void music (String musicLocation){
        try {
            File musicPath = new File(musicLocation);
            
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                Ton (25);
            } else {
                System.out.println("Hat nicht geklappt");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void Ton(int ton){
        gain = ton/100.d;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
    
    public void stopp(){
        try {
            clip.stop();
        } catch (Exception ex) {
            System.out.println("Nicht gestoppt");
        }
    }
    
    public void weiter(){
        try {
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Nicht gestoppt 2");
        }
    }*/

    public void Background(String track) {
        final String trackname = track;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputstream = AudioSystem.getAudioInputStream(new File(trackname));
                        clip.open(inputstream);
                        clip.loop(clip.LOOP_CONTINUOUSLY);
                        Thread.sleep(clip.getMicrosecondLength() / 1000);
                        Volume(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    
    public void Volume(int ton){
        gain = ton/100.d;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
    
    
    public void Button() {
        File sound;
        float value;
        Clip clip;
        
        sound = new File("src\\main\\java\\Lieder\\Knopf.wav");
        value = -10;

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception ex) {
            System.out.println("Audio nicht abgespielt");
        }
        
    }
    
    public void FehlerButton() {
        File sound;
        float value;
        Clip clip;
        
        sound = new File("src\\main\\java\\Lieder\\Wandsound.wav");
        value = -10;

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        } catch (Exception ex) {
            System.out.println("Audio nicht abgespielt");
        }
        
    }
}