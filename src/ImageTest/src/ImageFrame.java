
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author micheacolautti
 */
public class ImageFrame extends JFrame implements KeyListener{

    private ImagePanelFront imagePanelFront;
    private ImagePanelLat imagePanelLat;
    private ImagePanelUp imagePanelUp;

    public ImageFrame() {
       addKeyListener((KeyListener) this);
       initComponents();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageFrame().setVisible(true);
            }
        });
    }

    private void initComponents() {
        
        
        setMinimumSize(new Dimension(700, 500));
        setMaximumSize(new Dimension(700, 500));
        GridLayout ImageFrameLayout = new GridLayout(2, 2);
        setLayout(ImageFrameLayout);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagePanelFront = new ImagePanelFront();
        imagePanelLat = new ImagePanelLat();
        imagePanelUp = new ImagePanelUp();
        add(imagePanelLat);
        add(imagePanelLat);
        add(imagePanelUp);
        add(imagePanelFront);
        pack();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int type = e.getKeyCode();
        if(type==37 || type==39){
            imagePanelFront.keyPressed(e);
        }else if(type==38 || type==40){
            imagePanelLat.keyPressed(e);
        }else if(type==65 || type==68){
            System.out.println(e);
            imagePanelUp.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int type = e.getKeyCode();
        if(type==37 || type==39){
            imagePanelFront.keyReleased(e);
        }else if(type==38 || type==40){
            imagePanelLat.keyReleased(e);
        }else if(type==65 || type==68){
            System.out.println(e);
            imagePanelUp.keyReleased(e);
        }
    }

    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public boolean isFocusTraversable() {
        return true;
    }

}
