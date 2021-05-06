package DronePk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Panel che si occupa dei bottoni.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class FunzionePanel extends javax.swing.JPanel {

    /**
     * Istanziamento dell'oggetto drone.
     */
    private Drone drone;

    /**
     * Istanziamento dell'oggetto drone.
     */
    private Browser browser;

    /**
     * Istanza del leap motion.
     */
    private LeapMotionProject lm;

    /**
     * Contiene la classe per far eseguire la sequenza.
     */
    private CommandSequenceRunner csr;

    /**
     * Definisce se e' avviata una sequenza o meno.
     */
    private boolean started = false;

    /**
     * Creates new form FunzionePanel.
     */
    public FunzionePanel() {
        initComponents();
        browser = new Browser();
        drone = new Drone();
    }

    /**
     * Metodo che si occupa di impostare il Leap Motion.
     *
     * @param lm da impostare.
     */
    public void setLM(LeapMotionProject lm) {
        this.lm = lm;
    }

    /**
     * Metodo che si occupa di impostare il comandi panel.
     *
     * @param comandiPanel da impostare.
     */
    public void setComandiPanel(ComandiPanel comandiPanel) {
        drone.setComandiPanel(comandiPanel);
        drone.start();
        drone.command();
        caricamento();
    }

    /**
     * Coduce autogenerato da netbeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        seqNameSave = new javax.swing.JTextField();
        sequenzaTasti = new javax.swing.JButton();
        seqNameExecute = new javax.swing.JTextField();
        vistaDrone = new javax.swing.JButton();
        batteriaText = new javax.swing.JLabel();
        batteriaL = new javax.swing.JLabel();
        speedText = new javax.swing.JLabel();
        speedL = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Salva sequenza");
        add(jLabel1);

        seqNameSave.setText("Example");
        add(seqNameSave);

        sequenzaTasti.setText("Esegui sequenza");
        sequenzaTasti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequenzaTastiActionPerformed(evt);
            }
        });
        add(sequenzaTasti);

        seqNameExecute.setText("Example");
        add(seqNameExecute);

        vistaDrone.setText("Visualizza live");
        vistaDrone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vistaDroneMouseClicked(evt);
            }
        });
        vistaDrone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaDroneActionPerformed(evt);
            }
        });
        add(vistaDrone);

        batteriaText.setText("Batteria");
        add(batteriaText);

        batteriaL.setText("0%");
        add(batteriaL);

        speedText.setText("Velocità tastiera");
        add(speedText);

        speedL.setText("50%");
        add(speedL);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void vistaDroneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaDroneActionPerformed

    }//GEN-LAST:event_vistaDroneActionPerformed

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void sequenzaTastiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequenzaTastiActionPerformed
        if (!started) {
            csr = new CommandSequenceRunner(getSeqNameExecute(), drone);
            csr.start();
            started = true;
        }
    }//GEN-LAST:event_sequenzaTastiActionPerformed

    private void vistaDroneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vistaDroneMouseClicked
        try {
            browser.script();
            browser.openBrowser();
        } catch (IOException ex) {
            Logger.getLogger(FunzionePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vistaDroneMouseClicked

    /**
     * Ritorna il testo scritto nel textbox.
     *
     * @return testo
     */
    public String getSeqNameExecute() {
        String text = seqNameExecute.getText();
        if (text.isBlank()) {
            return "Example";
        } else {
            return text;
        }
    }

    /**
     * Ritorna il testo scritto nel textbox.
     *
     * @return testo
     */
    public String getSeqNameSave() {
        String text = seqNameSave.getText();
        if (text.isBlank()) {
            return "Example";
        } else {
            return text;
        }
    }

    /**
     * Metodo che si occupa di scrivere la percenutale della batteria.
     */
    private void caricamento() {
        try {
            Thread.sleep(300);
            batteriaL.setText(drone.batteria() + "%");
        } catch (InterruptedException ex) {
            Logger.getLogger(FunzionePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo utile ad aggiornare il comandiPanel.
     *
     * @param command da stampare
     */
    public void refreshCommandsF(String command) {
        drone.refreshCommandsD(command);
    }

    /**
     * Metodo utile a ritornare il drone impostato.
     *
     * @return drone impostato
     */
    public Drone getDrone() {
        return this.drone;
    }

    /**
     * Serve a scrivere la velocita' nel label.
     *
     * @param speed da scrivere
     */
    public void writeSpeed(int speed) {
        speedL.setText(speed + "%");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel batteriaL;
    private javax.swing.JLabel batteriaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField seqNameExecute;
    private javax.swing.JTextField seqNameSave;
    private javax.swing.JButton sequenzaTasti;
    private javax.swing.JLabel speedL;
    private javax.swing.JLabel speedText;
    private javax.swing.JButton vistaDrone;
    // End of variables declaration//GEN-END:variables
}
