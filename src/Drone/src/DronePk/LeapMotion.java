package DronePk;


import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

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
    private Drone drone;

    /**
     * Contiene se il drone è in volo o meno.
     */
    private boolean inFlight = false;
    
    /**
     * Costruttore della classe
     *
     * @param drone riferimento del contenitore
     */
    public LeapMotion(Drone drone) {
        this.drone = drone;
    }

    /**
     * Viene richiamato quando viene connesso un controller.
     *
     * @param controller connesso
     */
    public void onConnect(Controller controller) {
        System.out.println("LeapMotion Connected");
        System.out.println("------------------------");
    }

    /**
     * Viene richiamato quando un nuovo pacchetto di dati arriva.
     *
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
            int highSpeed = 0;

            //Controlla tutto ciò che è il movimento orizzontale del drone
            float pitch = rightHand.direction().pitch();
            float yaw = rightHand.direction().yaw();
            float roll = rightHand.palmNormal().roll();
            int pitchSpeed = 0;
            int rollSpeed = 0;
            int yawSpeed = 0;
            if (betweenExcluded(pitch, -0.25, 0.25)
                    && betweenExcluded(roll, -0.40, 0.40)
                    && betweenExcluded(yaw, -0.45, 0.45)
                    && betweenExcluded(highCommand, 175, 225)) {
                drone.invioMessaggio("rc 0 0 0 0");
            } else {
                if (pitch >= 0.25) {

                    //Indietro
                    if (pitch <= 0.60) {
                        pitchSpeed = -1 * convertRange(pitch, 0.25, 0.60, 10, 100);
                    } else {
                        pitchSpeed = -100;
                    }
                } else if (pitch <= -0.25) {

                    //Avanti
                    if (pitch >= -0.60) {
                        pitchSpeed = convertRange(pitch, -0.25, -0.60, 10, 100);
                    } else {
                        pitchSpeed = 100;
                    }
                }

                //Gestione comandi asse Z (destra e sinistra)
                if (roll <= -0.40) {

                    //Destra
                    if (roll >= -0.75) {
                        rollSpeed = convertRange(roll, -0.40, -0.75, 10, 100);
                    } else {
                        rollSpeed = 100;
                    }
                } else if (roll >= 0.40) {

                    //Sinistra
                    if (roll <= 0.75) {
                        rollSpeed = -1 * convertRange(roll, 0.40, 0.75, 10, 100);
                    } else {
                        rollSpeed = -100;
                    }
                }

                //Gestione comandi su asse Y (rotazione destra e sinistra)
                if (yaw >= 0.35) {
                    //Rotazione a destra
                    if (yaw <= 1) {
                        yawSpeed = convertRange(yaw, 0.45, 1, 10, 100);
                    } else {
                        yawSpeed = 100;
                    }
                } else if (yaw <= -0.45) {
                    //Rotazione a sinistra
                    if (yaw >= -1) {
                        yawSpeed = -1 * convertRange(yaw, -0.45, -1, 10, 100);
                    } else {
                        yawSpeed = -100;
                    }
                }

                if (highCommand <= 175) {
                    if (highCommand < 75) {
                        highSpeed = 100;
                    } else {
                        highSpeed = 110 - convertRange(highCommand, 75, 175, 10, 100);
                    }
                } else if (highCommand >= 225) {
                    if (highCommand > 325) {
                        highSpeed = 100;
                    } else {
                        highSpeed = convertRange(highCommand, 225, 325, 10, 100);
                    }
                }

                drone.invioMessaggio("rc " + rollSpeed + " " + pitchSpeed + " " + highSpeed + " " + yawSpeed);
            }

        } else if (frame.hands().count() == 1) {

            //Prende il riferimento della mano
            Hand hand = frame.hands().get(0);

            //Controlla se è la mano destra o sinistra
            if (hand.isRight()) {
                int speed = 0;
                float pitch = hand.direction().pitch();
                float roll = hand.palmNormal().roll();
                float yaw = hand.direction().yaw();
                int pitchSpeed = 0;
                int rollSpeed = 0;
                int yawSpeed = 0;

                if (betweenExcluded(pitch, -0.25, 0.25)
                        && betweenExcluded(roll, -0.40, 0.40)
                        && betweenExcluded(yaw, -0.45, 0.45)) {
                    FingerList indexFingerList = hand.fingers().fingerType(Finger.Type.TYPE_INDEX);
                    Finger indexFinger = indexFingerList.get(0);
                    if(indexFinger.isExtended()) {
                        drone.invioMessaggio("rc 0 0 0 0");
                    }else{
                        if(inFlight) {
                            drone.invioMessaggio("land");
                            inFlight = false;
                        }else{
                            drone.invioMessaggio("takeoff");
                            inFlight = true;
                        }
                    }

                } else {
                    if (pitch >= 0.25) {

                        //Indietro
                        if (pitch <= 0.60) {
                            pitchSpeed = -1 * convertRange(pitch, 0.25, 0.60, 10, 100);
                        } else {
                            pitchSpeed = -100;
                        }
                    } else if (pitch <= -0.25) {

                        //Avanti
                        if (pitch >= -0.60) {
                            pitchSpeed = convertRange(pitch, -0.25, -0.60, 10, 100);
                        } else {
                            pitchSpeed = 100;
                        }
                    }

                    //Gestione comandi asse Z (destra e sinistra)
                    if (roll <= -0.40) {

                        //Destra
                        if (roll >= -0.75) {
                            rollSpeed = convertRange(roll, -0.40, -0.75, 10, 100);
                        } else {
                            rollSpeed = 100;
                        }
                    } else if (roll >= 0.40) {

                        //Sinistra
                        if (roll <= 0.75) {
                            rollSpeed = -1 * convertRange(roll, 0.40, 0.75, 10, 100);
                        } else {
                            rollSpeed = -100;
                        }
                    }

                    //Gestione comandi su asse Y (rotazione destra e sinistra)
                    if (yaw >= 0.35) {
                        //Rotazione a destra
                        if (yaw <= 1) {
                            yawSpeed = convertRange(yaw, 0.45, 1, 10, 100);
                        } else {
                            yawSpeed = 100;
                        }
                    } else if (yaw <= -0.45) {
                        //Rotazione a sinistra
                        if (yaw >= -1) {
                            yawSpeed = -1 * convertRange(yaw, -0.45, -1, 10, 100);
                        } else {
                            yawSpeed = -100;
                        }
                    }
                    drone.invioMessaggio("rc " + rollSpeed + " " + pitchSpeed + " 0 " + yawSpeed);
                }
            } else {

                //Gestione comandi verticali
                float highCommand = hand.palmPosition().getY();
                int speed = 0;
                if (highCommand <= 175) {
                    if (highCommand < 75) {
                        speed = 100;
                        drone.invioMessaggio("rc 0 0 -" + speed + " 0");
                    } else {
                        speed = 110 - convertRange(highCommand, 75, 175, 10, 100);
                        drone.invioMessaggio("rc 0 0 -" + speed + " 0");
                    }
                } else if (highCommand >= 225) {
                    if (highCommand > 325) {
                        speed = 100;
                        drone.invioMessaggio("rc 0 0 " + speed + " 0");
                    } else {
                        speed = convertRange(highCommand, 225, 325, 10, 100);
                        drone.invioMessaggio("rc 0 0 " + speed + " 0");
                    }
                } else {
                    drone.invioMessaggio("rc 0 0 0 0");
                }
            }

        } else {
            drone.invioMessaggio("rc 0 0 0 0");
        }
    }

    /**
     * Ritorna un valore convertito da un range ad un altro range
     *
     * @param value da convertire
     * @param r1 massimo del range iniziale
     * @param r2 massimo del range finale
     * @param m1 minimo del range iniziale
     * @param m2 massimo del range finale
     * @return valore convertito
     */
    public int convertRange(double value, double r1Min, double r1Max, double r2Min, double r2Max) {
        return (int) (((value - r1Min) * (r2Max - r2Min)) / (r1Max - r1Min) + r2Min);
    }

    /**
     * Ritorna se il valore è tra nel range passato, (esclusi il max e min).
     *
     * @param value da controllare
     * @param min valore minimo
     * @param max valore massimo
     * @return true se il valore è incluso, altrimenti false
     */
    public boolean betweenExcluded(double value, double min, double max) {
        if (value > min && value < max) {
            return true;
        } else {
            return false;
        }
    }
}
