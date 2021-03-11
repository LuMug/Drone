
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class Cockpit extends JPanel implements Runnable, CommandListener {
    
    
    private int ground = 50;
    Drone drone = new Drone(1,32);
    

    
    public void setAltitude(int altitude){
        drone.setAltitude(altitude);
    }
    
    public void paint(Graphics g){
        //g.drawLine(10, 10, 200, 300);	
        paintGround(g);
        paintDrone(g, 600-drone.getAltitude()-ground-1);
        System.out.println("Paint...");
    }
    
    public void paintGround(Graphics g){
        g.drawLine(10, 600-ground, 590, 600-ground);
    }
    
    public void paintDrone(Graphics g, int height){
        System.out.println("Drawing drone:" + drone.getHeight() + "|"+drone.getWidth()+"|"+drone.getAltitude());
        g.drawRect((600/2)-(drone.getWidth()/2), height, drone.getWidth(), drone.getHeight());
             
    }

    public void run() {
        JFrame frame= new JFrame("Welecome to JavaTutorial.net");	
        frame.getContentPane().add(new Cockpit());
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);	

        /*System.out.println("Press Enter to quit...");
        try {
        System.in.read();
        } catch (IOException e) {
        e.printStackTrace();
        }*/
            
    }

    @Override
    public void commandReceived(int x) {
        drone.setAltitude(x);
        System.out.println("Repaint...drone:"+drone.getAltitude());
        this.repaint();
    }
}
