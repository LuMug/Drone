/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPReceiver implements Runnable {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
    private CommandListener listener;

    public UDPReceiver(CommandListener listener) {
        try {
            this.listener = listener;
            socket = new DatagramSocket(4445);
        } catch (SocketException ex) {
            Logger.getLogger(UDPReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(UDPReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            //String received = new String(packet.getData(), 0, packet.getLength());
            String received = new String(packet.getData());
    
            System.out.println("Received: " + received.trim());
            System.out.println(packet.getLength());
            System.out.println();
            int n = Integer.parseInt(received.trim());

            this.listener.commandReceived(n);
            
            
            if (received.equals("end")) {
                running = false;
                continue;
            }
            try {
                socket.send(packet);
            } catch (IOException ex) {
                Logger.getLogger(UDPReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        socket.close();
    }

}
