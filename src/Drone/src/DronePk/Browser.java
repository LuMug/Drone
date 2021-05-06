package DronePk;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe che si occupa di aprire a schermo una schermata del browser predefinito.
 * @author Alessandro Aloise
 * @version 06.05.2021
 */
public class Browser {

    public void openBrowser(){
        String url = "http://localhost:3000";
        
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                System.out.println("Error:" +e );
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                System.out.println("Error:" +e);
            }
        }
    }
}
