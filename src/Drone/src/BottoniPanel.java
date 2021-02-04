
/**
 * Panel che si occupa di gestire i bottoni.
 * Avanti, indietro, sinistra,destra
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class BottoniPanel extends javax.swing.JPanel implements MessageListener {

    /**
     * Istanziamento dell'oggetto drone.
     */
    private Drone drone;

    public boolean error = false;

    /**
     * Creates new form BottiniPanel
     */
    public BottoniPanel() {
        initComponents();
        drone = new Drone(this);
        setUp();
        drone.start();
        command();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avantiB = new javax.swing.JButton();
        indietroB = new javax.swing.JButton();
        sinistraB = new javax.swing.JButton();
        destraB = new javax.swing.JButton();
        emergenzaB = new javax.swing.JButton();
        decollaB = new javax.swing.JButton();
        atteraB = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        avantiB.setText("Avanti");
        avantiB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avantiBActionPerformed(evt);
            }
        });

        indietroB.setText("Indietro");
        indietroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroBActionPerformed(evt);
            }
        });

        sinistraB.setText("Sinistra");
        sinistraB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinistraBMouseClicked(evt);
            }
        });

        destraB.setText("Destra");
        destraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destraBActionPerformed(evt);
            }
        });

        emergenzaB.setText("Emergenza");
        emergenzaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergenzaBActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(sinistraB, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(atteraB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(decollaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indietroB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avantiB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(destraB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emergenzaB)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avantiB, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(destraB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sinistraB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(indietroB, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decollaB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atteraB))
                    .addComponent(emergenzaB, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sinistraBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinistraBMouseClicked
        if (drone.getY() <= 180 && drone.getStato()) {
            drone.setY(20);
            String message = "left " + drone.getY();
            invioMessaggio(message);
        }
    }//GEN-LAST:event_sinistraBMouseClicked

    private void avantiBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avantiBActionPerformed
        if (drone.getX() <= 180 && drone.getStato()) {
            drone.setX(20);
            String message = "up " + drone.getX();
            invioMessaggio(message);
        }
    }//GEN-LAST:event_avantiBActionPerformed

    private void destraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destraBActionPerformed
        if (drone.getY() <= 200 && drone.getStato()) {
            drone.setY(-20);
            String message = "left " + drone.getY();
            invioMessaggio(message);
        }
    }//GEN-LAST:event_destraBActionPerformed

    private void indietroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroBActionPerformed
        if (drone.getX() <= -200 && drone.getStato()) {
            drone.setX(-20);
            String message = "down " + drone.getX();
            invioMessaggio(message);
        }
    }//GEN-LAST:event_indietroBActionPerformed

    private void emergenzaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergenzaBActionPerformed
        /**
         * In caso di emergenza.
         */
        String message = "emergency";
        invioMessaggio(message);

    }//GEN-LAST:event_emergenzaBActionPerformed

    private void decollaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaBActionPerformed
        String message = "takeoff";
        invioMessaggio(message);
        drone.setStato();
    }//GEN-LAST:event_decollaBActionPerformed

    private void atteraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atteraBActionPerformed
        String message = "land";
        invioMessaggio(message);
        drone.setStato();
    }//GEN-LAST:event_atteraBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atteraB;
    private javax.swing.JButton avantiB;
    private javax.swing.JButton decollaB;
    private javax.swing.JButton destraB;
    private javax.swing.JButton emergenzaB;
    private javax.swing.JButton indietroB;
    private javax.swing.JButton sinistraB;
    // End of variables declaration//GEN-END:variables

    public void command() {
        String message = "command";
        invioMessaggio(message);
    }

    @Override
    public void messageReceived() {
        if ("false".equals(drone.getMessageReceived())) {
            System.out.println("Error drone: " + drone.getMessageReceived());
            error = !error;
        }
    }

    public void invioMessaggio(String message) {
        drone.setInfo(drone.ipDrone, drone.porta, message);
        drone.sendMessage();
        messageReceived();
        if (!error) {
            //debug 
            System.out.println("Messaggio mandato:" + message);
        }
    }

    public void setUp() {
        drone.setIpDrone("192.168.200.26");
        drone.setPorta(55327);
    }
}
