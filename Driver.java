import java.util.*;
import java.util.*;
public class Driver{
    public static void main(String args[]){
        Object[][] map = new Object[15][15];
        Scanner userInput = new Scanner(System.in);
        boolean run = true;
        boolean checkDirection = false;
        int coins = 0;
        int dir = 0;
        String direction = "";
        
        ArrayList<Entity> entityList = new ArrayList<Entity>();
        ArrayList<TownsPerson> townList = new ArrayList<TownsPerson>();
        Weapon dagger = new Weapon(20);
        Storage trousers = new Storage();
        Armor leatherArmor = new Armor(10);
        Hero hero = new Hero(dagger, trousers, leatherArmor);
        
        TownsPerson Jonathan = new TownsPerson();
        TownsPerson Shopkeeper = new TownsPerson();
        TownsPerson Steve = new TownsPerson();
        TownsPerson Justin = new TownsPerson();
        TownsPerson Tony = new TownsPerson();
        
        townList.add(Jonathan);
        townList.add(Shopkeeper);
        townList.add(Steve);
        townList.add(Justin);
        townList.add(Tony);
        
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = "[ ? ]";
            }
        }
        map[14][0] = "[ H ]";
        checkPos(map, townList);
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = "[ ? ]";
            }
        }
        map[14][0] = "[ H ]";
        System.out.println("**Hero & Monsters**\n\n* The map has been generated *\n*The items have been placed *\nHero begins his journey in the Southwest corner of Yore");
        printMap(map);
        while (run){
            System.out.print("Enter direction: ");
            direction = userInput.nextLine().toLowerCase();
            if (direction.equals("w") || direction.equals("a") || direction.equals("s") || direction.equals("d")){
                checkDirection = true;
            }
            else{
                System.out.println("That is not a valid option");
            }
            while (checkDirection){
                if(direction.equals("w")){
                    if (checkN(hero)){
                        clear();
                        printMap(map);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setY(-1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map);
                        checkDirection = false;
                        dir = 1;
                    }
                }
                if (direction.equals("a")){
                    if (checkW(hero)){
                        clear();
                        printMap(map);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setX(-1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map);
                        checkDirection = false;
                        dir = 2;
                    }
                }
                if (direction.equals("s")){
                    if (checkS(hero)){
                        clear();
                        printMap(map);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setY(1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map);
                        checkDirection = false;
                        dir = 3;
                    }
                }
                if (direction.equals("d")){
                    if (checkE(hero)){
                        clear();
                        printMap(map);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setX(1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map);
                        checkDirection = false;
                        dir = 4;
                    }
                }
            }
        }
    }
    
    public static void printMap(Object[][] map){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void clear(){
        for(int i = 0; i < 25; i++){
            System.out.println();
        }
    }
    
    public static void checkPos(Object[][] map, ArrayList<TownsPerson> townList){
        boolean run = true;
        int count = 0;
        while (run){
            for (TownsPerson i:townList){
                if (map[i.getY()][i.getX()] == "[ ? ]"){
                    map[i.getY()][i.getX()] = "[ t ]";
                    count += 1;
                }
                else{
                    i.resetPos();
                }
                if (count == townList.size()){
                    run = false;
                }
            }
        }
    }
    
    public static boolean checkE(Hero hero){
        if (hero.getX() == 14){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkS(Hero hero){
        if (hero.getY() == 14){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkW(Hero hero){
        if (hero.getX() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkN(Hero hero){
        if (hero.getY() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
