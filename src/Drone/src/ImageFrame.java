
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author micheacolautti
 */
public class ImageFrame extends JFrame implements KeyListener{

    private ImagePanelFront imagePanelFront;
    private ImagePanelLat imagePanelLat;
    private ImagePanelUp imagePanelUp;
    private Altitudine altitudine;

    public ImageFrame() {
       addKeyListener((KeyListener)this);
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
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagePanelFront = new ImagePanelFront();
        imagePanelLat = new ImagePanelLat();
        imagePanelUp = new ImagePanelUp();
        altitudine = new Altitudine();
        add(imagePanelLat);
        add(imagePanelUp);
        add(imagePanelFront);
        add(altitudine);
        pack();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int type = e.getKeyCode();
        if(type==68 || type==65){
            imagePanelFront.keyPressed(e);
        }
        if(type==87 || type==83){
            imagePanelLat.keyPressed(e);
        }
        if(type==37 || type==39){
            imagePanelUp.keyPressed(e);
        }
        if(type==38 || type==40){
            altitudine.keyPressed(e);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int type = e.getKeyCode();
        if(type==68 || type==65){
            imagePanelFront.keyReleased(e);
        } 
        if(type==87 || type==83){
            imagePanelLat.keyReleased(e);
        }
    }

    public void keyTyped(KeyEvent e) {}
    
    @Override
    public boolean isFocusTraversable() {
        return true;
    }
}
