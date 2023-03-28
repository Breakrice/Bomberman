public class TheGuy {
    private static int xpos; //1565
    private static int ypos; //688
    public static int xBIGpos; //31
    public static int yBIGpos; //13
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
        xpos += 50;
        xBIGpos += 1;
    }

    public void moveXleft(){
        xpos-=50;
        xBIGpos-=1;
    }

    public void moveYup(){
        ypos-=50;
        yBIGpos-=1;
    }

    public void moveYdown(){
        ypos+=50;
        yBIGpos+=1;
    }
}
