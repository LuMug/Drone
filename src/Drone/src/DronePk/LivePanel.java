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

    /**
     * Definisce se la stream e' accesa o spenta.
     */
    private boolean isStreamOn;

    /**
     * Contiene il socket del server.
     */
    private DatagramSocket serverSocket;

    /**
     * Array per la ricezione dei dati.
     */
    private byte[] receiveData = new byte[1470];

    /**
     * Contiene l'stanza del drone.
     */
    private Drone drone;

    /**
     * Contiene il riferimento al file.
     */
    public static File file;

    /**
     * Variabile utile a scrivere nel file.
     */
    public static FileWriter fw;

    /**
     * Creates new form DronePanel
     */
    public LivePanel() {
        initComponents();
        isStreamOn = true;
        creaFile();
    }

    /**
     * Codice autogenerato da netbeans.
     */
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

    /**
     * Metodo chiamato dalla thread.
     */
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

    /**
     * Metodo che ritorna se la stream e' accesa o meno.
     * @return se la stream e' accesa o meno.
     */
    public boolean isStreamOn() {
        return isStreamOn;
    }

    /**
     * Serve ad impostare lo stato della live.
     * @param streamOn accendere o spegnere la live
     */
    public void setStreamOn(boolean streamOn) {
        isStreamOn = streamOn;
    }

    /**
     * Metodo che crea il file.
     */
    public void creaFile() {
        try {
            file = new File("Prova.mp4");
            file.createNewFile();
            fw = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
