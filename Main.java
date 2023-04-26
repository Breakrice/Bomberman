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
    public static ArrayList<Enemy> enemies;
    public static int level;
    public static boolean nlev;
    public static boolean gameStarted;

    public static void main(String[] args) throws FileNotFoundException {
        level=0;
        KeyBox.map=new Map();
        int let=0;
        bombs=new ArrayList<Bomb>();
        enemies=new ArrayList<Enemy>();
        gameStarted=true;
        nlev=false;
        new KeyBoxRunner();
        for (int r = 0; r < KeyBox.map.whatMap().length; r++)
            for (int c = 0; c < KeyBox.map.whatMap()[0].length; c++) {
                if (KeyBox.map.whatMap()[r][c] == 'w')
                    enemies.add(new Enemy(c * 50, r * 50, c, r, "dumb"));
                if(KeyBox.map.whatMap()[r][c] == 's')
                    enemies.add(new Enemy(c * 50, r * 50, c, r, "smart"));
                if(KeyBox.map.whatMap()[r][c] == 'a')
                    enemies.add(new Enemy(c * 50, r * 50, c, r, "smartest"));
            }

        while(gameStarted){
            System.out.print("");
            if(KeyBox.map.whatMap()[KeyBox.guy.yBIGpos][KeyBox.guy.xBIGpos]=='f' || KeyBox.map.whatMap()[KeyBox.guy.yBIGpos][KeyBox.guy.xBIGpos]=='w' || KeyBox.map.whatMap()[KeyBox.guy.yBIGpos][KeyBox.guy.xBIGpos]=='s' || KeyBox.map.whatMap()[KeyBox.guy.yBIGpos][KeyBox.guy.xBIGpos]=='a'){
                TheGuy.lives--;
                if(TheGuy.lives<1)
                    TheGuy.dead =true;
            }
            if(KeyBox.map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos]=='h'){
                if(TheGuy.lives!=5)
                    TheGuy.lives++;
            }
            if(KeyBox.map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos]=='i'){

            }
            if(KeyBox.map.whatMap()[TheGuy.yBIGpos][TheGuy.xBIGpos]=='t'){

            }
            if(moveR) {
                KeyBox.guy.moveXright();
                while(moveR){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveL){
                KeyBox.guy.moveXleft();
                while(moveL){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveU){
                KeyBox.guy.moveYup();
                while(moveU){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(moveD){
                KeyBox.guy.moveYdown();
                while(moveD){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(bombPlace){
                let++;
                let--;
                if(bombs.size()<Bomb.bombs)
                    bombs.add(new Bomb(KeyBox.guy.getX(),KeyBox.guy.getY(),TheGuy.xBIGpos,TheGuy.yBIGpos));
                while(bombPlace){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
            if(enemies.size()==0) {
                bombs=new ArrayList<Bomb>();
                if (level < 10) {
                    KeyBox.map.newLevel();
                    nlev=true;
                }
                for (int r = 0; r < KeyBox.map.whatMap().length; r++)
                    for (int c = 0; c < KeyBox.map.whatMap()[0].length; c++) {
                        if (KeyBox.map.whatMap()[r][c] == 'w')
                            enemies.add(new Enemy(c * 50, r * 50, c, r, "dumb"));
                        if(KeyBox.map.whatMap()[r][c] == 's')
                            enemies.add(new Enemy(c * 50, r * 50, c, r, "smart"));
                        if(KeyBox.map.whatMap()[r][c] == 'a')
                            enemies.add(new Enemy(c * 50, r * 50, c, r, "smartest"));
                    }
                while(nlev==true){
                    let++;
                    let--;
                    System.out.print("");
                }
            }
        }
    }
}