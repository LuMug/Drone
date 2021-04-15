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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che stampa come output i valori del drone.
 *
 * @version 11.03.2021
 * @author Alessandro Aloise
 */
public class Status extends Thread {

    Log log = new Log();

    public String pitch = "";
    public String roll = "";
    public String yaw = "";
    public String spX = "";
    public String spY = "";
    public String spZ = "";
    public String templ = "";
    public double temMinF;
    public double temMinC;
    public String temph = "";
    public double temMaxF;
    public double temMaxC;
    public String tof = "";
    public String altezza = "";
    public String bat = "";
    public String baro = "";
    public String time = "";
    public String agx = "";
    public String agy = "";
    public String agz = "";
    public int port;
   
    public String ip;
    DateFormat dateFormat;
    Date data = new Date();
    ImageFrame view=new ImageFrame();

    public void run() {
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
        log.creazioneFile();
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
                log.scritturaFile(finale);

                if (temMinC == 100) {
                    fine = false;
                    socket.close();
                    log.chiusuraFile();
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getValori() {
        String valori = "Batteria:" + bat
                + " TemeraturaMax:" + temMaxC
                + " VelocitaX:" + spX
                + " VelocitaY:" + spY
                + " VelocitaZ:" + spZ
                + " Altezza:" + altezza
                + " AccelerazioneX:" + agx
                + " AccelerazioneY:" + agy
                + " AccelerazioneZ:" + agz
                + "TempoCm" + time;
        System.out.println("Valori:"+valori);
        return valori;
    }

    public String getbatteria() {
        return bat;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    void setport(int porta) {
        this.port = porta;
    }

}
