
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanelUp extends ImageModel implements KeyListener {

    public ImagePanelUp() {
        try {
            imageBig = ImageIO.read(new File("../bin/DroneSuperiore.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        panelH = getHeight();
        panelW = getWidth();
        if (panelW < panelH) {
            panelH = panelW;
        } else {
            panelW = panelH;
        }
        image = resize(imageBig, panelW, panelH);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        if (rot) {
            image = resize(imageBig, panelW-50, panelH-50);
            rotatedImage = rotate(image, rotDeg);
            g.drawImage(rotatedImage, x, y, this);
        } else {
            g.drawImage(image, x, y, this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
        //65->A 68->
        //int key1=e.getKeyCode();
        rot = true;
        press = true;
        type = e.getKeyCode();
        if (type == 65) {;
            rotDeg -= 5;
            repaint();
        } else if (type == 68) {
            rotDeg += 5;
            repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

}
