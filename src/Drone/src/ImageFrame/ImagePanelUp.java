package ImageFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

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
    
    private ImageIcon icon;

    /**
     * Costruttore della classe. Permette di istanziare l'immagine.
     */
    public ImagePanelUp() {
        //aggiunto riferimento a bin in class path e path di libreria
        ImageIcon icon;
        icon = new ImageIcon(getClass().getClassLoader().getResource("DroneSuperiore.png"));
        Image image = icon.getImage();
        imageBig=toBufferedImage(image);
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

        if (imageBig != null) {
            image = resize(imageBig, panelW - 95, panelH - 95);
            int x = (this.getWidth() - image.getWidth()) / 2;
            int y = (this.getHeight() - image.getHeight()) / 2;

            rotatedImage = rotate(image, deg);
            g.drawImage(rotatedImage, x, y, this);
            
        }

    }
}
