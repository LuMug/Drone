package DronePk;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.DefaultCaret;

/**
 * Panel che contiene gli ultimi comandi eseguiti.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class ComandiPanel extends javax.swing.JPanel {

    private Drone drone;

    private int speed = 50;

    private long initialTime;

    /**
     * Metodo che si occupa di istanziare e creare il panel.
     */
    public ComandiPanel() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) commandsText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    public void refreshCommands(String command) {
        commandsText.append(command);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandsText = new javax.swing.JTextArea();

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
    }// </editor-fold>//GEN-END:initComponents

    public void keyTypedC(KeyEvent e) {
    }

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
                commandsText.append("SPEED DEPRECATED TO: " + speed + "\n");
            } else {
                commandsText.append("CAN'T DEPRECATE MORE\n");
            }
        }
        if (e.getExtendedKeyCode() == 77) {
            if (speed < 100) {
                speed += 10;
                commandsText.append("SPEED INCREMENTED TO: " + speed + "\n");
            } else {
                commandsText.append("CAN'T INCREMENT MORE\n");
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
    }

    public void keyReleasedC(KeyEvent e) {
        drone.invioMessaggio("rc 0 0 0 0");
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Drone getDrone() {
        return this.drone;
    }

    public void sendKeyboardCommand(String command) {
        if (System.currentTimeMillis() - initialTime >= 125) {
            drone.invioMessaggio(command);
            initialTime = System.currentTimeMillis();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea commandsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
