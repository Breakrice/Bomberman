import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private ArrayList<char[][]> maps;
    public static char[][] L1Map=new char[13][31];
    public static char[][] L2Map=new char[13][31];
    public static char[][] L3Map=new char[13][31];
    public static char[][] L4Map=new char[13][31];
    public static char[][] L5Map=new char[13][31];
    public static char[][] L6Map=new char[13][31];
    public static char[][] L7Map=new char[13][31];
    public static char[][] L8Map=new char[13][31];
    public static char[][] L9Map=new char[13][31];
    public static char[][] L10Map=new char[13][31];
    public static char[][] curMap;

    public Map() throws FileNotFoundException {
        maps=new ArrayList<char[][]>();
        placeMap();
        maps.add(L1Map);
        maps.add(L2Map);
        maps.add(L3Map);
        maps.add(L4Map);
        maps.add(L5Map);
        maps.add(L6Map);
        maps.add(L7Map);
        maps.add(L8Map);
        maps.add(L9Map);
        maps.add(L10Map);
        curMap=maps.get(0);
    }

    public void placeMap()  throws FileNotFoundException{
        Scanner file=new Scanner(new File("Level1.txt"));
        for(int p=0;p<13;p++)
            L1Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level2.txt"));
        for(int p=0;p<13;p++)
            L2Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level3.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level4.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level5.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level6.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level7.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level8.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level9.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
        file=new Scanner(new File("Level10.txt"));
        for(int p=0;p<13;p++)
            L5Map[p]=file.next().toCharArray();
    }

    public void newLevel(){
        Main.level++;
    }

    public char[][] whatMap(){
        return curMap;
    }

    public void makeEmpty(int x, int y){
        curMap[y][x]='e';
    }
}