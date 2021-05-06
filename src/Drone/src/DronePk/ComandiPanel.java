package DronePk;

import com.leapmotion.leap.Controller;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.text.DefaultCaret;

/**
 * Panel che contiene gli ultimi comandi eseguiti.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class ComandiPanel extends javax.swing.JPanel {

    /**
     * Contiene l'istanza di funzioni panel.
     */
    private FunzionePanel funzionePanel;

    /**
     * Contiene l'istanza del leap motion.
     */
    private LeapMotionProject leapListener;

    /**
     * Contiene l'stanza del controller per il leapMotion.
     */
    private Controller leapController;

    /**
     * Contiene l'stanza del droneFrame
     */
    private DroneFrame droneFrame;

    /**
     * Contiene l'istanza del drone.
     */
    private Drone drone;

    /**
     * Contiene la veloctà corrente.
     */
    private int speed = 50;

    /**
     * Contiene il tempo iniziale di un ciclo.
     */
    private long initialTime;

    /**
     * Metodo che si occupa di istanziare e creare il panel.
     */
    public ComandiPanel() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) commandsText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    /**
     * Serve ad aggiornare comandi Panel.
     *
     * @param command da scrivere
     */
    public void refreshCommands(String command) {
        commandsText.append(command);
    }

    /**
     * Codice autogenerato da netbeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandsText = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        keyboardButton = new javax.swing.JRadioButton();
        leapmotionButton = new javax.swing.JRadioButton();

        buttonGroup.add(keyboardButton);
        buttonGroup.add(leapmotionButton);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMANDI ESEGUITI");
        add(jLabel1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        commandsText.setEditable(false);
        commandsText.setColumns(20);
        commandsText.setRows(5);
        jScrollPane1.setViewportView(commandsText);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        keyboardButton.setSelected(true);
        keyboardButton.setText("Tastiera");
        keyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyboardButtonActionPerformed(evt);
            }
        });
        jPanel1.add(keyboardButton);

        leapmotionButton.setText("Leap Motion");
        leapmotionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leapmotionButtonActionPerformed(evt);
            }
        });
        jPanel1.add(leapmotionButton);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Richiamato quando viene cliccato il pulsante.
     *
     * @param evt variabile contenente le informazioni dell'evento
     */
    private void keyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyboardButtonActionPerformed
        leapController.removeListener(leapListener);
        leapListener.delete();
        leapController.delete();
        droneFrame.switchEmergencyListenerOff();
        droneFrame.switchKeyListenerOn();
    }//GEN-LAST:event_keyboardButtonActionPerformed

    /**
     * Richiamato quando viene cliccato il pulsante.
     *
     * @param evt variabile contenente le informazioni dell'evento
     */
    private void leapmotionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leapmotionButtonActionPerformed
        droneFrame.switchKeyListenerOff();
        droneFrame.switchEmergencyListenerOn();
        leapController = new Controller();
        leapListener = new LeapMotionProject(drone, funzionePanel);
        leapController.addListener(leapListener);
    }//GEN-LAST:event_leapmotionButtonActionPerformed

    /**
     * Richiamato quando un tasto viene premuto e rilasciato.
     *
     * @param e variabile contenente le info dell'evento.
     */
    public void keyTypedC(KeyEvent e) {
    }

    /**
     * Richiamato quando un tasto viene premuto.
     *
     * @param e variabile contenente le info dell'evento.
     */
    public void keyPressedC(KeyEvent e) {
        if (e.getExtendedKeyCode() == 87) {
            sendKeyboardCommand("rc 0 " + speed + " 0 0");
        }
        if (e.getExtendedKeyCode() == 65) {
            sendKeyboardCommand("rc -" + speed + " 0 0 0");
        }
        if (e.getExtendedKeyCode() == 83) {
            sendKeyboardCommand("rc 0 -" + speed + " 0 0");
        }
        if (e.getExtendedKeyCode() == 68) {
            sendKeyboardCommand("rc " + speed + " 0 0 0");
        }
        if (e.getExtendedKeyCode() == 37) {
            sendKeyboardCommand("rc 0 0 0 -" + speed);
        }
        if (e.getExtendedKeyCode() == 39) {
            sendKeyboardCommand("rc 0 0 0 " + speed);
        }
        if (e.getExtendedKeyCode() == 40) {
            sendKeyboardCommand("rc 0 0 -" + speed + " 0");
        }
        if (e.getExtendedKeyCode() == 38) {
            sendKeyboardCommand("rc 0 0 " + speed + " 0");
        }
        if (e.getExtendedKeyCode() == 32) {
            drone.invioMessaggio("rc 0 0 0 0");
        }
        if (e.getExtendedKeyCode() == 78) {
            if (speed > 10) {
                speed -= 10;
                funzionePanel.writeSpeed(speed);
            }
        }
        if (e.getExtendedKeyCode() == 77) {
            if (speed < 100) {
                speed += 10;
                funzionePanel.writeSpeed(speed);
            }
        }
        if (e.getExtendedKeyCode() == 84) {
            sendKeyboardCommand("takeoff");
        }
        if (e.getExtendedKeyCode() == 76) {
            sendKeyboardCommand("land");
        }
        if (e.getExtendedKeyCode() == 85) {
            sendKeyboardCommand("flip f");
        }
        if (e.getExtendedKeyCode() == 74) {
            sendKeyboardCommand("flip b");
        }
        if (e.getExtendedKeyCode() == 72) {
            sendKeyboardCommand("flip l");
        }
        if (e.getExtendedKeyCode() == 75) {
            sendKeyboardCommand("flip r");
        }
        if (e.getExtendedKeyCode() == 10) {
            drone.invioMessaggio("emergency");
        }
    }

    /**
     * Richiamato quando un tasto viene rilasciato.
     *
     * @param e variabile contenente le info dell'evento.
     */
    public void keyReleasedC(KeyEvent e) {
        drone.invioMessaggio("rc 0 0 0 0");
    }

    /**
     * Serve a impostare un drone.
     *
     * @param drone da impostare
     */
    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    /**
     * Serve a ritornare il drone impostato.
     *
     * @return drone impostato
     */
    public Drone getDrone() {
        return this.drone;
    }

    /**
     * Metodo utile ad inviare i comandi da tastiera al drone, limitandoli a 1
     * ogni 125 millisecondi.
     *
     * @param command da inviare
     */
    public void sendKeyboardCommand(String command) {
        if (System.currentTimeMillis() - initialTime >= 125) {
            drone.invioMessaggio(command);
            initialTime = System.currentTimeMillis();
        }
    }

    /**
     * Ritorna il riferimento del JRadioButton.
     *
     * @return radio button della tastiera
     */
    public JRadioButton getKeyboardButton() {
        return keyboardButton;
    }

    /**
     * Ritorna il riferimento del JRadioButton.
     *
     * @return radio button del leap motion
     */
    public JRadioButton getLeapmotionButton() {
        return leapmotionButton;
    }

    /**
     * Serve ad impostare il droneFrame.
     *
     * @param droneFrame da impostare
     */
    public void setDroneFrame(DroneFrame droneFrame) {
        this.droneFrame = droneFrame;
    }

    /**
     * Serve ad impostare il funzione panel.
     *
     * @param funzionePanel da impostare
     */
    public void setFunzionePanel(FunzionePanel funzionePanel) {
        this.funzionePanel = funzionePanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextArea commandsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton keyboardButton;
    private javax.swing.JRadioButton leapmotionButton;
    // End of variables declaration//GEN-END:variables
}
