import com.leapmotion.leap.*;
import java.io.IOException;

/**
 * Classe di test per il LeapMotion.
 * @author Samuele Ganci
 * @version 28 gennaio 2021
 */
public class Leap {
    public static void main(String[] args) {
        // Create a sample listener and controller
        LeapListener listener = new LeapListener();
        Controller controller = new Controller();

        // Have the sample listener receive events from the controller
        controller.addListener(listener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}
