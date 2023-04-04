import java.util.ArrayList;

public class Map {
    private ArrayList<String[][]> maps;
    public static String[][] L1Map=new String[13][31];
    public static String[][] L2Map=new String[13][31];
    public static String[][] L3Map=new String[13][31];
    public static String[][] L4Map=new String[13][31];
    public static String[][] L5Map=new String[13][31];
    public static String[][] curMap;

    public Map(){
        maps=new ArrayList<String[][]>();
        makeMap();
        maps.add(L1Map);
        maps.add(L2Map);
        maps.add(L3Map);
        maps.add(L4Map);
        maps.add(L5Map);
        curMap=maps.get(0);
    }

    public void makeMap(){
            for (int r = 0; r < L1Map.length; r++)
                for (int c = 0; c < L1Map[0].length; c++)
                    L1Map[r][c] = "empty";
            //outer boundaries
            for (int i = 0; i < L1Map[0].length; i++)
                L1Map[0][i] = "block";
            for (int i = 0; i < L1Map.length; i++)
                L1Map[i][0] = "block";
            for (int i = 1; i < L1Map[0].length; i++)
                L1Map[12][i] = "block";
            for (int i = 1; i < L1Map.length; i++)
                L1Map[i][30] = "block";
            for (int r = 2; r < L1Map.length; r++)
                for (int c = 2; c < L1Map[0].length; c++)
                    if (r % 2 == 0 && c % 2 == 0)
                        L1Map[r][c] = "block";
            L1Map[1][4]="brick"; L1Map[1][6]="brick"; L1Map[1][7]="brick"; L1Map[1][9]="brick"; L1Map[1][12]="brick";
            L1Map[1][15]="brick"; L1Map[1][18]="brick"; L1Map[2][9]="brick"; L1Map[3][6]="brick"; L1Map[3][8]="brick";
            L1Map[3][9]="brick"; L1Map[3][13]="brick"; L1Map[3][15]="brick"; L1Map[3][19]="brick"; L1Map[3][21]="brick";
            L1Map[3][23]="brick"; L1Map[4][5]="brick"; L1Map[4][15]="brick"; L1Map[4][19]="brick"; L1Map[4][23]="brick";
            L1Map[5][7]="brick"; L1Map[5][12]="brick"; L1Map[5][14]="brick"; L1Map[5][16]="brick"; L1Map[5][17]="brick";
            L1Map[5][21]="brick"; L1Map[5][22]="brick"; L1Map[6][21]="brick"; L1Map[6][23]="brick"; L1Map[6][25]="brick";
            L1Map[7][3]="brick"; L1Map[7][8]="brick"; L1Map[7][10]="brick"; L1Map[7][22]="brick"; L1Map[7][24]="brick";
            L1Map[7][27]="brick"; L1Map[8][7]="brick"; L1Map[9][8]="brick"; L1Map[9][9]="brick"; L1Map[9][15]="brick";
            L1Map[9][16]="brick"; L1Map[9][26]="brick"; L1Map[9][27]="brick"; L1Map[9][29]="brick"; L1Map[10][1]="brick";
            L1Map[10][23]="brick"; L1Map[11][1]="brick"; L1Map[11][3]="brick"; L1Map[11][4]="brick"; L1Map[11][10]="brick";
            L1Map[11][11]="brick"; L1Map[11][16]="brick"; L1Map[11][22]="brick"; L1Map[11][25]="brick";

    }

    public void newLevel(){
        Main.level++;
    }

    public String[][] whatMap(){
        return curMap;
    }

    public void makeEmpty(int x, int y){
        curMap[y][x]="empty";
    }
}
