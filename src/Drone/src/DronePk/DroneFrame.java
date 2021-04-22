package DronePk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Frame che si occupa di contenere il panel dell'aplicazione.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class DroneFrame extends javax.swing.JFrame implements KeyListener, MouseListener {

    /**
     * Il costruttore della applicazione.
     */
    public DroneFrame() {
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comandiPanel1 = new DronePk.ComandiPanel();
        funzionePanel1 = new DronePk.FunzionePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(comandiPanel1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(funzionePanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DroneFrame df = new DroneFrame();
                df.setVisible(true);
                df.getFunzionePanel().setComandiPanel(df.getComandiPanel());
                Drone drone = df.getFunzionePanel().getDrone();
                df.getComandiPanel().setDrone(drone);
                df.setSize(800, 600);
                df.setFocusable(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DronePk.ComandiPanel comandiPanel1;
    private DronePk.FunzionePanel funzionePanel1;
    // End of variables declaration//GEN-END:variables

    public FunzionePanel getFunzionePanel() {
        return funzionePanel1;
    }

    public ComandiPanel getComandiPanel() {
        return comandiPanel1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        comandiPanel1.keyTypedC(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        comandiPanel1.keyPressedC(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        comandiPanel1.keyReleasedC(e);
    }
    
    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isFocusTraversable();
        this.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
