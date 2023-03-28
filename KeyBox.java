import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/

// this is only to test if the keys are pressed.
public class KeyBox extends Canvas implements KeyListener
{
    private String keys_typed;
    private String key;
    public static TheGuy guy;
    private int spriteSize=50;
    public static String[][] map;


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
        for(int r=0;r<map.length;r++)
            for(int c=0;c<map[0].length;c++)
                map[r][c]="empty";
        //outer boundaries
        for(int i=0;i<map[0].length;i++) {
            g2.drawImage(block, i*spriteSize, 0, 50, 50, this);
            map[0][i]="block";
        }
        for(int i=0;i<map.length;i++) {
            g2.drawImage(block, 0, i*spriteSize, 50, 50, this);
            map[i][0]="block";
        }
        for(int i=1;i<map[0].length;i++) {
            g2.drawImage(block, i*spriteSize, 12*spriteSize, 50, 50, this);
            map[12][i]="block";
        }
        for(int i=1;i<map.length;i++) {
            g2.drawImage(block, 30*spriteSize, i*spriteSize, 50, 50, this);
            map[i][30]="block";
        }

        for(int r=2;r<map.length;r++)
            for(int c=2;c<map[0].length;c++) {
                if(r%2==0&&c%2==0) {
                    g2.drawImage(block, c * spriteSize, r * spriteSize, 50, 50, this);
                    map[r][c] = "block";
                }
            }
        for(int i=1;i<30;i++) {
            g2.drawImage(brick, i * spriteSize, 1*spriteSize, 50, 50, this);
            map[1][i]="brick";
        }
        map[TheGuy.yBIGpos][TheGuy.xBIGpos]="guy";

        for(int r=0;r<map.length;r++) {
            for (int c = 0; c < map[0].length; c++)
                System.out.print(""+c+r+map[r][c]+" ");
            System.out.println();
        }

        g2.setStroke(new java.awt.BasicStroke(3));
        g2.setColor(Color.YELLOW);
        for(int r=0;r<map.length;r++){
            for(int c=0;c<map[0].length;c++) {
                Rectangle collision = new Rectangle(c*spriteSize, r*spriteSize, 50, 50);
                if(map[r][c].equals("block")||map[r][c].equals("brick"))
                    g2.draw(collision);
            }
        }

        g2.drawImage(man, guy.getX(), guy.getY(), 50, 50, this);



        /*
        window.setColor(Color.red);
        window.drawString( "Please type something!", 250, 100 );

        if(keys_typed.length()!=0)
        {
            window.setColor(Color.black);
            window.fillRect(90, 130, keys_typed.length()*7 + 20, 30);
        }

        window.setColor(Color.green);
        window.drawString( keys_typed, 100, 150 );

        window.setColor(new Color( 100, 0, 100 ));
        window.drawString( key, 250, 200 );
         */

    }

    /*KeyListeners must have these 3 methods:
     * You do not have to have code in any of these, they can be empty.
     * But they all must be in your KeyListener for it to work.
     */

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
            if(map[TheGuy.yBIGpos][TheGuy.xBIGpos+1].equals("empty"))
                Main.moveR=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if(map[TheGuy.yBIGpos][TheGuy.xBIGpos-1].equals("empty"))
                Main.moveL=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if(KeyBox.map[TheGuy.yBIGpos-1][TheGuy.xBIGpos].equals("empty"))
                Main.moveU=true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if(map[TheGuy.yBIGpos+1][TheGuy.xBIGpos].equals("empty"))
                Main.moveD=true;
        }
        //add another else if to check if another key was pressed..
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
        //add another else if to check if another key was released..
        else{
            key = "Key "+ e.getKeyCode() +" was released!";
        }
        repaint();

    }
}