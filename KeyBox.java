import javax.swing.*;
import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// this is only to test if the keys are pressed.
public class KeyBox extends JPanel implements KeyListener
{
    private String keys_typed;
    private String key;
    public static TheGuy guy;
    public static Map map;
    private int spriteSize=50;
    public static boolean placebomb=false;
    public static boolean pdone=true;

    //this is the constructor
    public KeyBox( ){
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

        Image man = Toolkit.getDefaultToolkit().getImage("man walking left.png");
        Image block = Toolkit.getDefaultToolkit().getImage("block.jpg");
        Image brick = Toolkit.getDefaultToolkit().getImage("brick.jpg");
        Image bomb = Toolkit.getDefaultToolkit().getImage("bomb.png");
        Image expBomb = Toolkit.getDefaultToolkit().getImage("explode_bomb.png");
        Image flame = Toolkit.getDefaultToolkit().getImage("Flame.jpg");
        Image L = Toolkit.getDefaultToolkit().getImage("L.jpg");
        Image E = Toolkit.getDefaultToolkit().getImage("E.jpg");
        Image V = Toolkit.getDefaultToolkit().getImage("V.jpg");
        Image N = Toolkit.getDefaultToolkit().getImage("N.jpg");
        Image M = Toolkit.getDefaultToolkit().getImage("M.jpg");
        Image Y = Toolkit.getDefaultToolkit().getImage("Y.jpg");
        Image One = Toolkit.getDefaultToolkit().getImage("1.jpg");
        Image Two = Toolkit.getDefaultToolkit().getImage("2.jpg");
        Image Three = Toolkit.getDefaultToolkit().getImage("3.jpg");
        Image Four = Toolkit.getDefaultToolkit().getImage("four.jpg");
        Image Five = Toolkit.getDefaultToolkit().getImage("five.jpg");
        Image Six = Toolkit.getDefaultToolkit().getImage("six.jpg");
        Image RW = Toolkit.getDefaultToolkit().getImage("rw enemy.png");
        Image LOS = Toolkit.getDefaultToolkit().getImage("LOS enemy.png");
        Image AK = Toolkit.getDefaultToolkit().getImage("AK enemy.png");

        for(int z=Main.bombs.size()-1;z>-1;z--){
            if(Main.bombs.get(z).blowUp==false){
                if(Main.bombs.get(z).almost==false)
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos] = 'o';
                else
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos] = 'x';
            }
            else{
                KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos]='f';
                if(KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='r' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='e' ||KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='w' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='o' ||KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='x' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='s' ||KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1] =='a')
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos+1]='f';
                if(KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='r' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='e' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='w' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='o' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='x' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='s' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1] =='a')
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos][Main.bombs.get(z).xBIGpos-1]='f';
                if(KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='r' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='e' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='w' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='o' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='x' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='s' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos] =='a')
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos-1][Main.bombs.get(z).xBIGpos]='f';
                if(KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='r' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='e' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='w' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='o' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='x' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='s' || KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos] =='a')
                    KeyBox.map.whatMap()[Main.bombs.get(z).yBIGpos+1][Main.bombs.get(z).xBIGpos]='f';
            }
        }

        for(int z = Main.enemies.size()-1; z>-1; z--)
            if(Main.enemies.get(z).deadYet())
                Main.enemies.remove(z);

        if(Main.enemies.size()>0) {
            for (int i = 0; i < map.whatMap().length; i++) {
                for (int j = 0; j < map.whatMap()[0].length; j++)
                    System.out.print(map.whatMap()[i][j]);
                System.out.println();
            }

            if (guy.dead == false) {
                for (int r = 0; r < map.whatMap().length; r++)
                    for (int c = 0; c < map.whatMap()[0].length; c++) {
                        if (map.whatMap()[r][c] == ('b'))
                            g2.drawImage(block, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('r'))
                            g2.drawImage(brick, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('L'))
                            g2.drawImage(L, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('E'))
                            g2.drawImage(E, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('V'))
                            g2.drawImage(V, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('N'))
                            g2.drawImage(N, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('M'))
                            g2.drawImage(M, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('Y'))
                            g2.drawImage(Y, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('1'))
                            g2.drawImage(One, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('2'))
                            g2.drawImage(Two, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('3'))
                            g2.drawImage(Three, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('4'))
                            g2.drawImage(Four, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('5'))
                            g2.drawImage(Five, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('6'))
                            g2.drawImage(Six, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('w'))
                            g2.drawImage(RW, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('s'))
                            g2.drawImage(LOS, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('a'))
                            g2.drawImage(AK, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('o'))
                            g2.drawImage(bomb, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('x'))
                            g2.drawImage(expBomb, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('f'))
                            g2.drawImage(flame, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
                        if (map.whatMap()[r][c] == ('f'))
                            KeyBox.map.makeEmpty(c, r);
                        if (map.whatMap()[r][c] == ('g')) {
                            guy = new TheGuy(c * spriteSize + 10, r * spriteSize + 3, c, r);
                            map.whatMap()[r][c] = 'e';
                            Main.nlev=false;
                        }
                    }
                g2.drawImage(man, guy.getX(), guy.getY(), 125, 125, this);
            } else
                Main.gameStarted = false;
        }
        else
            repaint();
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
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if(map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos+1]=='e' || map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos+1]=='w')
                Main.moveR=true;
            else
                for(int yeah=0;yeah<Main.bombs.size();yeah++)
                    Main.bombs.get(yeah).sooner();
            for(Enemy z: Main.enemies)
                z.moveChoose();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if(map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos-1]=='e' || map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos-1]=='w')
                Main.moveL=true;
            else
                for(int yeah=0;yeah<Main.bombs.size();yeah++)
                    Main.bombs.get(yeah).sooner();
            for(Enemy z: Main.enemies)
                z.moveChoose();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if(map.whatMap()[TheGuy.yBIGpos-1][TheGuy.xBIGpos]=='e' || map.whatMap()[TheGuy.yBIGpos-1][TheGuy.xBIGpos]=='w')
                Main.moveU=true;
            else
                for(int yeah=0;yeah<Main.bombs.size();yeah++)
                    Main.bombs.get(yeah).sooner();
            for(Enemy z: Main.enemies)
                z.moveChoose();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if(map.whatMap()[TheGuy.yBIGpos+1][TheGuy.xBIGpos]=='e' || map.whatMap()[TheGuy.yBIGpos+1][TheGuy.xBIGpos]=='w')
                Main.moveD=true;
            else
                for(int yeah=0;yeah<Main.bombs.size();yeah++)
                    Main.bombs.get(yeah).sooner();
            for(Enemy z: Main.enemies)
                z.moveChoose();
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