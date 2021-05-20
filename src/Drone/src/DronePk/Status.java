package DronePk;

import ImageFrame.ImageFrame;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Classe che si occupa di scrivere un file di log.
 *
 * @version 11.03.2021
 * @author Alessandro Aloise
 */
public class Status extends Thread {

    /**
     * Istanza della classe di log.
     */
    Log log = new Log();

    /**
     * Contiene il valore della posizione del drone.
     */
    public String pitch = "";

    /**
     * Contiene il valore della posizione del drone.
     */
    public String roll = "";

    /**
     * Contiene il valore della posizione del drone.
     */
    public String yaw = "";

    /**
     * Velocità asse X.
     */
    public String spX = "";

    /**
     * Velocità asse Y.
     */
    public String spY = "";

    /**
     * Velocità asse Z.
     */
    public String spZ = "";

    /**
     * Temperatura minima in F non formattata..
     */
    public String templ = "";

    /**
     * Temperatura minima in F°.
     */
    public double temMinF;

    /**
     * Temperatura minima in C°.
     */
    public double temMinC;

    /**
     * Temperatura massima in F non formattata..
     */
    public String temph = "";

    /**
     * Temperatura massimo in F.
     */
    public double temMaxF;

    /**
     * Temperatura massima in C°.
     */
    public double temMaxC;

    /**
     * Tempo di volo in cm.
     */
    public String tof = "";

    /**
     * Altezza a qui si trova il dorne.
     */
    public String altezza = "";

    /**
     * Batteria del drone
     */
    public String bat = "";

    /**
     * Pressione barometrica.
     */
    public String baro = "";

    /**
     * Tempo di volo rimanente in min.
     */
    public String time = "";

    /**
     * Accelerazione sull'asse X.
     */
    public String agx = "";

    /**
     * Accelerazione sull'asse Y.
     */
    public String agy = "";

    /**
     * Accelerazione sull'asse Z.
     */
    public String agz = "";

    /**
     * Porta del drone.
     */
    public int port;

    /**
     * Ip del drone.
     */
    public String ip;

    /**
     * Data formatter.
     */
    DateFormat dateFormat;

    /**
     * Variabile per prendere la data.
     */
    Date data = new Date();

    /**
     * Creazione di una nuova istanza di Image Frame.
     */
    ImageFrame view = new ImageFrame();

    /**
     * Metodo run della thread.
     */
    public void run() {
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
        try {
            log.creazioneCarterlla();
            log.creazioneFile();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }

        DatagramSocket socket;
        byte[] buf = new byte[256];
        try {
            socket = new DatagramSocket(8890);
            boolean fine = true;

            while (fine) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());
                socket.receive(packet);
                StringTokenizer st = new StringTokenizer(received, " ;");
                pitch = st.nextToken().substring(6);
                roll = st.nextToken().substring(5);
                yaw = st.nextToken().substring(4);
                spX = st.nextToken().substring(4);
                spY = st.nextToken().substring(4);
                spZ = st.nextToken().substring(4);
                templ = st.nextToken();
                temMinF = Integer.parseInt(templ.substring(6));
                temMinC = (temMinF - 32) * 0.5;
                temph = st.nextToken();
                temMaxF = Integer.parseInt(temph.substring(6));
                temMaxC = (temMaxF - 32) * 0.5;
                tof = st.nextToken();
                altezza = st.nextToken().substring(2);
                bat = st.nextToken().substring(4);
                baro = st.nextToken().substring(5);
                time = st.nextToken().substring(5);
                agx = st.nextToken().substring(4);
                agy = st.nextToken().substring(4);
                agz = st.nextToken().substring(4);
                view.setPitch(Integer.parseInt(pitch));
                view.setRoll(Integer.parseInt(roll));
                view.setYaw(Integer.parseInt(yaw));
                view.setAlt(Integer.parseInt(altezza));
                Thread.sleep(100);
                String valori = " Bat:" + bat
                        + " TMax:" + temMaxC
                        + " pitch:" + pitch
                        + " roll:" + roll
                        + " yaw:" + yaw
                        + " Vx:" + spX
                        + " Vy:" + spY
                        + " Vz:" + spZ
                        + " h:" + altezza
                        + " Ax:" + agx
                        + " Ay:" + agy
                        + " Az:" + agz
                        + " TCm: " + time;
                String finale = dateFormat.format(data) + " " + ip + ":" + port + valori;
                try {
                    log.scritturaFile(finale);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex);
                }

                if (temMinC >= 100) {
                    fine = false;
                    socket.close();
                    log.chiusuraFile();
                }
            }
        } catch (SocketException ex) {
            System.out.println("Error:" + ex);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error:" + ex);
        }
    }

    /**
     * Metodo che ritorna il valore della batteria.
     */
    public String getbatteria() {
        return bat;
    }

    /**
     * Metodo che si occupa di scrivere la IP nel file.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Metodo che si occupa di scrivere la porta nel file.
     */
    void setport(int porta) {
        this.port = porta;
    }

}
