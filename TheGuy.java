public class TheGuy {
    private static int xpos;
    private static int ypos;
    public static int xBIGpos;
    public static int yBIGpos;
    public static boolean placeBomb=false;
    public TheGuy(int x,int y){
        xpos=x;
        ypos=y;
        xBIGpos=3;
        yBIGpos=3;
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
    }

    public void moveXleft(){
        xpos-=50;
        xBIGpos--;
    }

    public void moveYup(){
        ypos-=50;
        yBIGpos--;
    }

    public void moveYdown(){
        ypos+=50;
        yBIGpos++;
    }

    public void placeBomb(){
        placeBomb=true;
    }
}