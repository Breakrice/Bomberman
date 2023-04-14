public class Enemy {
    private int xpos;
    private int ypos;
    public int xBIGpos;
    public int yBIGpos;
    public Enemy(int x,int y, int Bx,int By){
        xpos=x;
        ypos=y;
        xBIGpos=Bx;
        yBIGpos=By;
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
}
