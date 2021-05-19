package DronePk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe utile a ripetere i le sequenze registrate.
 *
 * @author Samuele Ganci
 * @version 25 febbraio 2021
 */
public class CommandSequenceRunner extends Thread {

    /**
     * Costante per il percorso del file.
     */
    public static final String root = "SequencesRecorded";

    /**
     * Variabile per la Path file.
     */
    private Path file;

    /**
     * Istanza della classe drone.
     */
    private Drone drone;

    /**
     * Metodo che si occupa di generare il file.
     *
     * @param fileName Nome del file.
     * @param drone assegnazione dell'istanza drone.
     */
    public CommandSequenceRunner(String fileName, Drone drone) {
        file = Paths.get(root + "/" + fileName + ".txt");
        this.drone = drone;
    }

    /**
     * Metodo che si occupa di ripetere la sequenza.
     */
    public void run() {
        try {
            if (Files.exists(file)) {
                List<String> lines = Files.readAllLines(file);
                for (String line : lines) {
                    drone.invioMessaggio(line);
                    Thread.sleep(125);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error:"+ ex);
        } catch (InterruptedException ex) {
            System.out.println("Error:"+ ex);
        }
    }
}
