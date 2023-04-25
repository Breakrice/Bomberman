public class Enemy {
    public int xpos;
    public int ypos;
    public int xBIGpos;
    public int yBIGpos;
    private boolean isMovin;
    private int whichWay;
    private int WWSM;
    public String smartness;
    public boolean dead=false;
    private boolean clear;
    public Enemy(int x,int y, int Bx,int By,String INT){
        xpos=x;
        ypos=y;
        xBIGpos=Bx;
        yBIGpos=By;
        smartness=INT;
    }

    public void moveXright(){
        xpos+=50;
        xBIGpos++;
        if(smartness.equals("dumb"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='w';
        else if(smartness.equals("smart"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='s';
        else if(smartness.equals("smartest"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='a';
    }

    public void moveXleft(){
        xpos-=50;
        xBIGpos--;
        if(smartness.equals("dumb"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='w';
        else if(smartness.equals("smart"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='s';
        else if(smartness.equals("smartest"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='a';
    }

    public void moveYup(){
        ypos-=50;
        yBIGpos--;
        if(smartness.equals("dumb"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='w';
        else if(smartness.equals("smart"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='s';
        else if(smartness.equals("smartest"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='a';
    }

    public void moveYdown(){
        ypos+=50;
        yBIGpos++;
        if(smartness.equals("dumb"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='w';
        else if(smartness.equals("smart"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='s';
        else if(smartness.equals("smartest"))
            KeyBox.map.whatMap()[yBIGpos][xBIGpos]='a';
    }

    public void moveChoose(){
        isMovin=true;
        while(isMovin==true){
            if(smartness.equals("dumb"))
                whichWay=(int)(Math.random()*4)+1;
            else if(smartness.equals("smart")) {
                if (KeyBox.guy.xBIGpos == xBIGpos) {
                    if (KeyBox.guy.yBIGpos > yBIGpos) {
                        clear = true;
                        for (int x = yBIGpos+1; x < KeyBox.guy.yBIGpos; x++) {
                            if (KeyBox.map.whatMap()[x][xBIGpos] != 'e')
                                clear = false;
                        }
                        if (clear == true)
                            whichWay = 4;
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                    else if (KeyBox.guy.yBIGpos < yBIGpos) {
                        clear = true;
                        for (int x = KeyBox.guy.yBIGpos; x < yBIGpos; x++) {
                            if (KeyBox.map.whatMap()[x][xBIGpos] != 'e')
                                clear = false;
                        }
                        if (clear == true)
                            whichWay = 3;
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                }
                else if (KeyBox.guy.yBIGpos == yBIGpos) {
                    if (KeyBox.guy.xBIGpos > xBIGpos) {
                        clear = true;
                        for (int x = xBIGpos+1; x < KeyBox.guy.xBIGpos; x++) {
                            if (KeyBox.map.whatMap()[yBIGpos][x] != 'e')
                                clear = false;
                        }
                        if (clear == true)
                            whichWay = 1;
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                    else if (KeyBox.guy.xBIGpos < xBIGpos) {
                        clear = true;
                        for (int x = KeyBox.guy.yBIGpos; x < yBIGpos; x++) {
                            if (KeyBox.map.whatMap()[yBIGpos][x] != 'e')
                                clear = false;
                        }
                        if (clear == true)
                            whichWay = 2;
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                }
                else
                    whichWay=(int)(Math.random()*4)+1;
            }
            else if(smartness.equals("smartest")){
                int yDIS=yBIGpos-KeyBox.guy.yBIGpos;
                int xDIS=xBIGpos-KeyBox.guy.xBIGpos;
                boolean moved=false;
                if(Math.abs(yDIS)>=Math.abs(xDIS)){
                    if (KeyBox.guy.yBIGpos > yBIGpos) {
                        if (KeyBox.map.whatMap()[yBIGpos+1][xBIGpos] == 'e') {
                            whichWay = 4;
                            moved=true;
                        }
                    }
                    else if (KeyBox.guy.yBIGpos < yBIGpos) {
                        if (KeyBox.map.whatMap()[yBIGpos-1][xBIGpos] == 'e') {
                            whichWay = 3;
                            moved=true;
                        }
                    }
                    if(moved==false){
                        if (KeyBox.guy.xBIGpos > xBIGpos) {
                            if (KeyBox.map.whatMap()[yBIGpos][xBIGpos+1] == 'e')
                                whichWay = 1;
                            else
                                whichWay=(int)(Math.random()*4)+1;
                        }
                        else if (KeyBox.guy.xBIGpos < xBIGpos) {
                            if (KeyBox.map.whatMap()[yBIGpos][xBIGpos-1] == 'e')
                                whichWay = 2;
                            else
                                whichWay=(int)(Math.random()*4)+1;
                        }
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                }
                else {
                    if (KeyBox.guy.xBIGpos > xBIGpos) {
                        if (KeyBox.map.whatMap()[yBIGpos][xBIGpos + 1] == 'e') {
                            whichWay = 1;
                            moved = true;
                        }
                    }
                    else if (KeyBox.guy.xBIGpos < xBIGpos) {
                        if (KeyBox.map.whatMap()[yBIGpos][xBIGpos - 1] == 'e') {
                            whichWay = 2;
                            moved = true;
                        }
                    }
                    if (moved == false) {
                        if (KeyBox.guy.yBIGpos > yBIGpos) {
                            if (KeyBox.map.whatMap()[yBIGpos + 1][xBIGpos] == 'e')
                                whichWay = 4;
                            else
                                whichWay = (int) (Math.random() * 4) + 1;
                        } else if (KeyBox.guy.yBIGpos < yBIGpos) {
                            if (KeyBox.map.whatMap()[yBIGpos - 1][xBIGpos] == 'e')
                                whichWay = 3;
                            else
                                whichWay = (int) (Math.random() * 4) + 1;
                        }
                        else
                            whichWay=(int)(Math.random()*4)+1;
                    }
                }
            }
            System.out.println(smartness+whichWay);
            int r=yBIGpos;
            int c=xBIGpos;
            if(whichWay==1 && KeyBox.map.whatMap()[r][c+1] == 'e') {
                KeyBox.map.whatMap()[r][c]='e';
                moveXright();
                isMovin=false;
            }
            else if(whichWay==2 && KeyBox.map.whatMap()[r][c-1] == 'e') {
                KeyBox.map.whatMap()[r][c]='e';
                moveXleft();
                isMovin=false;
            }
            else if(whichWay==3 && KeyBox.map.whatMap()[r-1][c] == 'e') {
                KeyBox.map.whatMap()[r][c]='e';
                moveYup();
                isMovin=false;
            }
            else if(whichWay==4 && KeyBox.map.whatMap()[r+1][c] == 'e') {
                KeyBox.map.whatMap()[r][c]='e';
                moveYdown();
                isMovin=false;
            }
            else if(KeyBox.map.whatMap()[r][c+1] == 'o' || KeyBox.map.whatMap()[r][c-1] == 'o' || KeyBox.map.whatMap()[r-1][c] == 'o' || KeyBox.map.whatMap()[r+1][c] == 'o' || KeyBox.map.whatMap()[r][c+1] == 'x' || KeyBox.map.whatMap()[r][c-1] == 'x' || KeyBox.map.whatMap()[r-1][c] == 'x' || KeyBox.map.whatMap()[r+1][c] == 'x' || KeyBox.map.whatMap()[r][c+1] == 'w' || KeyBox.map.whatMap()[r][c-1] == 'w' || KeyBox.map.whatMap()[r-1][c] == 'w' || KeyBox.map.whatMap()[r+1][c] == 'w' || KeyBox.map.whatMap()[r][c+1] == 's' || KeyBox.map.whatMap()[r][c-1] == 's' || KeyBox.map.whatMap()[r-1][c] == 's' || KeyBox.map.whatMap()[r+1][c] == 's' || KeyBox.map.whatMap()[r][c+1] == 'a' || KeyBox.map.whatMap()[r][c-1] == 'a' || KeyBox.map.whatMap()[r-1][c] == 'a' || KeyBox.map.whatMap()[r+1][c] == 'a') {
                if(KeyBox.map.whatMap()[r][c+1] != 'e' && KeyBox.map.whatMap()[r][c-1] != 'e' && KeyBox.map.whatMap()[r-1][c] != 'e' && KeyBox.map.whatMap()[r+1][c] != 'e')
                    isMovin = false;
            }
        }
    }

    public boolean deadYet(){
        if(KeyBox.map.whatMap()[yBIGpos][xBIGpos]=='f')
            return true;
        return false;
    }
}
