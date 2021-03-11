/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class Drone {
    
    private int altitude;
    private int height;
    private int width;
    
    
    Drone(int height,int width){
        this.altitude=0;
        this.height = height;
        this.width = width;
    }
    
     Drone(int height,int width, int altitude){
        this.altitude=altitude;
        this.height = height;
        this.width = width;
    }
    
    public void setAltitude(int altitude){
        System.out.println("Drone set altitude");
        this.altitude=altitude;
    }
    
    public int getAltitude(){
        return this.altitude;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    
}
