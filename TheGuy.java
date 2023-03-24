public class TheGuy {
    private static int xpos;
    private static int ypos;
    public TheGuy(int x,int y){
        xpos=x;
        ypos=y;
    }

    public int getX() {
        return xpos;
    }

    public int getY(){
        return ypos;
    }

    public void moveXright(){
        xpos+=50;
    }

    public void moveXleft(){
        xpos-=50;
    }

    public void moveYup(){
        ypos-=50;
    }

    public void moveYdown(){
        ypos+=50;
    }
}
