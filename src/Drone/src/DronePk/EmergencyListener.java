package DronePk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe che si occupa dell'atterraggio di emergenza.
 * @author Samuele Ganci
 * @version 06 maggio 2021
 */
public class EmergencyListener implements KeyListener {
    
    /**
     * Contiene il riferimento del drone.
     */
    private Drone drone;
    
    /**
     * Viene ricihamato quando un tasto della tastiera viene premuto e rilasciato.
     * @param e variabile di sistema contenente le informazioni dell'evento
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Viene ricihamato quando un tasto della tastiera viene premuto.
     * @param e variabile di sistema contenente le informazioni dell'evento
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getExtendedKeyCode() == 10) {
            drone.invioMessaggio("emergency");
        }
        if(e.getExtendedKeyCode() == 32) {
            drone.invioMessaggio("rc 0 0 0 0");
        }
    }

    /**
     * Viene ricihamato quando un tasto della tastiera viene rilasciato.
     * @param e variabile di sistema contenente le informazioni dell'evento
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getExtendedKeyCode() == 10 || e.getExtendedKeyCode() == 32) {
            drone.invioMessaggio("rc 0 0 0 0");
        }
    }
    
    /**
     * Serve ad impostare il drone.
     * @param drone da impostare
     */
    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
