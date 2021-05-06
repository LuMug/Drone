package ImageFrame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Pannello numero 4 del frame principale. Questo pannello si occupa di gestire
 * l'incremento/decremento del valore dell'altitudine.
 *
 * @author Michea Colautti
 * @version 04.04.21
 */
public class ImagePanelAlt extends ImageModel {

    /**
     * Label contenente l'altitudine e l'unità di misura.
     */
    public JLabel alt;

    /**
     * Label contenente lèetichetta dell'altezza.
     */
    public JLabel mis;

    /**
     * Valore contenente l'altitudine.
     */
    private double altitude = 0;

    /**
     * Costruttore della classe. Permette di istanziare le due immagini e
     * richiama 'initComponents'.
     */
    public ImagePanelAlt() {
        initComponents();

    }

    /**
     * Questo metodo permette di impostare correttamente il pannello. Assegna il
     * layout al pannello, crea un nuovo font personalizzato e lo assegna la
     * label. Aggiunge poi lo stesso al pannello.
     */
    private void initComponents() {

        GridLayout ImageFrameLayout = new GridLayout(0, 2);
        setLayout(ImageFrameLayout);
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        mis = new JLabel();
        mis.setFont(font1);
        mis.setHorizontalAlignment(JTextField.LEFT);
        add(mis);
        alt = new JLabel(altitude + "");
        alt.setFont(font1);
        alt.setHorizontalAlignment(JTextField.CENTER);
        add(alt);

    }

    /**
     * Metodo per disegnare le componenti sul frame. Permette di disegnare le
     * due frecce e il JLabel contenente l'altitudine nelle varie unità di
     * misura.
     *
     * @param g è il parametro di default per la grafica.
     */
    public void paintComponent(Graphics g) {
        panelH = getHeight();
        panelW = getWidth();

        g.clearRect(0, 0, panelW, panelH);
        
        if (panelW > panelH) {
            panelW = panelH;
            
        }else{
            panelH=panelW;
        }

        int x = 0, y = 0;

        mis.setText("    H: ");
        double stAlt = altitude;

        String text = altitude + " cm" + '\n'
                + altitude / 100 + " m" + "\n"
                + stAlt / 30.48 + " ft";

        alt.setText("<html>" + text.replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\n", "<br/>") + "</html>");

    }

    /**
     * Metodo setter dell'altitudine. Similmente ai setter presenti in
     * ImageFrame questo metodo serve per aggiornare l'altitudine. Metodo
     * richimato da 'ImageFrame'.
     *
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
