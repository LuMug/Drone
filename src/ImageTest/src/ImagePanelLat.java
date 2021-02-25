
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanelLat extends ImageModel implements KeyListener {

    public ImagePanelLat() {
        try {
            imageBig = ImageIO.read(new File("../bin/DroneLaterale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        rot = true;
        press = true;
        type = e.getKeyCode();
        if (type == 38) {

            if (rotDeg > -MAXDEG) {

                rotDeg -= 5;
            }
        } else {
            int dum = e.getKeyCode();
            if (dum == 40) {
                type = dum;
            }
            if (type == 40) {
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
