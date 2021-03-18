

/**
 * Panel che si occupa dei bottoni.
 * 
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class FunzionePanel extends javax.swing.JPanel {

    /**
     * Creates new form FunzionePanel
     */
    public FunzionePanel() {
        initComponents();
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
        spazio = new javax.swing.JSeparator();
        velocitàText = new javax.swing.JLabel();
        velocitàCampo = new javax.swing.JTextField();
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

        spazio.setForeground(new java.awt.Color(255, 255, 255));
        spazio.setPreferredSize(new java.awt.Dimension(100, 10));
        add(spazio);

        velocitàText.setText("Batteria");
        add(velocitàText);

        velocitàCampo.setText("             ");
        add(velocitàCampo);

        percentuale.setText("%");
        add(percentuale);
    }// </editor-fold>//GEN-END:initComponents

    private void vistaDroneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistaDroneActionPerformed
        ImageFrame vista = new ImageFrame();
        vista.setVisible(true);
    }//GEN-LAST:event_vistaDroneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Statistiche;
    private javax.swing.JLabel percentuale;
    private javax.swing.JButton sequenzaTasti;
    private javax.swing.JSeparator spazio;
    private javax.swing.JTextField velocitàCampo;
    private javax.swing.JLabel velocitàText;
    private javax.swing.JButton vistaDrone;
    // End of variables declaration//GEN-END:variables
}
