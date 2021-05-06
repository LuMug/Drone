package ImageFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Pannello numero 2 del frame principale. Questo pannello si occupa di gestire
 * la visione superiore del drone. NB: ho usato un approccio diverso rispetto ai
 * due pannelli 'ImagePanelLat' e 'ImagePanelFront', poichè il drone, visto
 * dalla prospettiva rappresentata tramite quest'immagine, si comporta in modo
 * diverso rispetto ai casi precedenti. Quidndi cambia anche il modo in cui
 * richiamo la movenza dell'immagine.
 *
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImagePanelUp extends ImageModel {

    /**
     * I gradi di rotazione dell'immagine.
     */
    public int deg;

    /**
     * Costruttore della classe. Permette di istanziare l'immagine.
     */
    public ImagePanelUp() {
        try {
            imageBig = ImageIO.read(new File("src/ImageFrame/bin/DroneSuperiore.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    @Override
    /**
     * Metodo che mi peremtte di disegnare le componenti. Non eseguo un
     * controllo sui gradi massimi poichè quest'immagine è libera di muoversi su
     * 360 gradi.
     */
    public void paintComponent(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);

        panelH = getHeight();
        panelW = getWidth();
        if (panelW > panelH) {
            panelW = panelH;

        } else {
            panelH = panelW;
        }

        image = resize(imageBig, panelW - 85, panelH - 85);
        int x = (this.getWidth() - image.getWidth()) / 2;
        int y = (this.getHeight() - image.getHeight()) / 2;

        rotatedImage = rotate(image, deg);
        g.drawImage(rotatedImage, x - 20, y - 25, this);

    }
}
