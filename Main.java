import java.util.Scanner;

public class Main {
    public static boolean moveR=false;
    public static boolean moveL=false;
    public static boolean moveU=false;
    public static boolean moveD=false;
    public static void main(String[] args) {
        //Scanner console = new Scanner(System.in);
        int let=0;
        KeyBox.guy=new TheGuy(160,155);
        new KeyBoxRunner();
        boolean gameStarted=true;
        while(gameStarted==true){
            System.out.print("");
            if(moveR==true) {
                KeyBox.guy.moveXright();
                while(moveR==true){
                    let++;
                    let--;
                    System.out.println("");
                }
            }
            if(moveL==true){
                KeyBox.guy.moveXleft();
                while(moveL==true){
                    let++;
                    let--;
                    System.out.println("");
                }
            }
            if(moveU==true){
                KeyBox.guy.moveYup();
                while(moveU==true){
                    let++;
                    let--;
                    System.out.println("");
                }
            }
            if(moveD==true){
                KeyBox.guy.moveYdown();
                while(moveD==true){
                    let++;
                    let--;
                    System.out.println("");
                }
            }
        }
    }
}