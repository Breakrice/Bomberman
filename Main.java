import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean moveR=false;
    public static boolean moveL=false;
    public static boolean moveU=false;
    public static boolean moveD=false;
    public static boolean bombPlace=false;
    public static ArrayList<Bomb> bombs;
    public static int level;
    public static boolean nlev;

    public static void main(String[] args) throws FileNotFoundException {
        level=1;
        KeyBox.map=new Map();
        int let=0;
        level=1;
        bombs=new ArrayList<Bomb>();
        KeyBox.guy=new TheGuy(60,55,1,1);
        new KeyBoxRunner();
        boolean gameStarted=true;
        nlev=false;

        while(gameStarted==true){
            System.out.print("");
            if(moveR==true) {
                KeyBox.guy.moveXright();
                while(moveR==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveL==true){
                KeyBox.guy.moveXleft();
                while(moveL==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveU==true){
                KeyBox.guy.moveYup();
                while(moveU==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveD==true){
                KeyBox.guy.moveYdown();
                while(moveD==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(bombPlace==true){
                let++;
                let--;
                bombs.add(new Bomb(KeyBox.guy.getX(),KeyBox.guy.getY(),TheGuy.xBIGpos,TheGuy.yBIGpos));
                while(bombPlace==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
        }
    }
}