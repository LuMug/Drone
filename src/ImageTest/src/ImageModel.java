
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImageModel extends JPanel {

    public BufferedImage imageBig;
    public BufferedImage rotatedImage;
    public BufferedImage image;

    public int height;
    public int width;
    public int panelH;
    public int panelW;

    public boolean rot = false;
    public boolean press = false;
    public int rotDeg = 0;
    public int type;

    public static final int MAXDEG = 40;

    public ImageModel() {}

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        if (img == null) {
            return null;
        }
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

    public BufferedImage rotate(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, this);
        g2d.dispose();

        return rotated;
    }

    public void paintComponent(Graphics g) {
        panelH = getHeight();
        panelW = getWidth();
        height = panelH;
        width = panelW;
        g.clearRect(0, 0, width, height);

        if (panelH > panelW) {
            panelH = panelW;
            panelH /= 1.5;
        }

        int x = 0, y = 0;

        if (rot) {
            x = (this.getWidth() - image.getWidth(null)) / 2;
            y = (this.getHeight() - image.getHeight(null)) / 2;

            image = resize(imageBig, panelW - 100, panelH - 100);
            rotatedImage = rotate(image, rotDeg);

            if (type == 68 || type ==65) {
                if (rotDeg < 0) {
                    g.drawImage(rotatedImage, x, y + rotDeg, this);
                }else{
                    g.drawImage(rotatedImage, x, y +(-rotDeg), this);      
                }
            } else if (type == 87 || type==83) {
                if(rotDeg>0){
                    g.drawImage(rotatedImage, x, y + (-rotDeg), this);
                }else{
                    g.drawImage(rotatedImage, x, y + rotDeg, this);
                }
            }
        } else if(imageBig != null) {
            image = resize(imageBig, panelW - 100, panelH - 100);
            x = (this.getWidth() - image.getWidth(null)) / 2;
            y = (this.getHeight() - image.getHeight(null)) / 2;
            g.drawImage(image, x, y, this);
        }
    }
}
