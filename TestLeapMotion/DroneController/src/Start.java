import com.leapmotion.leap.*;
import java.io.*;

public class Start {

    public static void main(String[] args) {
    	
        Sample leap = new Sample();
        //leap.run();
        //UDPSender udpS = new UDPSender();
        //udpS.run();


        Thread t = new Thread(leap);
        //Thread tt = new Thread(udpS);
        t.start();
        //tt.start();

        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}