public class TheGuy {
    public static int xpos; //1565
    public static int ypos; //688
    public static int xBIGpos; //31
    public static int yBIGpos; //13
    public static boolean placeBomb=false;
    public static int lives=1;
    public static boolean dead=false;
    public static int startXBIGpos;
    public static int startYBIGpos;
    public static int startXpos;
    public static int startYpos;

    public TheGuy(int x,int y, int Bx,int By){
        xpos=x;
        ypos=y;
        xBIGpos=Bx;
        yBIGpos=By;
    }

    public int getX() {
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    public void moveXright(){
        xpos+=50;
        xBIGpos++;
        for(int yeah=0;yeah<Main.bombs.size();yeah++){
            Main.bombs.get(yeah).sooner();
        }
    }

    public void moveXleft(){
        xpos-=50;
        xBIGpos--;
        for(int yeah=0;yeah<Main.bombs.size();yeah++){
            Main.bombs.get(yeah).sooner();
        }
    }

    public void moveYup(){
        ypos-=50;
        yBIGpos--;
        for(int yeah=0;yeah<Main.bombs.size();yeah++){
            Main.bombs.get(yeah).sooner();
        }
    }

    public void moveYdown(){
        ypos+=50;
        yBIGpos++;
        for(int yeah=0;yeah<Main.bombs.size();yeah++){
            Main.bombs.get(yeah).sooner();
        }
    }
}