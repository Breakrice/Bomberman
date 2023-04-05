import javax.swing.*;
import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// this is only to test if the keys are pressed.
public class KeyBox extends JPanel implements KeyListener {
	private String keys_typed;
	private String key;
	public static TheGuy guy;
	private int spriteSize = 50;
	public static boolean placebomb = false;

	//this is the constructor
	public KeyBox() {
		key = "NO KEY PRESSED YET";

		keys_typed = "";

		addKeyListener(this); /*all keyListeners must have this in the constructor*/

		setFocusable(true);
	}


	public void paint(Graphics window) {
		Graphics2D g2 = (Graphics2D) window;
		Image background = Toolkit.getDefaultToolkit().getImage("background.png");
		g2.drawImage(background, 0, 0, 1565, 688, this);
		Image man = Toolkit.getDefaultToolkit().getImage("man_left_step.png");
		Image block = Toolkit.getDefaultToolkit().getImage("block.jpg");
		Image brick = Toolkit.getDefaultToolkit().getImage("brick.jpg");
		Image bomb = Toolkit.getDefaultToolkit().getImage("bomb.png");
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




		for(int i=0;i<Map.Cmap.length;i++) {
			for (int j = 0; j < Map.Cmap[0].length; j++)
				System.out.print(Map.Cmap[i][j]);
			System.out.println();
		}
		for (int r = 0; r < Map.Cmap.length; r++)
			for (int c = 0; c < Map.Cmap[0].length; c++) {
				if (Map.Cmap[r][c] == ('b'))
					g2.drawImage(block, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('r'))
					g2.drawImage(brick, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('L'))
					g2.drawImage(L, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('E'))
					g2.drawImage(E, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('V'))
					g2.drawImage(V, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('N'))
					g2.drawImage(N, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('M'))
					g2.drawImage(M, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('Y'))
					g2.drawImage(Y, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('1'))
					g2.drawImage(One, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('2'))
					g2.drawImage(Two, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('3'))
					g2.drawImage(Three, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('4'))
					g2.drawImage(Four, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('5'))
					g2.drawImage(Five, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
				if (Map.Cmap[r][c] == ('6'))
					g2.drawImage(Six, c * spriteSize, r * spriteSize, spriteSize, spriteSize, this);
			}


		g2.drawImage(man, guy.getX(), guy.getY(), spriteSize, spriteSize, this);

		/*for (int r = 0; r < Map.Cmap.length; r++) {
			for (int c = 0; c < Map.Cmap[0].length; c++)
				System.out.print("(" + c + ", " + r + ") " + Map.Cmap[r][c] + " ");
			System.out.println();
		}*/
	}

		/*1 */
		public void keyTyped (KeyEvent e)
		{
			keys_typed += "" + e.getKeyChar();
			repaint();
		}

		/*2*/
		public void keyPressed (KeyEvent e)
		{
			/*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
			//Check Map.map to see where no move
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				if (Map.Cmap[TheGuy.yBIGpos][TheGuy.xBIGpos + 1]==('e'))
					Main.moveR = true;
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				if (Map.Cmap[TheGuy.yBIGpos][TheGuy.xBIGpos - 1]==('e'))
					Main.moveL = true;
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				if (Map.Cmap[TheGuy.yBIGpos - 1][TheGuy.xBIGpos]==('e'))
					Main.moveU = true;
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				if (Map.Cmap[TheGuy.yBIGpos + 1][TheGuy.xBIGpos]==('e'))
					Main.moveD = true;
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Main.bombPlace = true;
			}
			else {
				key = "Key " + e.getKeyCode() + " is pressed!";
			}
			repaint();
		}

		/*3*/
		public void keyReleased (KeyEvent e)
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				Main.moveR = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				Main.moveL = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
				Main.moveU = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
				Main.moveD = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Main.bombPlace = false;
			}
			//add another else if to check if another key was released..
			else {
				key = "Key " + e.getKeyCode() + " was released!";
			}
			repaint();

		}
	}
