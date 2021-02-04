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
     * Rappresenta lo stato del drone (acceso o spento).
     */
    public boolean stato;

    /**
     * Rappresenta l'indirizzo IP del drone.
     */
    public String ipDrone;

    /**
     * Rappresenta la porta UDP del drone.
     */
    public int porta;

    /**
     * Rappresenta la posizione del drone sull'asse x.
     */
    public double x = 0;

    /**
     * Rappresenta la posizione del drone sull'asse y.
     */
    public double y = 0;
    
    /**
     * Rappresenta la velocità del drone in percentuale.
     */
    public int velocità;

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
    private int destinationPort = 0;

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
     * Getter della posizione x del drone.
     *
     * @return la posizione del drone sull'asse x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Setter della posizione x del drone.
     *
     * @param x la nuova posizione del drone sull'asse x
     */
    public void setX(double x) {
        this.x = this.x +x;
    }

    /**
     * Getter della posizione ydel drone.
     *
     * @return la posizione del drone sull'asse y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Setter della posizione y del drone.
     *
     * @param y la nuova posizione del drone sull'asse y
     */
    public void setY(double y) {
        this.y = this.y + y;
    }

    /**
     * Getter dello stato del drone.
     *
     * @return lo stato attuale del drone (on/off).
     */
    public boolean getStato() {
        return this.stato;
    }

    /**
     * Inverte lo stato del drone.
     */
    public void setStato() {
        this.stato = !this.stato;
    }

    /**
     * Getter della velocità del drone.
     *
     * @return la velocità attuale del drone
     */
    public int getVelocità() {
        return this.velocità;
    }

    /**
     * Setter della velocità del drone.
     *
     * @param velocità la velocità attuale del drone.
     */
    public void setVelocità(int velocità) {
        if(velocità < 100 && velocità > 10){
            this.velocità = velocità;
        }
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
                messageListener.messageReceived();
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
    
    
    
    
    
    

    /**
     * Rappresenta lo stato della telecamera del drone (accesa o spenta).
     */
    private boolean telecamera;

    /**
     * Rappresenta la posizione del drone sull'asse z.
     */
    private double z;

    /**
     * Rappresenta la rotazione del drone in gradi rispetto al punto iniziale.
     */
    private double verso;

    /**
     * Getter della telecamera del drone.
     *
     * @return lo stato attuale della telecamera(on/off).
     */
    public boolean getTelecamera() {
        return this.telecamera;
    }

    /**
     * Inverte lo stato della telecamera.
     */
    public void setTelecamera() {
        this.telecamera = !this.telecamera;
    }

    /**
     * Getter della posizione z cdel drone.
     *
     * @return la posizione del drone sull'asse z.
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Setter della posizione z del drone.
     *
     * @param z la nuova posizione del drone sull'asse z
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Getter del verso del drone.
     *
     * @return il verso attuale del drone
     */
    public double getVerso() {
        return this.verso;
    }

    /**
     * Setter del verso del drone.
     *
     * @param verso il verso attuale del drone.
     */
    public void setVerso(double verso) {
        this.verso = verso;
    }

    /**
     * Alza o abbassa il drone di x centimetri.
     *
     * @param x l'altezza da aggiungere o diminuire al drone in cm.
     */
    public void upDown(double x) {

    }

    /**
     * Fa andare a destra o sinistra il drone di x centimetri.
     *
     * @param x il valore (destra o sinistra) da modificare in cm
     */
    public void leftRight(double x) {

    }

    /**
     * Ruota il drone di x centimetri
     *
     * @param x il valore in gradi di quanto deve ruotare il drone
     */
    public void ruota(double x) {

    }

    /**
     * Fa andare avanti o indietro il drone di x centimetri.
     *
     * @param x il valore (avanti o indietro) da modificare in cm
     */
    public void forwardBack(double x) {

    }
}
