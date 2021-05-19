package DronePk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * La classe Drone rappresenta il modello astratto di un drone.
 *
 * @author Alessandro Aloise
 * @version 28.01.2021
 */
public class Drone extends Thread {

    /**
     * Costante Ip del drone.
     */
    private String ip = "192.168.10.1";

    /**
     * Porta per il Socket.
     */
    private int portD = 8889;

    /**
     * Nuova istanza di status.
     */
    private Status status = new Status();

    /**
     * Nuova istanza di log.
     */
    private Log log = new Log();

    /**
     * Rappresenta lo stato del drone (acceso o spento).
     */
    private boolean stato;

    /**
     * Rappresenta l'indirizzo IP del drone.
     */
    private String ipDrone;

    /**
     * Rappresenta la porta UDP del drone.
     */
    private int porta;

    /**
     * Il socket di dati.
     */
    private DatagramSocket socket = null;

    /**
     * Il pacchetto di dati.
     */
    private DatagramPacket packet;

    /**
     * Array di byte, il buffer dei dati da mandare.
     */
    private byte[] sendBuf = new byte[256];

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
     * Stringa per ottenere il comando da ImageFrame.
     */
    private String istru;

    /**
     * Istanza di comandiPanel.
     */
    private ComandiPanel comandiPanel;

    /**
     * Variabile per la gestione della verlocità.
     */
    private int speed = 50;

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
     */
    public Drone() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        }
        port = socket.getLocalPort();
        status.start();
        setUp();
    }

    /**
     * Metodo che ritorna il messaggio ricevuto.
     *
     * @return Il messaggio ricevuto.
     */
    public String getMessageReceived() {
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
            System.out.println("ERRORE: " + ex.getMessage());
        }
    }

    /**
     * Inverte lo stato del drone.
     */
    public void setStato() {
        this.stato = !this.stato;
    }

    /**
     * Metodo che invia i comandi al drone.
     *
     * @param message da inviare
     */
    public void invioMessaggio(String message) {
        setInfo(ipDrone, porta, message);
        istru = message;
        sendMessage();
        comandiPanel.refreshCommands(message + "\n");
    }

    /**
     * Metodo che si occupa di impostare i valori di base.
     */
    public void setUp() {
        setIpDrone(ip);
        setPorta(portD);
        status.setIp(ip);
        status.setport(portD);
    }

    /**
     * Metodo che si occupa di far deccollare il drone.
     */
    public void decolla() {
        String message = "takeoff";
        invioMessaggio(message);
        setStato();
    }

    /**
     * Metodo che si occupa di far atterare il drone.
     */
    public void atterra() {
        String message = "land";
        invioMessaggio(message);
        setStato();
    }

    /**
     * Metodo che si occupa di sbloccare SKD del drone.
     */
    public void command() {
        String message = "command";
        invioMessaggio(message);
    }

    /**
     * Metodo che si occupa di ritornare il valore della batteria.
     *
     * @return Il valore della batteria.
     */
    public String batteria() {
        return status.getbatteria();
    }

    /**
     * Metodo che si occupa di impostare il Comandi Panel.
     *
     * @param comandiPanel Istanza di comandi Panel.
     */
    public void setComandiPanel(ComandiPanel comandiPanel) {
        this.comandiPanel = comandiPanel;
    }

    /**
     * Metodo che si occupa dell'aggiornamento del comandi panel.
     *
     * @param message da stampare
     */
    public void refreshCommandsD(String message) {
        comandiPanel.refreshCommands(message);
    }
}