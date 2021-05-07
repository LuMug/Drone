package ImageFrame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Pannello numero 3 del frame principale. 
 * Questo pannello si occupa di gestire la visione laterale del drone.
 *
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImagePanelLat extends ImageModel {

    /**
     * Costruttore della classe. Permette di istanziare l'immagine.
     */
    public ImagePanelLat() {
        try {
            imageBig = ImageIO.read(new File("bin/DroneLaterale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    /**
     * Metodo per il movimento dell'immagine. Aggiorna il valore
     * dell'inclinazione, verificando che i valori registrati dal drone non
     * superino l'inclinazione massima permessa dalla costante
     * ImageModel.MAXDEG.
     *
     * @param rotate è l'inclinazione in gradi.
     */
    public void moving(int rotate) {
        if (rotDeg < 0) {

            if (rotate > -MAXDEG) {
                rotDeg = rotate;
                validate();
                repaint();
            }
        } else {

            if (rotate < MAXDEG) {
                rotDeg = rotate;
                validate();
                repaint();
            }
        }
    }
}
