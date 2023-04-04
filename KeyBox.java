import javax.swing.*;
import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/

// this is only to test if the keys are pressed.
public class KeyBox extends JPanel implements KeyListener
{
    private String keys_typed;
    private String key;
    public static TheGuy guy;
    public static Map map;
    private int spriteSize=50;
    public static boolean placebomb=false;
    //public static String[][] map;


    //this is the constructor
    public KeyBox( )
    {
        key = "NO KEY PRESSED YET";

        keys_typed = "";

        addKeyListener( this ); /*all keyListeners must have this in the constructor*/

        setFocusable( true );
    }


    public void paint( Graphics window )
    {
        Graphics2D g2 = (Graphics2D) window;
        Image background = Toolkit.getDefaultToolkit().getImage("background.png");
        g2.drawImage(background, 0 , 0 , 1565 , 688 , this);

        Image man = Toolkit.getDefaultToolkit().getImage("man_left_step.png");
        Image block = Toolkit.getDefaultToolkit().getImage("block.jpg");
        Image brick = Toolkit.getDefaultToolkit().getImage("brick.jpg");
        Image bomb = Toolkit.getDefaultToolkit().getImage("bomb.png");
        Image expBomb = Toolkit.getDefaultToolkit().getImage("explode_bomb.png");
        Image flame = Toolkit.getDefaultToolkit().getImage("Flame.jpg");
        Image backCov = Toolkit.getDefaultToolkit().getImage("BackgroundColor.jpg");

        for (int r = 0; r < map.whatMap().length; r++)
            for (int c = 0; c < map.whatMap()[0].length; c++) {
                if (map.whatMap()[r][c].equals("block")) {
                    g2.drawImage(block, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                }
                if(map.whatMap()[r][c].equals("brick"))
                    g2.drawImage(brick, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
            }
        for(int za=Main.bombs.size()-1;za>-1;za--){
            if(Main.bombs.get(za).extinguish==true)
                Main.bombs.remove(za);
        }

        for(int z=0;z<Main.bombs.size();z++){
            if(Main.bombs.get(z).blowUp==false){
                if(Main.bombs.get(z).almost==false) {
                    map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos] = "bomb";
                    g2.drawImage(bomb, Main.bombs.get(z).getX() - 10, Main.bombs.get(z).getY() - 5, spriteSize, spriteSize, this);
                }
                else{
                    map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos] = "bomb";
                    g2.drawImage(expBomb, Main.bombs.get(z).getX() - 10, Main.bombs.get(z).getY() - 5, spriteSize, spriteSize, this);
                }
            }
            else{
                g2.drawImage(flame, Main.bombs.get(z).getX()-10, Main.bombs.get(z).getY()-5, spriteSize, spriteSize, this);
                if(!map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1].equals("block"))
                    g2.drawImage(flame, Main.bombs.get(z).getX()+40, Main.bombs.get(z).getY()-5, spriteSize, spriteSize, this);
                if(!map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1].equals("block"))
                    g2.drawImage(flame, Main.bombs.get(z).getX()-60, Main.bombs.get(z).getY()-5, spriteSize, spriteSize, this);
                if(!map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos].equals("block"))
                    g2.drawImage(flame, Main.bombs.get(z).getX()-10, Main.bombs.get(z).getY()-55, spriteSize, spriteSize, this);
                if(!map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos].equals("block"))
                    g2.drawImage(flame, Main.bombs.get(z).getX()-10, Main.bombs.get(z).getY()+45, spriteSize, spriteSize, this);
                if(map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1].equals("brick"))
                    map.makeEmpty(Main.bombs.get(z).xBIGpos+1,Main.bombs.get(z).yBIGpos);
                if(map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1].equals("brick"))
                    map.makeEmpty(Main.bombs.get(z).xBIGpos-1,Main.bombs.get(z).yBIGpos);
                if(map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos].equals("brick"))
                    map.makeEmpty(Main.bombs.get(z).xBIGpos,Main.bombs.get(z).yBIGpos-1);
                if(map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos].equals("brick"))
                    map.makeEmpty(Main.bombs.get(z).xBIGpos,Main.bombs.get(z).yBIGpos+1);
                map.makeEmpty(Main.bombs.get(z).xBIGpos,Main.bombs.get(z).yBIGpos);
                if(Main.bombs.get(z).almExt==true){
                }
            }
        }

        g2.drawImage(man, guy.getX(), guy.getY(), spriteSize, spriteSize, this);
        //map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos]="guy";

        for(int r=0;r<map.whatMap().length;r++) {
            for (int c = 0; c < map.whatMap()[0].length; c++)
                System.out.print("("+c+", "+r+") "+map.whatMap()[r][c]+" ");
            System.out.println();
        }
    }

    /*1 */
    public void keyTyped(KeyEvent e)
    {
        keys_typed += "" + e.getKeyChar();
        repaint();
    }

    /*2*/
    public void keyPressed(KeyEvent e)
    {
        /*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
        //Check map to see where no move
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if(map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos+1].equals("empty"))
                Main.moveR=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if(map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos-1].equals("empty"))
                Main.moveL=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if(map.whatMap()[TheGuy.yBIGpos-1][TheGuy.xBIGpos].equals("empty"))
                Main.moveU=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if(map.whatMap()[TheGuy.yBIGpos+1][TheGuy.xBIGpos].equals("empty"))
                Main.moveD=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
            Main.bombPlace=true;
        }
        else {
            key = "Key " + e.getKeyCode() + " is pressed!";
        }
        repaint();
    }

    /*3*/
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            Main.moveR=false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            Main.moveL=false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            Main.moveU=false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            Main.moveD=false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
            Main.bombPlace=false;
        }
        //add another else if to check if another key was released..
        else{
            key = "Key "+ e.getKeyCode() +" was released!";
        }
        repaint();
    }
}