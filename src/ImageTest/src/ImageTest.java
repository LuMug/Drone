
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;

/**
 * Questa classe permette di importare un immagine in un frame. Le immagini sono
 * nella cartella /bin. Modificabile dalle propità del progetto
 *
 * @author micheacolautti
 * @version 4.2.21
 */
public class ImageTest extends Canvas {

    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        
        //g.drawImage(i, 10,60,this);
        String[] foto = {
            "right.png",
            "backward.png",
            "forward.png",
            "left.png"
        };
        int tog=0;
        for(int i=1;i<10;i++){
            if(tog>3){tog=0;}
            Image img = t.getImage(foto[tog]);
            g.drawImage(img, 10, 10+35*i, 30, 30, this);
            tog++;
        }
       

    }

    public static void main(String[] args) {
        ImageTest canvas = new ImageTest();
        JFrame frame = new JFrame();
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

}
