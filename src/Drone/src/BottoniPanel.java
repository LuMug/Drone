import com.leapmotion.leap.Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Panel che si occupa di gestire i bottoni.
 * Avanti, indietro, sinistra,destra
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class BottoniPanel extends javax.swing.JPanel implements MessageListener, KeyListener {
    /** 
     * Istanziamento dell'oggetto drone.
     */
    private Drone drone;
    
    /**
     * Contiene l'istanza del Leap Motion.
     */
    private LeapMotion leapMotion;
    
    /**
     * Istanziamento di una variabile di errore.
     */
    public boolean error = false;

    /**
     * Costruttore del panel, crea un nuovo oggetto drone
     * e gli assegna l'indirizzo ip e la porta.
     */
    public BottoniPanel() {
        initComponents();
        drone = new Drone(this);
        setUp();
        drone.start();
        command();
        //live();
        
        coordinateTB.addKeyListener(this);

        //Gestione del LeapMotion
        LeapMotion listener = new LeapMotion(this);
        Controller controller = new Controller();
        controller.addListener(listener);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        coordinateTB = new javax.swing.JTextPane();
        invioB = new javax.swing.JButton();

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

        emergenzaB.setText("Test");
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

        jScrollPane1.setViewportView(coordinateTB);

        invioB.setText("Go");
        invioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(atteraB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(decollaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(sinistraB, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(indietroB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avantiB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invioB))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(destraB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(emergenzaB)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avantiB, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destraB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sinistraB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invioB)))
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
            drone.setY(30);
            String message = "left 20";
            invioMessaggio(message);
        }
    }//GEN-LAST:event_sinistraBMouseClicked

    private void avantiBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avantiBActionPerformed
        if (drone.getX() <= 180 && drone.getStato()) {
            drone.setX(20);
            String message = "forward 20";
            invioMessaggio(message);
        }
    }//GEN-LAST:event_avantiBActionPerformed

    private void destraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destraBActionPerformed
        if (drone.getY() <= 200 && drone.getStato()) {
            drone.setY(30);
            String message = "right 20";
            invioMessaggio(message);
        }
    }//GEN-LAST:event_destraBActionPerformed

    private void indietroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroBActionPerformed
        if (drone.getX() <= 200 && drone.getStato()) {
            drone.setX(20);
            String message = "back 20";
            invioMessaggio(message);
        }
    }//GEN-LAST:event_indietroBActionPerformed

    private void emergenzaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergenzaBActionPerformed
        /**
         * Bottone di test per le funzionalità da implementare.
         */
        //String message = "cw 180";
        String message = "stop";
        invioMessaggio(message);
    }//GEN-LAST:event_emergenzaBActionPerformed

    private void decollaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaBActionPerformed
        /**
         * Fa decollare il drone.
         */
        String message = "takeoff";
        invioMessaggio(message);
        drone.setStato();
    }//GEN-LAST:event_decollaBActionPerformed

    private void atteraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atteraBActionPerformed
        /**
         * Fa atterrare il drone.
         */
        String message = "land";
        invioMessaggio(message);
        drone.setStato();
    }//GEN-LAST:event_atteraBActionPerformed

    private void invioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invioBActionPerformed
        /**
         * Muove il drone tramite le coordinate inserite
         * nel text box.
         */
        String message = "go " + coordinateTB.getText();
        invioMessaggio(message);
    }//GEN-LAST:event_invioBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atteraB;
    private javax.swing.JButton avantiB;
    private javax.swing.JTextPane coordinateTB;
    private javax.swing.JButton decollaB;
    private javax.swing.JButton destraB;
    private javax.swing.JButton emergenzaB;
    private javax.swing.JButton indietroB;
    private javax.swing.JButton invioB;
    private javax.swing.JScrollPane jScrollPane1;
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
        drone.setIpDrone("192.168.10.1");
        drone.setPorta(8889);
    }
    
    public void keyPressed(KeyEvent e) {
        String message;      
        int keyCode = e.getKeyCode();
        if(keyCode == 37){
            message = "go 0 -20 0 20";
            invioMessaggio(message);
            System.out.println("Sinistra");
        }if(keyCode == 38){
            message = "go 20 0 0 20";
            invioMessaggio(message);
            System.out.println("Su");
        }if(keyCode == 39){
            message = "go 0 20 0 20";
            invioMessaggio(message);
            System.out.println("Destra");
        }if(keyCode == 40){
            message = "go -20 0 0 20";
            invioMessaggio(message);
            System.out.println("Giù");
        }
    }

    public void keyTyped(KeyEvent e) {}

    
    public void keyReleased(KeyEvent e) {}
    
    public void live() {  
        String message = "streamOn";
        invioMessaggio(message);
    }
}
