package ImageFrame;

import DronePk.Drone;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Frame principale dell'intero package Questo frame si occupa di contenre i 4
 * panel con le info del drone.
 *
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImageFrame extends JPanel implements Runnable {

    
    /**
     * Il riferimento al pannello "imagePanelFront".
     */
    private ImagePanelFront imagePanelFront;
    
    /**
     * Il riferimento al pannello "imagePanelLat".
     */
    private ImagePanelLat imagePanelLat;
    
    /**
     * Il riferimento al pannello "imagePanelUp".
     */
    private ImagePanelUp imagePanelUp;
    
    /**
     * Il riferimento al pannello "imagePanelAlt".
     */
    private ImagePanelAlt imagePanelAlt;

    /**
     * Valore del beccheggio.
     */
    private static volatile int pitch;
    
    /**
     * Valore dell'imbardata.
     */
    private static volatile int yaw;
    
    /**
     * Valore del rollio.
     */
    private static volatile int roll;
    
    /**
     * Valore dell'altitudine.
     */
    private static volatile int alt;

    /**
     * Riferiemnto al drone.
     */
    private Drone drone;
    
    /**
     * Metodo costruttore.
     */
    public ImageFrame() {
        initComponents();
    }

    
     /**
     * Questo metodo inizializza tutti i componenti:
     * Imposta la dimensione del Frame, istanzia e aggiunge i pannelli 
     * al frame 
     */
    private void initComponents() {
        GridLayout ImageFrameLayout = new GridLayout(2, 2);
        setLayout(ImageFrameLayout);
        imagePanelFront = new ImagePanelFront();
        imagePanelLat = new ImagePanelLat();
        imagePanelUp = new ImagePanelUp();
        imagePanelAlt = new ImagePanelAlt();
        add(imagePanelLat);
        add(imagePanelUp);
        add(imagePanelFront);
        add(imagePanelAlt);
    }
    


    /**
     * Setter dell'altitudine, richiamato da DronePk.Status
     * @param statAlt è il valore dell'altitudine.
     */
    public void setAlt(int statAlt) {
        alt = statAlt;
    }

    /**
     * Setter del beccheggio, richiamato da DronePk.Status
     * @param statPitch è il valore del beccheggio.
     */
    public void setPitch(int statPitch) {
        pitch = statPitch;
    }

    /**
     * Setter del rolllio, richiamato da DronePk.Status
     * @param statRoll è il valore del rollio.
     */
    public void setRoll(int statRoll) {
        roll = statRoll;
    }
    
    /**
     * Setter dell'imbardata, richiamato da DronePk.Status
     * @param statYaw è il valore dell'imbardata.
     */
    public void setYaw(int statYaw) {
        yaw = statYaw;
    }

    /**
     * Questo metodo, o Thread, permette di aggiornare i vari pannelli
     * presenti nel frame.
     * Dopo aver ottenuto i valori dai setter, esegue i metodi
     * predisposti per il movimento passando il valore adeguato.
     */
    public void run() {
        while(true){
            imagePanelFront.moving(roll);
            imagePanelLat.moving(pitch);
            imagePanelAlt.setAltitude(alt);
            imagePanelUp.deg = yaw;
            imagePanelUp.validate();
            imagePanelUp.repaint(); 
        }
    }
}
