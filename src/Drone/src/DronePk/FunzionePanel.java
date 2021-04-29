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
            if(drone.batteria().isBlank()) {
                batteriaL.setText("0%");
            }else{
                batteriaL.setText(drone.batteria() + "%");
            }
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
    private javax.swing.JLabel batteriaL;
    private javax.swing.JLabel batteriaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField seqNameExecute;
    private javax.swing.JTextField seqNameSave;
    private javax.swing.JButton sequenzaTasti;
    private javax.swing.JButton vistaDrone;
    // End of variables declaration//GEN-END:variables
}
