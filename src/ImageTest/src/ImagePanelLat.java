
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePanelLat extends ImageModel{

    
    public ImagePanelLat() {
        try {
            imageBig = ImageIO.read(new File("../bin/DroneLaterale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }
}
