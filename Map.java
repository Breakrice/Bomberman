import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    public static char[][] Cmap;
    public Map(){
        Cmap=new char[13][31];
    }
    public static void placeMap(String level) throws FileNotFoundException {
        Scanner file=new Scanner(new File(level));
        for(int p=0;p<13;p++)
            Cmap[p]=file.next().toCharArray();
    }
}
