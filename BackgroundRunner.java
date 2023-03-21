import java.awt.*;
import javax.swing.*;
public class BackgroundRunner extends JFrame
{
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1115;
    public BackgroundRunner()
    {
        super("MouseBob Runner");
        setSize(WIDTH,HEIGHT);
        add( new Background() );
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main( String args[] )
    {
        BackgroundRunner run = new BackgroundRunner();
    }
}