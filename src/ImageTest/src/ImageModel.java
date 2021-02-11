import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImageModel extends JPanel {

    public BufferedImage imageBig;
    public BufferedImage image;
    public int panelH;
    public int panelW;

    public ImageModel() {}

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public void paintComponent(Graphics g) {
        
        panelH=getHeight();
        panelW=getWidth();
        if(panelH>panelW){
            panelH=panelW;
            panelH/=1.7;
        
        }else if(panelH<100){
            panelW=panelW-panelH;
        }
        
        image=resize(imageBig,panelW,panelH);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this);            
    }
}
