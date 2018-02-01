import java.util.*;
public class Driver{
    public static void main(String args[]){
        Object[][] map = new Object[10][10];
        ArrayList<Monster> monsterList = new ArrayList<Monster>();
        Scanner userInput = new Scanner(System.in);
        boolean run = true;
        boolean checkDirection = false;
        boolean heroAction = true;
        boolean heroDeath = false;
        boolean armorCheck = false;
        boolean weaponCheck = false;
        String direction = null;
        String action = null;
        int count = 0;
        int dir = 0;
        
        Monster m1 = new Monster();
        Monster m2 = new Monster();
        Monster m3 = new Monster();
        Monster m4 = new Monster();
        Monster m5 = new Monster();
        Monster m6 = new Monster();
        
        monsterList.add(m1);
        monsterList.add(m2);
        monsterList.add(m3);
        monsterList.add(m4);
        monsterList.add(m5);
        monsterList.add(m6);
        checkPos(monsterList);
        Potion potion = new Potion();
        Farmer f1 = new Farmer();
        Farmer f2 = new Farmer();
        Armor armor = new Armor();
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = "+";
            }
        }
        for (int i = 0; i < monsterList.size(); i++){
            map[monsterList.get(i).getY()][monsterList.get(i).getX()] = monsterList.get(i);
        }
        checkPot(map, potion);
        checkFarm(map, f1);
        checkFarm(map, f2);
        Weapon dagger = new Weapon(10, 30);
        Weapon broadSword = new Weapon(20, 50);
        Hero hero = new Hero(dagger);
        map[hero.getY()][hero.getX()] = hero;
        System.out.println("** Hero & Monsters **\n");
        System.out.println("* The map has been generated *");
        System.out.println("* The items have been placed *");
        System.out.println("Hero begins his journey in the Southwest corner of Yore");
        printMap(map);
        while (run){
            heroAction = true;
            System.out.print("Enter direction (north, east, west, south): ");
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
                        System.out.println("You are already at the edge of the map.");
                        printMap(map);
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "+";
                        hero.setY(-1);
                        map[hero.getY()][hero.getX()] = hero;
                        printMap(map);
                        checkDirection = false;
                        dir = 1;
                    }
                }
                if (direction.equals("a")){
                    if (checkW(hero)){
                        System.out.println("You are already at the edge of the map.");
                        printMap(map);
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "+";
                        hero.setX(-1);
                        map[hero.getY()][hero.getX()] = hero;
                        printMap(map);
                        checkDirection = false;
                        dir = 2;
                    }
                }
                if (direction.equals("s")){
                    if (checkS(hero)){
                        System.out.println("You are already at the edge of the map.");
                        printMap(map);
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "+";
                        hero.setY(1);
                        map[hero.getY()][hero.getX()] = hero;
                        printMap(map);
                        checkDirection = false;
                        dir = 3;
                    }
                }
                if (direction.equals("d")){
                    if (checkE(hero)){
                        System.out.println("You are already at the edge of the map.");
                        printMap(map);
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "+";
                        hero.setX(1);
                        map[hero.getY()][hero.getX()] = hero;
                        printMap(map);
                        checkDirection = false;
                        dir = 4;
                    }
                }
            }
            if (potPos(potion, hero)){
                System.out.println("Hero has encountered a potion!");
                System.out.println("Hero's health has been restored to max!");
                hero.setHealth(100);
                potion.delete();
            }
            if (farmPos(f1, hero)){
                if (armorCheck){
                    System.out.println("Thank you for avenging me!");
                }
                else{
                    System.out.println("My sheep have been taken...My family is gone and I have nothing left except for bronze armor I have buried...Only a true hero may receive this.");
                    if (count >= 2){
                        System.out.println("I have noticed that you are truly a hero! Here, take this bronze armor!");
                        armorCheck = true;
                    }
                }
                map[hero.getY()][hero.getX()] = f1;
                if (dir == 1){
                    hero.setY(1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 2){
                    hero.setX(1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 3){
                    hero.setY(-1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 4){
                    hero.setX(-1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                printMap(map);
            }
            if (farmPos(f2, hero)){
                if (weaponCheck){
                    System.out.println("Thank you for avenging me!");
                }
                else{
                    System.out.println("I have nothing left except for a broad sword.  Only a true hero may receive this.");
                    if (count >= 4){
                        System.out.println("I have noticed that you are truly a hero! Here, take this broad sword!");
                        hero.updateWeapon(broadSword);
                        weaponCheck = true;
                    }
                }
                map[hero.getY()][hero.getX()] = f2;
                if (dir == 1){
                    hero.setY(1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 2){
                    hero.setX(1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 3){
                    hero.setY(-1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                else if (dir == 4){
                    hero.setX(-1);
                    map[hero.getY()][hero.getX()] = hero;
                }
                printMap(map);
            }
            if (checkMon(hero, monsterList)){
                System.out.println("Hero encounters a monster! The monster engages!");
                System.out.println("Hero has a health of " + hero.getHealth() + ". The monster has an attack of " + monsterList.get(monPos(hero, monsterList)).getAttack() + ", a speed of " + monsterList.get(monPos(hero, monsterList)).getSpeed() + ", and a health of " + monsterList.get(monPos(hero, monsterList)).getHealth() + ".");
                while (heroAction){
                    System.out.print("Enter an action (run, attack): ");
                    action = userInput.nextLine().toLowerCase();
                    while (!(action.equals("run")) && !(action.equals("attack"))){
                        System.out.println("That is not a valid option");
                        action = userInput.nextLine().toLowerCase();
                    }
                    if (action.equals("run")){
                        if (hero.run(monsterList.get(monPos(hero, monsterList)).getSpeed())){
                            System.out.println("Hero sucessfully escapes!");
                            heroAction = false;
                            map[hero.getY()][hero.getX()] = monsterList.get(monPos(hero, monsterList));
                            if (dir == 1){
                                hero.setY(1);
                                map[hero.getY()][hero.getX()] = hero;
                            }
                            else if (dir == 2){
                                hero.setX(1);
                                map[hero.getY()][hero.getX()] = hero;
                            }
                            else if (dir == 3){
                                hero.setY(-1);
                                map[hero.getY()][hero.getX()] = hero;
                            }
                            else if (dir == 4){
                                hero.setX(-1);
                                map[hero.getY()][hero.getX()] = hero;
                            }
                            printMap(map);
                        }
                        else{
                            System.out.println("Hero tries to run! The monster is too fast!");
                            if (armorCheck){
                                hero.updateHealth(-monsterList.get(monPos(hero, monsterList)).getAttack()/3);
                            }
                            else{
                                hero.updateHealth(-monsterList.get(monPos(hero, monsterList)).getAttack());
                            }
                            if (hero.getHealth() < 0){
                                hero.setHealth(0);
                            }
                            System.out.println("The monster attacks! Hero's health drops to " + hero.getHealth() + "/100");
                            if (hero.getHealth() == 0){
                                System.out.println("* Hero collapses and is struck a deadly blow by Monster *");
                                System.out.println("** Monsters in the surrounding area converge on the carcass **");
                                run = false;
                                heroDeath = true;
                                break;
                            }
                        }
                    }
                    if (action.equals("attack")){
                        System.out.println("The Hero attacks the monster!");
                        monsterList.get(monPos(hero, monsterList)).updateHealth(-hero.getWeapon().returnAttack());
                        if (monsterList.get(monPos(hero, monsterList)).getHealth() < 0){
                            monsterList.get(monPos(hero, monsterList)).setHealth(0);
                        }
                        System.out.println("The monster's health drops to " + monsterList.get(monPos(hero, monsterList)).getHealth());
                        if (monsterList.get(monPos(hero, monsterList)).getHealth() <= 0){
                            heroAction = false;
                            System.out.println("The monster has been slain!");
                            monsterList.get(monPos(hero, monsterList)).delete();
                            count += 1;
                            printMap(map);
                            break;
                        }
                        if (armorCheck){
                                hero.updateHealth(-monsterList.get(monPos(hero, monsterList)).getAttack()/3);
                            }
                            else{
                                hero.updateHealth(-monsterList.get(monPos(hero, monsterList)).getAttack());
                            }
                        if (hero.getHealth() < 0){
                            hero.setHealth(0);
                        }
                        System.out.println("The monster attacks! Hero's health drops to " + hero.getHealth() + "/100");
                        if (hero.getHealth() == 0){
                            System.out.println("* Hero collapses and is struck a deadly blow by Monster *");
                            System.out.println("** Monsters in the surrounding area converge on the carcass **");
                            run = false;
                            heroDeath = true;
                            break;
                        }
                    }
                }
            }
            if (count == 6){
                run = false;
            }
        }
        if (!heroDeath){
            System.out.println("Hero has slain the final monster!\nA fairy rises out of the chest of the final monster and restores Hero's memory which he lost after the wax melted from his wings as he foolishly tried to fly higher than the sun.\nThe fairy transports the Hero to the land in the clouds with his wings restored!\n\nThe End");
        }
    }
    
    public static void checkPos(ArrayList<Monster> monsterList){
        boolean run = true;
        int x = 10;
        int y = 10;
        while (run){
            for (int i = 0; i < monsterList.size(); i++){
                for (int j = 0; j < monsterList.size(); j++){
                    if (!(i == j)){
                        if ((x == monsterList.get(j).getX()) && (y == monsterList.get(j).getY()) || (monsterList.get(j).getX() == 0 && monsterList.get(j).getY() == 9)){
                            monsterList.get(j).setX();
                            monsterList.get(j).setY();  
                        }
                    }
                    else{
                        if (j == 5){
                            run = false; 
                        }
                    }
                }
                if (!(i == 5)){
                    x = monsterList.get(i + 1).getX();
                    y = monsterList.get(i + 1).getY();       
                }
                else{
                    x = monsterList.get(i).getX();
                    y = monsterList.get(i).getY();     
                }
            }
        }
    }
    
    public static void checkPot(Object[][] map, Potion potion){
        boolean run = true;
        while (run){
            if (map[potion.getY()][potion.getX()] == "+"){
                map[potion.getY()][potion.getX()] = potion;
                run = false;
            }
            else{
                potion.setX();
                potion.setY();
            }
        }
    }
    
    public static void checkFarm(Object[][] map, Farmer farmer){
        boolean run = true;
        while (run){
            if (map[farmer.getY()][farmer.getX()] == "+"){
                map[farmer.getY()][farmer.getX()] = farmer;
                run = false;
            }
            else{
                farmer.setX();
                farmer.setY();
            }
        }
    }
    
    public static boolean farmPos(Farmer farmer, Hero hero){
        if (farmer.getX() == hero.getX() && farmer.getY() == hero.getY()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean potPos(Potion potion, Hero hero){
        if (potion.getX() == hero.getX() && potion.getY() == hero.getY()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void printMap(Object[][] map){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
    public static boolean checkE(Hero hero){
        if (hero.getX() == 9){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean checkS(Hero hero){
        if (hero.getY() == 9){
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
    
    public static boolean checkMon(Hero hero, ArrayList<Monster> monsterList){
        for (int i = 0; i < monsterList.size(); i++){
            if (hero.getX() == monsterList.get(i).getX() && hero.getY() == monsterList.get(i).getY()){
                return true;
            }
        }
        return false;
    }
    
    public static int monPos(Hero hero, ArrayList<Monster> monsterList){
        for (int i = 0; i < monsterList.size(); i++){
            if (hero.getX() == monsterList.get(i).getX() && hero.getY() == monsterList.get(i).getY()){
                return i;
            }
        }
        return -1;
    }
}