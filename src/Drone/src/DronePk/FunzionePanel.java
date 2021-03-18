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
     * Creates new form FunzionePanel
     */
    public FunzionePanel() {
        initComponents();
        drone = new Drone(this);
        drone.start();
        drone.command();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sequenzaTasti = new javax.swing.JButton();
        Statistiche = new javax.swing.JButton();
        vistaDrone = new javax.swing.JButton();
        decolla = new javax.swing.JButton();
        atterra = new javax.swing.JButton();
        spazio = new javax.swing.JSeparator();
        batteriaText = new javax.swing.JLabel();
        batteriaCampo = new javax.swing.JTextField();
        percentuale = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        sequenzaTasti.setText("SEQUENZA COMANDI");
        add(sequenzaTasti);

        Statistiche.setText("STATISTICHE");
        add(Statistiche);

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

        spazio.setForeground(new java.awt.Color(255, 255, 255));
        spazio.setPreferredSize(new java.awt.Dimension(100, 10));
        add(spazio);

        batteriaText.setText("Batteria");
        add(batteriaText);

        batteriaCampo.setText("             ");
        add(batteriaCampo);

        percentuale.setText("%");
        add(percentuale);
    }// </editor-fold>//GEN-END:initComponents

    private void vistaDroneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaDroneActionPerformed
        ImageFrame vista = new ImageFrame();
        vista.setVisible(true);
        batteriaCampo.setText(drone.batteria());
    }//GEN-LAST:event_vistaDroneActionPerformed

    private void decollaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaActionPerformed
       drone.decolla();
    }//GEN-LAST:event_decollaActionPerformed

    private void atterraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atterraActionPerformed
     drone.atterra();
    }//GEN-LAST:event_atterraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Statistiche;
    private javax.swing.JButton atterra;
    private javax.swing.JTextField batteriaCampo;
    private javax.swing.JLabel batteriaText;
    private javax.swing.JButton decolla;
    private javax.swing.JLabel percentuale;
    private javax.swing.JButton sequenzaTasti;
    private javax.swing.JSeparator spazio;
    private javax.swing.JButton vistaDrone;
    // End of variables declaration//GEN-END:variables
}
