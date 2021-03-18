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
    Status status= new Status();
    Log log = new Log();
    
    /** 
     * Istanziamento dell'oggetto drone.
     */
    private Drone drone;
    
    private int moveStep = 25;
    private int altStep = 25;
    private int yawStep = 25;
    private String ip ="192.168.10.1";
    private int port =8889;

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

        coordinateTB.addKeyListener(this);

        //Gestione del LeapMotion
        LeapMotion listener = new LeapMotion(this);
        Controller controller = new Controller();
        controller.addListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decollaB = new javax.swing.JButton();
        atteraB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        coordinateTB = new javax.swing.JTextPane();
        invioB = new javax.swing.JButton();
        batteria = new javax.swing.JTextField();

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

        jScrollPane1.setViewportView(coordinateTB);

        invioB.setText("Go");
        invioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invioBActionPerformed(evt);
            }
        });

        batteria.setText("Bat: 0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(decollaB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(284, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invioB)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atteraB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batteria, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invioB)
                    .addComponent(decollaB))
                .addGap(35, 35, 35)
                .addComponent(atteraB)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(batteria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void decollaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decollaBActionPerformed
        /**
         * Fa decollare il drone.
         */
        String message = "takeoff";
        invioMessaggio(message);
        drone.setStato();
        status.start();
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
        String message =  coordinateTB.getText();
        invioMessaggio(message);
    }//GEN-LAST:event_invioBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atteraB;
    private javax.swing.JTextField batteria;
    private javax.swing.JTextPane coordinateTB;
    private javax.swing.JButton decollaB;
    private javax.swing.JButton invioB;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void command() {
        String message = "command";
        invioMessaggio(message);
    }

    @Override
    public void messageReceived() {
    }

    public void invioMessaggio(String message)  {
        try {
            drone.setInfo(drone.ipDrone, drone.porta, message);
            drone.sendMessage();
                //debug
                System.out.println("IP: " + drone.ipDrone +  
                        ", Port: " + drone.porta);
                System.out.println("Message sent: " + message);
                System.out.println( "Message received: " + drone.getMessageReceived());
                System.out.println("------------------------");
                batteria.setText("Bat:"+ status.getbatteria()+"%");
                
                Thread.sleep(125);
        } catch (InterruptedException ex) {
        }
    }

    public void setUp() {
        drone.setIpDrone(ip);
        drone.setPorta(port);
        status.setIp(ip);
        status.setport(port);
    }
    
    public void keyPressed(KeyEvent e) {
        try {
            Thread.sleep(750);
        } catch (InterruptedException ex) {
            System.out.println("Errore nel Thread.sleep");
        }
        int leftRight = 0;
        int backForward = 0;
        int upDown = 0;
        int yaw = 0;
        
        String message;      
        int keyCode = e.getKeyCode();
        if(keyCode == 37){
            leftRight -= moveStep;
            System.out.println("Sinistra");
        }if(keyCode == 38){
            backForward += moveStep;
            System.out.println("Avanti");
        }if(keyCode == 39){
            leftRight += moveStep;
            System.out.println("Destra");
        }if(keyCode == 40){
            backForward -= moveStep;
            System.out.println("Indietro");
        }if(keyCode == 83){
            upDown -= altStep;
            System.out.println("Giù");
        }
        if(keyCode == 87){
            upDown += altStep;
            System.out.println("Su");
        }if(keyCode == 65){
            yaw -= yawStep;
            System.out.println("Ruota sx");
        }if(keyCode == 68){
            yaw += yawStep;
            System.out.println("Ruota dx");
        }
        message = "rc " + leftRight + " " + backForward + " " + upDown + " " +  yaw;
        invioMessaggio(message);
    }

    public void keyTyped(KeyEvent e) {}

    
    public void keyReleased(KeyEvent e) {
        invioMessaggio("rc 0 0 0 0");
    }
    
    public void live() {  
        String message = "streamon";
        invioMessaggio(message);
    }
}