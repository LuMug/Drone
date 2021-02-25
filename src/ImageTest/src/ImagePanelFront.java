
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanelFront extends ImageModel implements KeyListener {

    public ImagePanelFront() {
        try {
            imageBig = ImageIO.read(new File("../bin/DroneFrontale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        rot = true;
        press = true;
        type = e.getKeyCode();

        if (type == 37) {

            if (rotDeg > -MAXDEG) {

                rotDeg -= 5;
            }
        } else {
            int dum = e.getKeyCode();
            if (dum == 39) {
                type = dum;
            }
            if (type == 39) {
                if (rotDeg < MAXDEG) {

                    rotDeg += 5;
                }
            }
        }
        repaint();
    }

    public void keyTyped(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e) {
        //try{
        press = false;
        while (!press && rotDeg !=0) {
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
