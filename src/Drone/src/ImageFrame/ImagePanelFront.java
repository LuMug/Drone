package ImageFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Pannello numero 1 del frame principale Questo pannello si occupa di gestire
 * la visione anteriore del drone.
 *
 * @author Michea Colautti
 * @version 25.03.21
 */
public class ImagePanelFront extends ImageModel implements KeyListener {

    public ImagePanelFront() {
        try {
            imageBig = ImageIO.read(new File("src/ImageFrame/bin/DroneFrontale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }
    
    public void moving(int rotDeg){
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

        if (type == 65) {

            if (rotDeg > -40) {

                rotDeg -= 5;
            }
        } else {
            int dum = e.getKeyCode();
            if (dum == 68) {
                type = dum;
            }
            if (type == 68) {
                if (rotDeg < 40) {

                    rotDeg += 5;
                }
            }
        }
        repaint();
    }
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //try{
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
        //}catch(InterruptedException ex){}
    }
}
