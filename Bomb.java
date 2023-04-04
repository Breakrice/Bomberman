public class Bomb {
    private static int xpos;
    private static int ypos;
    public static int xBIGpos;
    public static int yBIGpos;
    public boolean blowUp=false;
    public boolean almost=false;
    public int blowUpSoon=0;
    public boolean extinguish=false;
    public boolean almExt=false;

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
        if(blowUpSoon==5)
            extinguish=true;
        if(blowUpSoon==4) {
            blowUp = true;
            almExt=true;
        }
        if(blowUpSoon==3)
            almost=true;
    }
}