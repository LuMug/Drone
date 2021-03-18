/**
 * Panel che si occupa di gestire i bottoni.
 * Avanti, indietro, sinistra,destra
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class BottoniPanel extends javax.swing.JPanel {
    
    /** 
     * Istanziamento dell'oggetto drone.
     */
    private Drone drone;

    /**
     * Costruttore del panel, crea un nuovo oggetto drone
     * e gli assegna l'indirizzo ip e la porta.
     */
    public BottoniPanel() {
        initComponents();
        drone = new Drone(this);
        drone.start();
        drone.command();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decollaB = new javax.swing.JButton();
        atteraB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        decollaB.setText("DECOLLA");
        decollaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decollaBActionPerformed(evt);
            }
        });

        atteraB.setText("ATTERRA");
        atteraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atteraBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(decollaB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atteraB)
                        .addGap(57, 517, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(decollaB)
                .addGap(35, 35, 35)
                .addComponent(atteraB)
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void decollaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaBActionPerformed
        drone.decolla();
    }//GEN-LAST:event_decollaBActionPerformed

    private void atteraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atteraBActionPerformed
        drone.atterra();
    }//GEN-LAST:event_atteraBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atteraB;
    private javax.swing.JButton decollaB;
    // End of variables declaration//GEN-END:variables
}