package DronePk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Panel che contiene la live della camera.
 *
 * @author Alessandro Aloise e Gianni
 * @version 28.01.2021
 */
public class LivePanel extends javax.swing.JPanel implements Runnable {

    private boolean isStreamOn;
    private DatagramSocket serverSocket;
    private byte[] receiveData = new byte[1470];
    private Drone drone;

    public static File file;
    public static FileWriter fw;

    /**
     * Creates new form DronePanel
     */
    public LivePanel() {
        initComponents();
        isStreamOn = true;
        creaFile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void run() {
        try {
            serverSocket = new DatagramSocket(11111);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }

        while (isStreamOn) {
            receiveData = new byte[1470];
            try {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                //String z = new String(receivePacket.getData());
                byte[] bytes = receivePacket.getData();

                //byte[] byteArrray = z.getBytes();
                fw.write("" + bytes);
                fw.flush();
                //System.out.println(bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.close();
        } catch (IOException ex) {

        }
        isStreamOn = false;
        serverSocket.close();
    }

    public boolean isStreamOn() {
        return isStreamOn;
    }

    public void setStreamOn(boolean streamOn) {
        isStreamOn = streamOn;
    }

    public void creaFile() {
        try {
            file = new File("Prova.mp4");
            file.createNewFile();
            fw = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println("Error:"+ex);
        }
    }
}
