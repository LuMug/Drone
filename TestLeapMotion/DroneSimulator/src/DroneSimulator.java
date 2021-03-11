/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author luca
 */
public class DroneSimulator{

    public static void main(String[] args){

        Cockpit cockpit = new Cockpit();
        Thread tCockpit = new Thread(cockpit);
        tCockpit.start();
        
        UDPReceiver receiver = new UDPReceiver(cockpit);
        Thread tReceiver = new Thread(receiver);

        tReceiver.start();


        System.out.println("Press Enter to quit...");
        try {
        System.in.read();
        } catch (IOException e) {
        e.printStackTrace();
        }
            
    }
    
}

