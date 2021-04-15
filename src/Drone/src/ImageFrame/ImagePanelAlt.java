package ImageFrame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Pannello numero 4 del frame principale. 
 * Questo pannello si occupa di gestire l'incremento/decremento del valore 
 * dell'altitudine.
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImagePanelAlt extends ImageModel {

    /**
     * L'immagine contenete la freccia verso l'alto.
     */
    public BufferedImage up;

    /**
     * L'immagine contenete la freccia verso il basso.
     */
    public BufferedImage down;

    /**
     * Label contenente l'altitudine e l'unità di misura.
     */
    public JLabel alt;

    /**
     * Valore contenente l'altitudine.
     */
    private int altitude = 0;

    /**
     * Costruttore della classe. Permette di istanziare le due immagini e
     * richiama 'initComponents'.
     */
    public ImagePanelAlt() {
        try {
            up = ImageIO.read(new File("src/ImageFrame/bin/Frecce/Up.png"));
            down = ImageIO.read(new File("src/ImageFrame/bin/Frecce/Down.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
        initComponents();

    }

    /**
     * Questo metodo permette di impostare correttamente il pannello. Assegna il
     * layout al pannello, crea un nuovo font personalizzato e lo assegna la
     * label. Aggiunge poi lo stesso al pannello.
     */
    private void initComponents() {

        GridLayout ImageFrameLayout = new GridLayout(0, 3);
        setLayout(ImageFrameLayout);
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        alt = new JLabel(altitude + "");
        alt.setFont(font1);
        alt.setHorizontalAlignment(JTextField.CENTER);
        add(alt);

    }

    /**
     * Metodo per disegnare le componenti sul frame. 
     * Permette di disegnare le due frecce e il JLabel contenente 
     * l'altitudine nelle varie unità di misura.
     *
     * @param g è il parametro di default per la grafica.
     */
    public void paintComponent(Graphics g) {
        panelH = getHeight();
        panelW = getWidth();

        g.clearRect(0, 0, panelW, panelH);

        if (panelW > panelH) {
            panelW = panelH;
            panelW /= 2;
        }

        int x = 0, y = 0;

        up = resize(up, panelW, panelH);
        down = resize(down, panelW, panelH);
        x = (this.getWidth() - up.getWidth(null)) / 2;
        y = (this.getHeight() - down.getHeight(null)) / 2;
        g.drawImage(up, x, y, this);
        g.drawImage(down, x + panelW, y, this);
        String text = altitude + " cm" + '\n'
                + altitude / 100 + " m" + "\n"
                + +altitude * 3.281 + " ft";

        alt.setText("<html>" + text.replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\n", "<br/>") + "</html>");

    }

    /**
     * Metodo setter dell'altitudine.
     * Similmente ai setter presenti in ImageFrame questo metodo serve
     * per aggiornare l'altitudine. Metodo richimato da 'ImageFrame'.
     * @param newAlt è il nuovo valore dell'altitudine.
     */
    public void setAltitude(int newAlt) {
        if (newAlt > 1000) {
            newAlt = 1000;
        }
        altitude = newAlt;
        repaint();
    }
}
