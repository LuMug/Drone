package ImageFrame;

import DronePk.Status;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Frame principale dell'intero package Questo frame si occupa di contenre i 4
 * frame con le info del drone.
 *
 * @author Michea Colautti
 * @version 25.03.21
 */
public class ImageFrame extends JFrame implements KeyListener {

    private ImagePanelFront imagePanelFront;
    private ImagePanelLat imagePanelLat;
    private ImagePanelUp imagePanelUp;
    private Altitudine altitudine;
    public Status stat = new Status();

    private int pitch;
    private int yaw;
    private int roll;
    private int alt;

    public ImageFrame() {
        addKeyListener((KeyListener) this);
        initComponents();
        obt();
    }

    public void obt() {
        while (true) {
            pitch = stat.getPitch();
            roll = stat.getRoll();
            yaw = stat.getYaw();
            alt = stat.getAlt();
            
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageFrame().setVisible(true);

            }
        });
    }

    private void initComponents() {

        setMinimumSize(new Dimension(700, 500));
        setMaximumSize(new Dimension(700, 500));
        GridLayout ImageFrameLayout = new GridLayout(2, 2);
        setLayout(ImageFrameLayout);
        setResizable(false);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //view();
        imagePanelFront = new ImagePanelFront();
        imagePanelLat = new ImagePanelLat();
        imagePanelUp = new ImagePanelUp();
        altitudine = new Altitudine();
        add(imagePanelLat);
        add(imagePanelUp);
        add(imagePanelFront);
        add(altitudine);
        pack();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*    int type = e.getKeyCode();
        if(type==68 || type==65){
            imagePanelFront.keyPressed(e);
        }
        if(type==87 || type==83){
            imagePanelLat.keyPressed(e);
        }
        if(type==37 || type==39){
            imagePanelUp.keyPressed(e);
        }
        if(type==38 || type==40){
            altitudine.keyPressed(e);
        }*/

    }

    @Override
    public void keyReleased(KeyEvent e) {
        /*    int type = e.getKeyCode();
        if(type==68 || type==65){
            imagePanelFront.keyReleased(e);
        } 
        if(type==87 || type==83){
            imagePanelLat.keyReleased(e);
        }*/
    }

    public void keyTyped(KeyEvent e) {
    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }
}
