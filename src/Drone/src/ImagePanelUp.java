
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
            imageBig = ImageIO.read(new File("bin/DroneSuperiore.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(),getHeight());
        
        panelH = getHeight();
        panelW = getWidth();
        if (panelW < panelH) {
            panelH = panelW;
        } else {
            panelW = panelH;
        }
        image = resize(imageBig, panelW-65, panelH-65);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        if (rot) {
            //image = resize(imageBig, panelW-50, panelH-50);
            rotatedImage = rotate(image, rotDeg);
            g.drawImage(rotatedImage, x, y-25, this);
        } else {
            g.drawImage(image, x, y-25, this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {
        rot = true;
        press = true;
        type = e.getKeyCode();
        if (type == 37) {;
            rotDeg -= 5;
            repaint();
        } else if (type == 39) {
            rotDeg += 5;
            repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

}
