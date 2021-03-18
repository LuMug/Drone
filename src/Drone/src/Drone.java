import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JPanel;

/**
 * La classe Drone rappresenta il modello astratto di un drone.
 *
 * @author Gianni Grasso
 * @version 28.01.2021
 */
public class Drone extends Thread {



    /**
     * Rappresenta l'indirizzo IP del drone.
     */
    public String ipDrone;

    /**
     * Rappresenta la porta UDP del drone.
     */
    public int porta;



    /**
     * Il socket di dati.
     */
    DatagramSocket socket = null;

    /**
     * Il pacchetto di dati.
     */
    DatagramPacket packet;

    /**
     * Array di byte. Il buffer dei dati da mandare.
     */
    byte[] sendBuf = new byte[256];

    /**
     * La porta corrente.
     */
    private int port;

    /**
     * La porta di destinazione.
     */
    private int destinationPort;

    /**
     * L'ip di destinazione.
     */
    private InetAddress destinationIp;

    /**
     * Il messaggio da inviare.
     */
    private String messageToSend = "";

    /**
     * Il messaggio ricevuto.
     */
    private String messageReceived = new String();

    /**
     * Istanza del frame.
     */
    private BottoniPanel messageListener;

    /**
     * Getter dell'ip del drone.
     *
     * @return l'ip attuale del drone
     */
    public String getIpDrone() {
        return this.ipDrone;
    }

    /**
     * Setter dell'ip del drone.
     *
     * @param ipDrone il nuovo ip del drone
     */
    public void setIpDrone(String ipDrone) {
        this.ipDrone = ipDrone;
    }

    /**
     * Getter della porta del drone.
     *
     * @return la porta attuale del drone
     */
    public int getPorta() {
        return this.porta;
    }

    /**
     * Setter della porta del drone.
     *
     * @param porta la nuova porta del drone
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }




    
    /**
     * Metodo costruttore personalizzato con 1 parametro.
     *
     * @param jp Il frame in cui avviene la comunicazione.
     */
    public Drone(BottoniPanel jp) {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {

        }

        port = socket.getLocalPort();

        setPortAsTitle(jp);

        messageListener = jp;
    }

    /**
     * Ritorna il messaggio ricevuto.
     *
     * @return Il messaggio ricevuto.
     */
    public String getMessageReceived() {
        //System.out.println(messageReceived);
        return messageReceived;
    }

    /**
     * Metodo che viene chiamato dalle thread e serve per ricevere i messaggi.
     */
    public void run() {
        try {
            while (true) {
                DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length);
                socket.receive(packet);
                messageReceived = new String(packet.getData(), 0, packet.getLength());
                System.out.println(messageReceived);
               // messageListener.messageReceived();
            }
        } catch (SocketException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        }
    }

    /**
     * Metodo che serve a mandare i messaggi.
     */
    public void sendMessage() {
        try {
            byte[] data = messageToSend.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, destinationIp, destinationPort);
            socket.send(packet);
        } catch (SocketException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        }
    }

    /**
     * Imposta la porta come titolo del frame.
     *
     * @param jp Il panel in cui impostare il titolo.
     */
    public void setPortAsTitle(JPanel jp) {
        System.out.println(socket.getLocalPort());
    }

    /**
     * Imposta le informazioni di destinazione.
     *
     * @param ip L'indirizzo ip.
     * @param port La porta.
     * @param message Il messaggio.
     */
    public void setInfo(String ip, int port, String message) {
        try {
            destinationIp = InetAddress.getByName(ip);
            if (port >= 0 && port <= 65535) {
                destinationPort = port;
            }
            messageToSend = message;
        } catch (UnknownHostException | NullPointerException ex) {
            System.err.println("ERRORE: IP inserito non valido!");
        }

    }
}
