package ImageFrame;

import static ImageFrame.ImageModel.toBufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;

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
        //aggiunto riferimento a bin in class path e path di libreria
        ImageIcon icon;
        icon = new ImageIcon(getClass().getClassLoader().getResource("DroneLaterale.png"));
        Image image = icon.getImage();
        imageBig=toBufferedImage(image);
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
