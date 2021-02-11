
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanelUp extends JPanel {

    private BufferedImage imageBig;
    private BufferedImage image;
    private int panelH;
    private int panelW;

    public ImagePanelUp() {
        try {
            imageBig = ImageIO.read(new File("/Users/micheacolautti/Documents/GitHub/Drone/src/ImageTest/bin/DroneSuperiore.png"));

        } catch (IOException ex) {
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        g.drawImage(image, x, y, this); // see javadoc for more info on the parameters            
    }

}
