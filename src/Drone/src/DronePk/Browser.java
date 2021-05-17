package DronePk;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe che si occupa di aprire a schermo una schermata del browser
 * predefinito.
 *
 * @author Alessandro Aloise
 * @version 06.05.2021
 */
public class Browser {

    public void script() throws IOException {
        String os= System.getProperty("os.name").toLowerCase();
        if (os.contains("os")) {
             
          
            
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh","-c"," ./RunLiveMac.sh");
            Process process=builder.start();
        } else {
            String path = "cmd /c start RunLiveWin.bat";
            Runtime rn = Runtime.getRuntime();
            Process pr = rn.exec(path);
        }
    }

    public void openBrowser() {
        String url = "http://localhost:3000/index.html";

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                System.out.println("Error:" + e);
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                System.out.println("Error:" + e);
            }
        }
    }
}
