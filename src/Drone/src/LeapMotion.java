
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;
import java.io.IOException;

/**
 * Listener per un controller leap motion.
 *
 * @author Samuele Ganci
 * @version 28 gennaio 2021
 */
public class LeapMotion extends Listener {

    private MessageListener messageListener;

    private BottoniPanel bp;

    public LeapMotion(BottoniPanel bp) {
        this.bp = bp;
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onFrame(Controller controller) {
        try {
            Frame frame = controller.frame();

            if (frame.hands().count() == 2) {
                Hand rightHand = frame.hands().rightmost();
                Hand leftHand = frame.hands().leftmost();
                if (!rightHand.isRight()) {
                    leftHand = frame.hands().rightmost();
                    rightHand = frame.hands().leftmost();
                }
                
                float highCommand = leftHand.palmPosition().getY();
                if (highCommand >= 120 && highCommand <= 180) {
                    System.out.println("Quota costante.");
                    Thread.sleep(500);
                } else if (highCommand < 120) {
                    System.out.println("Perdita di quota.");
                    bp.invioMessaggio("go 0 0 -20 20");
                    Thread.sleep(500);
                } else if (highCommand > 180) {
                    System.out.println("Presa di quota.");
                    bp.invioMessaggio("go 0 0 20 20");
                    Thread.sleep(500);
                }
                
                float pitch = rightHand.direction().pitch();
                float yaw = rightHand.direction().yaw();
                float roll = rightHand.palmNormal().roll();
                if (pitch >= -0.40 && pitch <= 0.40) {
                    //System.out.println("Fermo Asse X.");
                } else if (pitch > 0.40) {
                    //System.out.println("Indietro.");
                } else if (pitch < -0.40) {
                    //System.out.println("Avanti.");
                }
                if (yaw >= -0.20 && yaw <= 0.20) {
                    //System.out.println("Fermo Asse Y.");
                } else if (yaw > 0.20) {
                    //System.out.println("Verso destra.");
                } else if (yaw < -0.20) {
                    //System.out.println("Verso sinistra.");
                }
                if (roll >= -0.40 && roll <= 0.40) {
                    System.out.println("Fermo Asse Z.");
                } else if (roll < -0.40) {
                    System.out.println("Destra.");
                } else if (roll > 0.40) {
                    System.out.println("Sinistra.");
                }
            } else {
                if (!frame.hands().isEmpty()) {
                    Hand hand = frame.hands().get(0);
                    if (hand.isRight()) {
                        float pitch = hand.direction().pitch();
                        float yaw = hand.direction().yaw();
                        float roll = hand.palmNormal().roll();
                        if (pitch >= -0.40 && pitch <= 0.40) {
                            System.out.println("Fermo Asse X.");
                            Thread.sleep(500);
                        } else if (pitch > 0.40) {
                            System.out.println("Indietro.");
                            bp.invioMessaggio("go -20 0 0 40");
                            Thread.sleep(500);
                        } else if (pitch < -0.40) {
                            System.out.println("Avanti.");
                            bp.invioMessaggio("go 20 0 0 40");
                            Thread.sleep(500);
                        }
                        if (yaw >= -0.20 && yaw <= 0.20) {
                            System.out.println("Fermo Asse Y.");
                        } else if (yaw > 0.20) {
                            System.out.println("Rotazione a destra.");
                            bp.invioMessaggio("cw 1");
                        } else if (yaw < -0.20) {
                            System.out.println("Rotazione a sinistra.");
                            bp.invioMessaggio("ccw -1");
                        }
                        if (roll >= -0.40 && roll <= 0.40) {
                            System.out.println("Fermo asse Z.");
                            Thread.sleep(500);
                        } else if (roll < -0.40) {
                            System.out.println("Destra.");
                            bp.invioMessaggio("go 0 20 0 40");
                            Thread.sleep(500);
                        } else if (roll > 0.40) {
                            System.out.println("Sinistra.");
                            bp.invioMessaggio("go 0 -20 0 40");
                            Thread.sleep(500);
                        }
                    } else {
                        float highCommand = hand.palmPosition().getY();
                        if (highCommand >= 120 && highCommand <= 180) {
                            System.out.println("Quota costante.");
                            Thread.sleep(500);
                        } else if (highCommand < 120) {
                            System.out.println("Perdita di quota.");
                            bp.invioMessaggio("go 0 0 -20 40");
                            Thread.sleep(500);
                        } else if (highCommand > 180) {
                            System.out.println("Presa di quota.");
                            bp.invioMessaggio("go 0 0 20 40");
                            Thread.sleep(500);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
