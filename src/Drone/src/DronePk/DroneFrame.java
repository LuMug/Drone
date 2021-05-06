package DronePk;

import ImageFrame.ImageFrame;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Frame che si occupa di contenere il panel dell'aplicazione.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class DroneFrame extends javax.swing.JFrame implements KeyListener, MouseListener, ComponentListener {

    /**
     * Contiene il frame delle statistiche.
     */
    private ImageFrame vista;

    /**
     * Il costruttore della applicazione.
     */
    public DroneFrame() {
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.addMouseListener(this);
        this.requestFocus();
        vista = new ImageFrame();
        add(vista);
        vista.setVisible(true);
        vista.imgTh = true;
        Thread vistaThread = new Thread(vista);
        vistaThread.start();
        this.setMinimumSize(new Dimension(800, 400));
        getContentPane().addComponentListener(this);

    }

    /**
     * Codice autogenerato di netbeans.
     */
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

    /**
     * Ritorna il funzioni panel impostato.
     *
     * @return funzioni panel impostato.
     */
    public FunzionePanel getFunzionePanel() {
        return funzionePanel1;
    }

    /**
     * Ritorna il comandi panel impostato.
     *
     * @return comandi panel impostato.
     */
    public ComandiPanel getComandiPanel() {
        return comandiPanel1;
    }

    /**
     * Richiamato quando un pulsante viene premuto e rilasciato.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void keyTyped(KeyEvent e) {
        comandiPanel1.keyTypedC(e);
    }

    /**
     * Richiamato quando un pulsante viene premuto.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void keyPressed(KeyEvent e) {
        comandiPanel1.keyPressedC(e);
    }

    /**
     * Richiamato quando un pulsante viene rilasciato.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void keyReleased(KeyEvent e) {
        comandiPanel1.keyReleasedC(e);
    }

    /**
     * Serve a settare il focus sul frame.
     *
     * @return cio' che si ha settato
     */
    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    /**
     * Richiamato quando un tasto del mouse viene premuto e rilasciato.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        isFocusTraversable();
        this.requestFocus();
    }

    /**
     * Richiamato quando un tasto del mouse viene premuto.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Richiamato quando un tasto del mouse viene rilasciato.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Richiamato quando il mouse entra nel frame.
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Richiamato quando il mouse esce dal frame
     *
     * @param e variabile contenente le info dell'evento
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DronePk.ComandiPanel comandiPanel1;
    private DronePk.FunzionePanel funzionePanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentResized(ComponentEvent e) {
        if(getWidth()<800 && getHeight()<500){
            this.setResizable(false);
           
        }else{
            this.setResizable(true);
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentHidden(ComponentEvent e) {}

}
