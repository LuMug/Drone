package DronePk;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Classe che si occupa di log.
 *
 * @author Alessandro Aloise
 * @version 11.03.2021
 */
public class Log {

    public static FileWriter fw;
    public static File file;

    public void creazioneFile() {
        try {
            Date data = new Date();
            DateFormat dateFormat;
            dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ITALY);
            String path = "log/Log_" + dateFormat.format(data).replace(' ', '_') + ".log";
            file = new File(path);
            file.createNewFile();
            fw = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println("Error file già esistente");
        }
    }

    public void scritturaFile(String testo) {
        try {
            fw.write(testo + '\n');
            fw.flush();

        } catch (IOException e) {
            System.out.println("Error: stringa non valida");
        }
    }

    public void chiusuraFile() {
        try {
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error: stringa non valida");
        }
    }
}
