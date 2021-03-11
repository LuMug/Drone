
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

/**
 * Classe che stampa come output i valori del drone.
 * 
 * @version 11.03.2021
 * @author Alessandro Aloise
 */
public class Status extends Thread {

    public static void main(String[] args) throws SocketException, IOException {
        try {
            DatagramSocket socket;
            byte[] buf = new byte[256];
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
                // System.out.println("Drone: " + received);

                StringTokenizer st = new StringTokenizer(received, " ;");
                String pich = st.nextToken();
                String roll = st.nextToken();
                String yaw = st.nextToken().substring(4);
                String spX = st.nextToken().substring(4);
                String spY = st.nextToken().substring(4);
                String spZ = st.nextToken().substring(4);
                String templ = st.nextToken();
                double temMinF = Integer.parseInt(templ.substring(6));
                double temMinC = (temMinF - 32) * 0.5;
                String temph = st.nextToken();
                double temMaxF = Integer.parseInt(temph.substring(6));
                double temMaxC = (temMaxF - 32) * 0.5;
                String tof = st.nextToken();
                String altezza = st.nextToken().substring(2);
                String bat = st.nextToken().substring(4);
                System.out.println("Valori del Drone:");
                System.out.print("Batteria: ");
                System.out.println(bat);
                System.out.print("Temeratura minima: ");
                System.out.println(temMinC);
                System.out.print("Temeratura massima: ");
                System.out.println(temMaxC);
                System.out.print("Velocita x: ");
                System.out.println(spX);
                System.out.print("Velocita y: ");
                System.out.println(spY);
                System.out.print("Velocita Z: ");
                System.out.println(spZ);
                System.out.print("Altezza: ");
                System.out.println(altezza);
                System.out.print("Altitudine: ");
                System.out.println(yaw);
                Thread.sleep(1000);
                System.out.println(new String(new char[50]).replace("\0", "\r\n"));
                if (temMinC == 100) {
                    fine = false;
                    socket.close();
                }
            }

        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }
}
