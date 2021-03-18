
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author micheacolautti
 */
public class Altitudine extends ImageModel implements KeyListener {

    public BufferedImage up;
    public BufferedImage down;
    public JLabel alt;
    private short altitude = 0;

    public Altitudine() {
        try {
            up = ImageIO.read(new File("bin/Frecce/Up.png"));
            down = ImageIO.read(new File("bin/Frecce/Down.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
        initComponents();

    }

    public void paintComponent(Graphics g) {
        panelH = getHeight();
        panelW = getWidth();
        height = panelH;
        width = panelW;
        g.clearRect(0, 0, width, height);

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
        alt.setText(altitude + " m");

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        press = true;
        type = e.getKeyCode();

        if (type == 40) {

            if (altitude > 0) {

                altitude--;
            }
        } else {

            if (type == 38) {
                altitude++;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        press = false;
    }

    private void initComponents() {

        GridLayout ImageFrameLayout = new GridLayout(0, 3);
        setLayout(ImageFrameLayout);
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        alt = new JLabel(altitude + " m");
        alt.setFont(font1);
        alt.setHorizontalAlignment(JTextField.CENTER);
        add(alt);

    }

}
