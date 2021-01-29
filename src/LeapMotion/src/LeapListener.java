
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

/**
 * Listener per un controller leap motion.
 *
 * @author Samuele Ganci
 * @version 28 gennaio 2021
 */
public class LeapListener extends Listener {

    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onFrame(Controller controller) {
        Frame frame = controller.frame();

        if (frame.hands().count() == 2) {
            Hand rightHand = frame.hands().rightmost();
            Hand leftHand = frame.hands().leftmost();
            if (!rightHand.isRight()) {
                leftHand = frame.hands().rightmost();
                rightHand = frame.hands().leftmost();
            }
            float highCommand = leftHand.palmPosition().getY();
            if (highCommand < 120) {
                System.out.println("Perdita di quota.");
            } else if (highCommand > 180) {
                System.out.println("Presa di quota.");
            } else {
                System.out.println("Quota costante.");
            }
            float pitch = rightHand.direction().pitch();
            float yaw = rightHand.direction().yaw();
            float roll = rightHand.palmNormal().roll();
            if (pitch > 0.40) {
                System.out.println("Indietro.");
            } else if (pitch < -0.40) {
                System.out.println("Avanti.");
            } else {
                System.out.println("Fermo Asse X.");
            }
            if (yaw > 0.20) {
                System.out.println("Verso destra.");
            } else if (yaw < -0.20) {
                System.out.println("Verso sinistra.");
            } else {
                System.out.println("Fermo Asse Y.");
            }
            if (roll < -0.40) {
                System.out.println("Destra.");
            } else if (roll > 0.40) {
                System.out.println("Sinistra.");
            } else {
                System.out.println("Fermo Asse Z.");
            }
        } else {
            Hand hand = frame.hands().get(0);
            if (hand.isRight()) {
                float pitch = hand.direction().pitch();
                float yaw = hand.direction().yaw();
                float roll = hand.palmNormal().roll();
                if (pitch > 0.40) {
                    System.out.println("Indietro.");
                } else if (pitch < -0.40) {
                    System.out.println("Avanti.");
                } else {
                    System.out.println("Fermo Asse X.");
                }
                if (yaw > 0.20) {
                    System.out.println("Verso destra.");
                } else if (yaw < -0.20) {
                    System.out.println("Verso sinistra.");
                } else {
                    System.out.println("Fermo Asse Y.");
                }
                if (roll < -0.40) {
                    System.out.println("Destra.");
                } else if (roll > 0.40) {
                    System.out.println("Sinistra.");
                } else {
                    System.out.println("Fermo Asse Z.");
                }
            } else {
                float highCommand = hand.palmPosition().getY();
                if (highCommand < 120) {
                    System.out.println("Perdita di quota.");
                } else if (highCommand > 180) {
                    System.out.println("Presa di quota.");
                } else {
                    System.out.println("Quota costante.");
                }
            }
        }
    }
}
