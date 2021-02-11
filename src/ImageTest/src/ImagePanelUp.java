
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImagePanelUp extends ImageModel {

    public ImagePanelUp() {
        try {
            imageBig = ImageIO.read(new File("/Users/micheacolautti/Documents/"
                    + "GitHub/Drone/src/ImageTest/bin/DroneSuperiore.png"));

        } catch (IOException ex) {
            System.out.println("Errore");
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        panelH=getHeight();
        panelW=getWidth();
        if(panelW<panelH){
            panelH=panelW;
        }else{
            panelW=panelH;
        }
        image=resize(imageBig,panelW,panelH);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this);      
    }

}
