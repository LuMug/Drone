
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

    /**
     * Riferimento alla contenitore.
     */
    private BottoniPanel bp;

    /**
     * Costruttore della classe
     * @param bp riferimento del contenitore
     */
    public LeapMotion(BottoniPanel bp) {
        this.bp = bp;
    }

    /**
     * Viene richiamato quando viene connesso un controller.
     * @param controller connesso
     */
    public void onConnect(Controller controller) {
        System.out.println("LeapMotion Connected");
        System.out.println("------------------------");
    }

    /**
     * Viene richiamato quando un nuovo pacchetto di dati arriva.
     * @param controller connesso
     */
    public void onFrame(Controller controller) {
            //Legge il pacchetto
            Frame frame = controller.frame();

            //Verifica se ci sono 2 mani
            if (frame.hands().count() == 2) {
                
                //Assegna la mano destra e la mano sinistra
                Hand rightHand = frame.hands().rightmost();
                Hand leftHand = frame.hands().leftmost();
                if (!rightHand.isRight()) {
                    leftHand = frame.hands().rightmost();
                    rightHand = frame.hands().leftmost();
                }
                
                //Gestisce il comando per alzare o abbassare il drone
                float highCommand = leftHand.palmPosition().getY();
                
                //Controlla tutto ciò che è il movimento orizzontale del drone
                float pitch = rightHand.direction().pitch();
                float yaw = rightHand.direction().yaw();
                float roll = rightHand.palmNormal().roll();
                
            } else {
                
                //Richiamato quando solo una mano è presente
                if (!frame.hands().isEmpty()) {
                    
                    //Prende il riferimento della mano
                    Hand hand = frame.hands().get(0);
                    
                    //Controlla se è la mano destra o sinistra
                    if (hand.isRight()) {
                        int speed = 0;
                        
                        //Gestione comandi su asse X (avanti e indietro)
                        float pitch = hand.direction().pitch();
                        if (pitch >= 0.25) {
                            System.out.println("Indietro.");
                            System.out.println(pitch);
                            if(pitch <= 0.60) {
                                speed = convertRange(pitch, 0.35, 0.60, 10, 60);
                                bp.invioMessaggio("go -20 0 0 " + speed);
                            }else{
                                speed = 60;
                                bp.invioMessaggio("go -20 0 0 " + speed);
                            }
                        } else if (pitch <= -0.25) {
                            System.out.println("Avanti.");
                            System.out.println(pitch);
                            if(pitch >= -0.60) {
                                speed = convertRange(pitch, -0.35, -0.60, 10, 60);
                                bp.invioMessaggio("go -20 0 0 " + speed);
                            }else{
                                speed = 60;
                                bp.invioMessaggio("go -20 0 0 " + speed);
                            }
                        }
                        
                        //Gestione comandi su asse Y (rotazione destra e sinistra)
//                        float yaw = hand.direction().yaw();
//                        if (yaw >= -0.20 && yaw <= 0.20) {
//                            System.out.println("Fermo Asse Y.");
//                        } else if (yaw > 0.20) {
//                            System.out.println("Rotazione a destra.");
//                            bp.invioMessaggio("cw 1");
//                        } else if (yaw < -0.20) {
//                            System.out.println("Rotazione a sinistra.");
//                            bp.invioMessaggio("ccw -1");
//                        }
                        
                        //Gestione comandi asse Z (destra e sinistra)
                        float roll = hand.palmNormal().roll();
                        if (roll <= -0.40) {
                            System.out.println("Destra.");
                            System.out.println(roll);
                            if(roll >= -0.60) {
                                speed = convertRange(roll, -0.40, -0.60, 10, 60);
                                bp.invioMessaggio("go 0 20 0 " + speed);
                            }else{
                                speed = 60;
                                bp.invioMessaggio("go 0 20 0 " + speed);
                            }
                        } else if (roll >= 0.40) {
                            System.out.println("Sinistra.");
                            System.out.println(roll);
                            if(roll <= 0.60) {
                                speed = convertRange(roll, 0.40, 0.60, 10, 60);
                                bp.invioMessaggio("go 0 -20 0 " + speed);
                            }else{
                                speed = 60;
                                bp.invioMessaggio("go 0 -20 0 " + speed);
                            }
                        }
                        
                    } else {
                        
                        //Gestione comandi verticali
                        float highCommand = hand.palmPosition().getY();
                        int speed = 0;
                        if(highCommand <= 175) {
                            if(highCommand < 75) {
                                speed = 60;
                                bp.invioMessaggio("go 0 0 -40 " + speed);
                            }else{
                                speed = 70 - convertRange((int)highCommand, 75, 175, 10, 60);
                                bp.invioMessaggio("go 0 0 -40 " + speed);
                            }
                        }else if(highCommand >= 225){
                            if(highCommand > 325) {
                                speed = 60;
                                bp.invioMessaggio("go 0 0 40 " + speed);
                            }else{
                                speed = convertRange(highCommand, 225, 325, 10, 60);
                                bp.invioMessaggio("go 0 0 40 " + speed);
                            }
                        }else{
                            bp.invioMessaggio("stop");
                        }
                    }
                }
            }
    }
    
    /**
     * Ritorna un valore convertito da un range ad un altro range
     * @param value da convertire
     * @param r1 massimo del range iniziale
     * @param r2 massimo del range finale
     * @param m1 minimo del range iniziale
     * @param m2 massimo del range finale
     * @return valore convertito
     */
    public int convertRange(double value, double r1Min, double r1Max, double r2Min, double r2Max) {
        return (int)(((value - r1Min) * (r2Max - r2Min)) / (r1Max - r1Min) + r2Min);
    }
}
