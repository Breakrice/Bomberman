import java.awt.*;
import javax.swing.*;
public class Background extends JPanel
{
    public void paintComponent( Graphics window )
    {
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("background.png"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, 0 , 0 , 1950 , 1000 , this);

    }
}