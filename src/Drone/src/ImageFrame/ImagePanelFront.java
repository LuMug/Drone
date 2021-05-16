package ImageFrame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Pannello numero 1 del frame principale. Questo pannello si occupa di gestire
 * la visione anteriore del drone.
 *
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImagePanelFront extends ImageModel {

    /**
     * Costruttore della classe. Permette di istanziare l'immagine.
     */
    public ImagePanelFront() {
        //aggiunto riferimento a bin in class path e path di libreria
        ImageIcon icon;
        icon = new ImageIcon(getClass().getClassLoader().getResource("DroneFrontale.png"));
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

        if (rotate < 0) {

            if (rotate >= -MAXDEG) {
                rotDeg = -rotate;
                validate();
                repaint();
            }
        } else {
            if (rotate <= MAXDEG) {
                rotDeg = -1 * rotate;
                validate();
                repaint();
            }
        }
    }
}
