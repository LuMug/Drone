
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EchoServerUDP extends Thread {


    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket;
        boolean running;
        byte[] buf = new byte[256];
        socket = new DatagramSocket(11111);
        running = true;

        while (running) {
            //Thread.sleep();
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received 
              = new String(packet.getData(), 0, packet.getLength());
            
            if (received.equals("end")) {
                running = false;
                continue;
            }
            socket.send(packet);
                    System.out.println("Server: " + received);
        }

        socket.close();
    }
}