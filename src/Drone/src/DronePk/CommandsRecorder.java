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

    /**
     * Costante per il percorso del file.
     */
    public static final String root = "SequencesRecorded";

    /**
     * Variabile per la Path file.
     */
    private Path file;

    /**
     * Metodo che si occupa di registrare la sequenza di comandi.
     *
     * @param fileName Il nome del file.
     */
    public CommandsRecorder(String fileName) {
        file = Paths.get(root + "/" + fileName + ".txt");
        try {
            Files.write(file, "".getBytes());
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    /**
     * Metodo che si occuopa di scrivere la sequenza.
     *
     * @param sequence sequenza da scrivere nel file.
     */
    public void sequenceWriter(String sequence) {
        try {
            Files.write(file, ((sequence + "\r\n")).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}
