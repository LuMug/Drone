package DronePk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Classe che registra in dei file le sequenze dei comandi. In questo modo e'
 * possibile riprenderle piu' tardi per farle rieseguire al drone.
 *
 * @author Samuele Ganci
 * @version 25 marzo 2021
 */
public class CommandsRecorder {

    public static final String root = "SequencesRecorded";

    private Path file;

    public CommandsRecorder(String fileName) {
        file = Paths.get(root + "/" + fileName + ".txt");
        try {
            Files.write(file, "".getBytes());
        } catch (IOException e) {}
    }

    public void sequenceWriter(String sequence) {
        try {
            Files.write(file, ((sequence + "\r\n")).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {}
    }
}
