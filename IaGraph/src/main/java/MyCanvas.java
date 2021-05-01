import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyCanvas extends Canvas{

    public void paint(Graphics g) {
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File("src/main/resources/grafo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bimg, 0, 0, getWidth(), getHeight(), this);
    }
}