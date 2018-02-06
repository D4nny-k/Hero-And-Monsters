import java.util.*;
public class Driver{
    public static void main(String args[]){
        Object[][] map = new Object[15][15];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = "[ ? ]";
            }
        }
        printMap(map);
    }
    
    public static void printMap(Object[][] map){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void clearMap(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }
}
