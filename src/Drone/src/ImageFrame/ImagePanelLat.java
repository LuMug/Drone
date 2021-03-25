package ImageFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Pannello numero 3 del frame principale Questo pannello si occupa di gestire
 * la visione laterale del drone.
 *
 * @author Michea Colautti
 * @version 25.03.21
 */
public class ImagePanelLat extends ImageModel implements KeyListener {

    public ImagePanelLat() {
        try {
            imageBig = ImageIO.read(new File("bin/DroneLaterale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    public void moving(int rotDeg) {
        rot = true;
        press = true;

        if (rotDeg < 0) {

            if (rotDeg > -MAXDEG) {

                rotDeg -= 5;
            }
        } else {

            if (rotDeg < MAXDEG) {

                rotDeg += 5;

            }
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        rot = true;
        press = true;
        type = e.getKeyCode();
        if (type == 87) {

            if (rotDeg > -MAXDEG) {

                rotDeg -= 5;
            }
        } else {
            int dum = e.getKeyCode();
            if (dum == 83) {
                type = dum;
            }
            if (type == 83) {
                if (rotDeg < MAXDEG) {

                    rotDeg += 5;
                }
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        press = false;
        while (!press && rotDeg != 0) {
            if (rotDeg > 0) {
                //Thread.sleep(90);
                rotDeg--;
                repaint();
            } else {
                //Thread.sleep(90);
                rotDeg++;
                repaint();
            }
        }
    }
}
