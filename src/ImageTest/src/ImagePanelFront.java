import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePanelFront extends ImageModel{

    
    public ImagePanelFront() {
        try {
            imageBig = ImageIO.read(new File("../bin/DroneFrontale.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }
}
