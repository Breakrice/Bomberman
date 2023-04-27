public class Bomb {
    private int xpos;
    private int ypos;
    public int xBIGpos;
    public int yBIGpos;
    public boolean blowUp=false;
    public boolean almost=false;
    public int blowUpSoon=0;
    public boolean extinguish=false;
    public boolean almExt=false;
    public static int bombs=1;
    public static int radius=1;

    public Bomb(int x,int y, int Bx,int By){
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

    public void sooner(){
        blowUpSoon++;
        if(blowUpSoon==5) {
            extinguish = true;
            Main.bombs.remove(this);
        }
        if(blowUpSoon==4) {
            blowUp = true;
            almExt=true;
        }
        if(blowUpSoon==3)
            almost=true;
    }
}