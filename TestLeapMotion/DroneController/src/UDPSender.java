import com.leapmotion.leap.*;
import java.io.*;

public class UDPSender implements Runnable {
 	public String write;
    public void run() {
       
 
        while (true) {
        	try{
        		Thread.sleep(500);
        	}catch (InterruptedException ie){

        	}

        	
        	System.out.println("Sending..."+write);
        }
        
    }


/*
private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
 
    public EchoClient() {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }
 
    public String sendEcho(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(
          packet.getData(), 0, packet.getLength());
        return received;
    }
 
    public void close() {
        socket.close();
    }
    */


}