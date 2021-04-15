package DronePk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Frame che si occupa di contenere il panel dell'aplicazione.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class DroneFrame extends javax.swing.JFrame implements KeyListener {

    /**
     * Il costruttore della applicazione.
     */
    public DroneFrame() {
        initComponents();
        this.addKeyListener(this);
    }
    
    private Drone drone;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comandiPanel1 = new DronePk.ComandiPanel();
        funzionePanel1 = new DronePk.FunzionePanel();
        livePanel = new DronePk.LivePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(comandiPanel1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(funzionePanel1, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout livePanelLayout = new javax.swing.GroupLayout(livePanel);
        livePanel.setLayout(livePanelLayout);
        livePanelLayout.setHorizontalGroup(
            livePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
        livePanelLayout.setVerticalGroup(
            livePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        getContentPane().add(livePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DroneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DroneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DroneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DroneFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DroneFrame df = new DroneFrame();
                df.setVisible(true);
                df.getFunzionePanel().setComandiPanel(df.getComandiPanel());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DronePk.ComandiPanel comandiPanel1;
    private DronePk.FunzionePanel funzionePanel1;
    private DronePk.LivePanel livePanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
       drone.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
       drone.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       drone.keyReleased(e);
    }

    public FunzionePanel getFunzionePanel() {
        return funzionePanel1;
    }

    public ComandiPanel getComandiPanel() {
        return comandiPanel1;
    }

    
}
