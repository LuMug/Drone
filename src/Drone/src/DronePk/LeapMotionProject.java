package DronePk;

import com.leapmotion.leap.*;

public class LeapMotionProject extends Listener {

    /**
     * Contiene il drone impostato.
     */
    private Drone drone;

    /**
     * Contiene se si sta registrando la sequenza o meno.
     */
    private boolean comReqSeq = false;

    /**
     * Contiene la classe per registrare la sequenza.
     */
    private CommandsRecorder cr;

    /**
     * Contiene il pannello funzioni panel.
     */
    private FunzionePanel funzionePanel;

    /**
     * Definisce se il drone e' in volo o meno.
     */
    private boolean inFlight = false;

    /**
     * Costruttore personalizzato.
     *
     * @param drone da impostare
     * @param funzionePanel da impostare
     */
    public LeapMotionProject(Drone drone, FunzionePanel funzionePanel) {
        this.drone = drone;
        this.funzionePanel = funzionePanel;
        funzionePanel.setLM(this);
    }

    /**
     * Metodo richiamato ogni volta che il leap motion registra un nuovo dato.
     *
     * @param controller che gestisce il leap motion
     */
    public void onFrame(Controller controller) {
        Frame frame = controller.frame();
        Hand rightHand = null;
        Hand leftHand = null;
        Finger rightHandIndexFinger = null;
        Finger rightHandMiddleFinger = null;
        Finger leftHandIndexFinger = null;
        Finger leftHandMiddleFinger = null;
        String command = "";
        float highCommand = 0;
        float pitch = 0;
        float yaw = 0;
        float roll = 0;
        int highSpeed = 0;
        int pitchSpeed = 0;
        int rollSpeed = 0;
        int yawSpeed = 0;
        if (frame.hands().count() > 0) {
            Hand hand = frame.hands().get(0);
            if (hand.isRight()) {
                rightHand = frame.hands().rightmost();
                rightHandMiddleFinger = rightHand.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0);
            } else {
                leftHand = frame.hands().leftmost();
                leftHandMiddleFinger = leftHand.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0);
            }
            if (frame.hands().count() == 2) {
                rightHand = frame.hands().rightmost();
                leftHand = frame.hands().leftmost();
                if (!rightHand.isRight()) {
                    leftHand = frame.hands().rightmost();
                    rightHand = frame.hands().leftmost();
                }
                rightHandIndexFinger = rightHand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
                leftHandIndexFinger = leftHand.fingers().fingerType(Finger.Type.TYPE_INDEX).get(0);
                rightHandMiddleFinger = rightHand.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0);
                leftHandMiddleFinger = leftHand.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0);
            }
        }
        if (leftHand != null) {
            highCommand = leftHand.palmPosition().getY();
        }
        if (rightHand != null) {
            pitch = rightHand.direction().pitch();
            yaw = rightHand.direction().yaw();
            roll = rightHand.palmNormal().roll();
        }
        if (rightHand == null || leftHand == null) {
            command = "rc 0 0 0 0";
            sendMessage(command);
            command = "land";
            sendMessage(command);
            inFlight = false;
        }
        if (!rightHandIndexFinger.isExtended()) {
            inFlight = true;
            command = "takeoff";
            sendMessage(command);
        } else if (!rightHandMiddleFinger.isExtended()) {
            command = "rc 0 0 0 0";
            sendMessage(command);
            command = "land";
            sendMessage(command);
            inFlight = false;
        }
        if (!leftHandIndexFinger.isExtended()) {
            if (!comReqSeq) {
                if (!inFlight) {
                    comReqSeq = true;
                    cr = new CommandsRecorder(funzionePanel.getSeqNameSave());
                    funzionePanel.refreshCommandsF("REC ON: " + funzionePanel.getSeqNameSave() + "\n");
                }
            }
        } else if (!leftHandMiddleFinger.isExtended()) {
            if (comReqSeq) {
                if (!inFlight) {
                    comReqSeq = false;
                    funzionePanel.refreshCommandsF("REC OFF: " + funzionePanel.getSeqNameSave() + "\n");
                }
            }
        }
        if (betweenExcluded(pitch, -0.25, 0.25)
                && betweenExcluded(roll, -0.40, 0.40)
                && betweenExcluded(yaw, -0.35, 0.15)
                && betweenExcluded(highCommand, 175, 225)) {
            command = "rc 0 0 0 0";
            sendMessage(command);
        } else {
            if (pitch >= 0.25) {
                if (pitch <= 0.60) {
                    pitchSpeed = -1 * convertRange(pitch, 0.25, 0.60, 10, 100);
                } else {
                    pitchSpeed = -100;
                }
            } else if (pitch <= -0.25) {
                if (pitch >= -0.60) {
                    pitchSpeed = convertRange(pitch, -0.25, -0.60, 10, 100);
                } else {
                    pitchSpeed = 100;
                }
            }
            if (roll <= -0.40) {
                if (roll >= -0.75) {
                    rollSpeed = convertRange(roll, -0.40, -0.75, 10, 100);
                } else {
                    rollSpeed = 100;
                }
            } else if (roll >= 0.40) {
                if (roll <= 0.75) {
                    rollSpeed = -1 * convertRange(roll, 0.40, 0.75, 10, 100);
                } else {
                    rollSpeed = -100;
                }
            }
            if (yaw >= 0.15) {
                if (yaw <= 0.25) {
                    yawSpeed = convertRange(yaw, 0.15, 0.25, 10, 100);
                } else {
                    yawSpeed = 100;
                }
            } else if (yaw <= -0.35) {
                if (yaw >= -0.75) {
                    yawSpeed = -1 * convertRange(yaw, -0.35, -0.75, 10, 100);
                } else {
                    yawSpeed = -100;
                }
            }
            if (highCommand <= 175) {
                if (highCommand != 0) {
                    if (highCommand < 75) {
                        highSpeed = -100;
                    } else {
                        highSpeed = -1 * (110 - convertRange(highCommand, 75, 175, 10, 100));
                    }
                }
            } else if (highCommand >= 225) {
                if (highCommand > 325) {
                    highSpeed = 100;
                } else {
                    highSpeed = convertRange(highCommand, 225, 325, 10, 100);
                }
            }
            command = "rc " + rollSpeed + " " + pitchSpeed + " " + highSpeed + " " + yawSpeed;
            sendMessage(command);
        }
    }

    /**
     * Metodo utile ad inviare i comandi al drone.
     *
     * @param command da inviare.
     */
    public void sendMessage(String command) {
        try {
            if (inFlight) {
                drone.invioMessaggio(command);
                Thread.sleep(125);
                if (comReqSeq) {
                    cr.sequenceWriter(command);
                }
            }
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    /**
     * Converte il valore di un range in un valore di un altro range.
     *
     * @param value da mappare nel primo range
     * @param r1Min valore minimo del primo range
     * @param r1Max valore massimo del primo range
     * @param r2Min valore minimo del secondo range
     * @param r2Max valore massimo del secondo range
     * @return valore mappato nel secondo range
     */
    public int convertRange(double value, double r1Min, double r1Max, double r2Min, double r2Max) {
        return (int) (((value - r1Min) * (r2Max - r2Min)) / (r1Max - r1Min) + r2Min);
    }

    /**
     * Ritorna se il valore passato e' all'interno del range, minimo e massimo
     * escluso.
     *
     * @param value da controllare
     * @param min da controllare
     * @param max da controllare
     * @return se il valore e' o meno nel range
     */
    public boolean betweenExcluded(double value, double min, double max) {
        if (value > min && value < max) {
            return true;
        } else {
            return false;
        }
    }
}
