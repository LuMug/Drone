package DronePk;

import ImageFrame.ImageFrame;

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
     * Istanza del leap motion.
     */
    private LeapMotionProject lm;

    ImageFrame vista = new ImageFrame();

    /**
     * Creates new form FunzionePanel.
     */
    public FunzionePanel() {
        initComponents();
        drone = new Drone(this);
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
        decolla = new javax.swing.JButton();
        atterra = new javax.swing.JButton();
        batteriaText = new javax.swing.JLabel();
        batteriaL = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Salva sequenza");
        add(jLabel1);

        seqNameSave.setText("EXAMPLE");
        add(seqNameSave);

        sequenzaTasti.setText("ESEGUI SEQUENZA");
        sequenzaTasti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequenzaTastiActionPerformed(evt);
            }
        });
        add(sequenzaTasti);

        seqNameExecute.setText("EXAMPLE");
        add(seqNameExecute);

        vistaDrone.setText("VISTA DRONE");
        vistaDrone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistaDroneActionPerformed(evt);
            }
        });
        add(vistaDrone);

        decolla.setText("DECOLLA");
        decolla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decollaActionPerformed(evt);
            }
        });
        add(decolla);

        atterra.setText("ATTERA");
        atterra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atterraActionPerformed(evt);
            }
        });
        add(atterra);

        batteriaText.setText("Batteria");
        add(batteriaText);

        batteriaL.setText("          ");
        add(batteriaL);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void vistaDroneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaDroneActionPerformed
        vista.setVisible(true);
        vista.imgTh = true;
        Thread vistaThread = new Thread(vista);
        vistaThread.start();
    }//GEN-LAST:event_vistaDroneActionPerformed

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void decollaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaActionPerformed
        drone.decolla();
    }//GEN-LAST:event_decollaActionPerformed

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void atterraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atterraActionPerformed
        drone.atterra();
    }//GEN-LAST:event_atterraActionPerformed

    /**
     * Richiamato quando viene premuto il pulsante associato.
     *
     * @param evt variabile contenente le info dell'evento
     */
    private void sequenzaTastiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequenzaTastiActionPerformed
        lm.runSequence();
    }//GEN-LAST:event_sequenzaTastiActionPerformed

    /**
     * Ritorna il testo scritto nel textbox.
     *
     * @return testo
     */
    public String getSeqNameExecute() {
        String text = seqNameExecute.getText();
        if (text.equals("")) {
            return "EXAMPLE";
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
        if (text.equals("")) {
            return "EXAMPLE";
        } else {
            return text;
        }
    }

    /**
     * Metodo che si occupa di scrivere la percenutale della batteria.
     */
    private void caricamento() {
        try {
            Thread.sleep(2000);
            batteriaL.setText(drone.batteria() + "%");
        } catch (InterruptedException e) {
            System.out.println(e);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atterra;
    private javax.swing.JLabel batteriaL;
    private javax.swing.JLabel batteriaText;
    private javax.swing.JButton decolla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField seqNameExecute;
    private javax.swing.JTextField seqNameSave;
    private javax.swing.JButton sequenzaTasti;
    private javax.swing.JButton vistaDrone;
    // End of variables declaration//GEN-END:variables
}
