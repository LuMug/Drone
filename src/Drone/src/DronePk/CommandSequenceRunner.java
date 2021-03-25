package DronePk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe utile a ripetere i le sequenze registrate.
 * @author Samuele Ganci
 * @version 25 febbraio 2021
 */
public class CommandSequenceRunner {
    public static final String root = "SequencesRecorded";

    private Path file;
    
    private Drone drone;

    public CommandSequenceRunner(String fileName, Drone drone) {
        file = Paths.get(root + "/" + fileName + ".txt");
        this.drone = drone;
    }

    public void sequenceRepeater() {
        try {
            List<String> lines = Files.readAllLines(file);
            for(String line : lines) {
                drone.invioMessaggio(line);
            }
        } catch (IOException ex) {}
    }
}
