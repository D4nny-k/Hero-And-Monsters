import java.util.*;
public class Driver{
    public static void main(String args[]){
        Object[][] map = new Object[15][15];
        Scanner userInput = new Scanner(System.in);
        boolean run = true;
        boolean checkDirection = false;
        boolean satchelStat = false;
        int coins = 0;
        int townNum = -1;
        String choice;
        String direction = "";
        String action = "";
        Monster monster;
        Boss b1 = new Boss();
        Boss b2 = new Boss();
        Boss b3 = new Boss();
        boolean heroAction = true;
        boolean heroFight = false;
        boolean shop = true;
        boolean sandals = false;
        boolean phoenix = false;
        boolean shortSwordStat = false;
        boolean longSwordStat = false;
        boolean boss1 = false;
        boolean boss2 = false;
        String pot = "";
        int randDir = 0;
        String monsDir = "";
        
        ArrayList<Entity> entityList = new ArrayList<Entity>();
        ArrayList<TownsPerson> townList = new ArrayList<TownsPerson>();
        ArrayList<Potion> potList = new ArrayList<Potion>();
        Weapon dagger = new Weapon(20, "Dagger");
        Weapon shortSword = new Weapon(30, "Short Sword");
        Weapon longSword = new Weapon(50, "Long Sword");
        Weapon battleAxe = new Weapon(100, "Battle Axe");
        Storage trousers = new Storage(3, potList);
        Storage satchel = new Storage(9, potList);
        Potion p1 = new Potion("half");
        Potion p2 = new Potion("full");
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
        System.out.println("Press Enter To Start");
        action = userInput.nextLine();
        while (!action.equals("")){
            action = userInput.nextLine();
        }
        printMap(map, hero, coins);
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
                        printMap(map, hero, coins);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setY(-1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map, hero, coins);
                        checkDirection = false;
                    }
                }
                if (direction.equals("a")){
                    if (checkW(hero)){
                        clear();
                        printMap(map, hero, coins);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setX(-1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map, hero, coins);
                        checkDirection = false;
                    }
                }
                if (direction.equals("s")){
                    if (checkS(hero)){
                        clear();
                        printMap(map, hero, coins);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setY(1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map, hero, coins);
                        checkDirection = false;
                    }
                }
                if (direction.equals("d")){
                    if (checkE(hero)){
                        clear();
                        printMap(map, hero, coins);
                        System.out.println("You are already at the edge of the map.\n");
                        checkDirection = false;
                    }
                    else{
                        map[hero.getY()][hero.getX()] = "[   ]";
                        hero.setX(1);
                        map[hero.getY()][hero.getX()] = "[ H ]";
                        clear();
                        printMap(map, hero, coins);
                        checkDirection = false;
                    }
                }
            }
            if (checkOne(hero, townList) != -1){
                townNum = checkOne(hero, townList);
                map[townList.get(townNum).getY()][townList.get(townNum).getX()] = "[ T ]";
            }
            if ((Math.random()*100 <= 5)){
                System.out.println("Hero has encountered a Monster!");
                pot = "";
                heroAction = true;
                randDir = (int)(Math.random()*4);
                if (randDir == 0){
                    monsDir = "north";
                }
                else if (randDir == 1){
                    monsDir = "south";
                }
                else if (randDir == 2){
                    monsDir = "east";
                }
                else if (randDir == 3){
                    monsDir = "west";
                }
                monster = new Monster(monsDir);
                System.out.println("Monster HP: " + monster.getHealth() + "\nMonster Attack: " + monster.getAttack() + "\nMonster Speed: " + monster.getSpeed() + "\nMonster Direction: " + monster.getDirection());
                while (heroAction){
                    System.out.print("\nEnter an action(attack, run, potion): ");
                    action = userInput.nextLine().toLowerCase();
                    while (!action.equals("attack") && !action.equals("run") && !action.equals("potion")){
                        System.out.println("That is not a valid action");
                        System.out.print("\nEnter an action(attack, run, potion): ");
                        action = userInput.nextLine().toLowerCase();
                    }
                    if (action.equals("attack")){
                        System.out.println("Hero attacks the monster!");
                        if (sandals){
                            monster.updateHealth(2*hero.getAttack());
                            System.out.println("Hero attacks twice!");
                        }
                        else{
                            monster.updateHealth(hero.getAttack());
                        }
                        if (monster.getHealth() < 0){
                            monster.resetHealth();
                        }
                        System.out.println("The monster's health drops to " + monster.getHealth());
                        if (monster.getHealth() == 0){
                            heroAction = false;
                            System.out.println("The monster has been slain\n");
                            printMap(map, hero, coins);
                            coins += 10;
                            break;
                        }
                        hero.updateHealth(hero.calcDam(monster.getAttack()));
                        if (hero.getHealth() < 0){
                            hero.resetHealth();
                        }
                        System.out.println("The monster attacks! Hero's health drops to " + hero.getHealth());
                        if (hero.getHealth() == 0){
                            if (phoenix){
                                hero.setHealth(100);
                                System.out.println("You have used your phoenix potion!");
                                phoenix = false;
                            }
                            else{
                                System.out.print("Hero is slain...");
                                run = false;
                                break;
                            }
                        }
                    }
                    if (action.equals("run")){
                        if (hero.run(monster.getSpeed())){
                            heroAction = false;
                            System.out.println("Hero successfully escapes");
                            break;
                        }
                        else{
                            System.out.println("Hero tries to run! The monster is too fast!");
                            hero.updateHealth(monster.getAttack());
                            if (hero.getHealth() < 0){
                                hero.resetHealth();
                            }
                            System.out.println("The monster attacks! Hero's health drops to " + hero.getHealth());
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (action.equals("potion")){
                        while (!pot.equals("exit")){
                            if (hero.getStorage().getPotList().size() == 0){
                                System.out.println("You have no potions!");
                            }
                            for (int i = 0; i < hero.getStorage().getPotList().size(); i++){
                                System.out.print(i + ". " + hero.getStorage().getPotList().get(i).toString() + "\n");
                            }
                            System.out.println("Type Exit to Exit");
                            pot = userInput.nextLine().toLowerCase();
                            if (pot.matches("[0-9]+")){
                                hero.setHealth(100);
                                System.out.println("Hero's health has been restored");
                            }
                        }
                        hero.updateHealth(hero.calcDam(monster.getAttack()));
                        System.out.println("The monster attacks!");
                        if (hero.getHealth() == 0){
                            if (phoenix){
                                hero.setHealth(100);
                                System.out.println("You have used your phoenix potion!");
                                phoenix = false;
                            }
                            else{
                                System.out.print("Hero is slain...");
                                run = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (checkTown(hero, townList) == 0){
                System.out.println("Welcome to the Shop!\n1. Short Sword - 200g\n2. Long Sword - 250g\n3. Satchel - 50g\n4.Sandals - 100g\n5. 1/2 Energy Potion - 10g\n6. Full Energy Potion - 20g\n7. Phoenix Down Potion - 50g\n8. Battle Axe - 1000000g\n9. Exit");
                choice = userInput.nextLine();
                while (!choice.matches("[0-9]+")){
                    System.out.println("That is not a valid option.");
                    choice = userInput.nextLine();
                }
                while (shop){
                    if (choice.equals("1")){
                        if (coins - 200 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 200;
                            hero.setWeapon(shortSword);
                            shortSwordStat = true;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("2")){
                        if (coins - 250 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 250;
                            hero.setWeapon(longSword);
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("3")){
                        if (coins - 50 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 50;
                            hero.setStorage(satchel);
                            satchelStat = true;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("4")){
                        if (coins - 100 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 100;
                            sandals = true;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("5")){
                        if (coins - 10 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 10;
                            potList.add(p1);
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("6")){
                        if (coins - 20 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            potList.add(p2);
                            coins -= 20;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("7")){
                        if (coins - 50 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 50;
                            phoenix = true;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("8")){
                        if (coins - 1000000 < 0){
                            System.out.println("You do not have enough funds");
                        }
                        else{
                            coins -= 1000000;
                            System.out.println("Purchase Successful.");
                        }
                    }
                    else if (choice.equals("9")){
                        clear();
                        printMap(map, hero, coins);
                        break;
                    }
                    choice = userInput.nextLine();
                }
            }
            if (checkTown(hero, townList) == 1){
                clear();
                System.out.println("Here is a map of all the townspeople!");
                for (TownsPerson i:townList){
                    map[i.getY()][i.getX()] = "[ T ]";
                }
                printMap(map, hero, coins);
            }
            if (checkTown(hero, townList) == 2){
                if (satchelStat && !boss1){
                    System.out.println("Please free me from my curse...\nThe coordinates have been marked on your minimap");
                    b1 = new Boss(25, 150, 0, 0);
                    map[b1.getY()][b1.getX()] = "[ B ]";
                }
                else{
                    if (boss1){
                        System.out.println("Thank you for freeing me from my curse!");
                    }
                    else{
                        System.out.println("You are not yet strong enough to free me from my curse...Buy a satchel before finding me again...");
                    }
                }
            }
            if (checkTown(hero, townList) == 3){
                if (shortSwordStat && !boss2 && boss1){
                    System.out.println("Please free me from my curse...\nThe coordinates have been marked on your minimap");
                    b2 = new Boss(25, 200, 14, 0);
                    map[b2.getY()][b2.getX()] = "[ B ]";
                }
                else{
                    if (boss2){
                        System.out.println("Thank you for freeing me from my curse");
                    }
                    else{
                        System.out.println("You are not yet strong enough to free me from my curse...Buy a Short Sword and kill the first Boss before finding me again...");
                    }
                }
            }
            if (checkTown(hero, townList) == 4){
                if (longSwordStat && boss1 && boss2){
                    System.out.println("Please free me from my curse...\nThe coordinates have been marked on your minimap");
                    b3 = new Boss(25, 250, 14, 14);
                    map[b3.getY()][b3.getX()] = "[ B ]";
                }
                else{
                    System.out.println("You are not yet strong enough to free me from my curse...Buy a Long Sword and kill the second Boss before finding me again...");
                }
            }
            if (checkBoss(b1, hero)){
                System.out.println("You have encountered a Boss!");
                boolean bossFight = true;
                while (bossFight){
                    heroAction = true;
                    System.out.println("Boss HP: " + b1.getHealth() + "\nBoss Attack: " + b1.getAttack());
                    while (heroAction){
                        pot = "";
                        System.out.print("\nEnter an action(attack, potion): ");
                        action = userInput.nextLine().toLowerCase();
                        while (!action.equals("attack") && !action.equals("potion")){
                            System.out.println("That is not a valid action");
                            System.out.print("\nEnter an action(attack, potion): ");
                            action = userInput.nextLine().toLowerCase();
                        }
                        if (action.equals("attack")){
                            System.out.println("Hero attacks the Boss!");
                            if (sandals){
                                b1.updateHealth(2*hero.getAttack());
                                System.out.println("Hero attacks twice!");
                            }
                            else{
                                b1.updateHealth(hero.getAttack());
                            }
                            if (b1.getHealth() < 0){
                                b1.resetHealth();
                            }
                            System.out.println("The Boss's health drops to " + b1.getHealth());
                            if (b1.getHealth() == 0){
                                heroAction = false;
                                System.out.println("The Boss has been slain\n");
                                System.out.println("You loot the Boss' body...You find 200 coins and a phoenix potion.");
                                phoenix = true;
                                boss1 = true;
                                b1.delete();
                                printMap(map, hero, coins);
                                coins += 200;
                                bossFight = false;
                                break;
                            }
                            hero.updateHealth(hero.calcDam(b1.getAttack()));
                            if (hero.getHealth() < 0){
                                hero.resetHealth();
                            }
                            System.out.println("The Boss attacks! Hero's health drops to " + hero.getHealth());
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                        if (action.equals("potion")){
                            while (!pot.equals("exit")){
                                if (hero.getStorage().getPotList().size() == 0){
                                    System.out.println("You have no potions!");
                                }
                                for (int i = 0; i < hero.getStorage().getPotList().size(); i++){
                                    System.out.print(i + ". " + hero.getStorage().getPotList().get(i).toString() + "\n");
                                }
                                System.out.println("Type Exit to Exit");
                                pot = userInput.nextLine().toLowerCase();
                                if (pot.matches("[0-9]+")){
                                    hero.setHealth(100);
                                    System.out.println("Hero's health has been restored");
                                }
                            }
                            hero.updateHealth(hero.calcDam(b1.getAttack()));
                            System.out.println("The Boss attacks!");
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (checkBoss(b2, hero)){
                System.out.println("You have encountered a Boss!");
                boolean bossFight = true;
                while (bossFight){
                    heroAction = true;
                    System.out.println("Boss HP: " + b2.getHealth() + "\nBoss Attack: " + b2.getAttack());
                    while (heroAction){
                        pot = "";
                        System.out.print("\nEnter an action(attack, potion): ");
                        action = userInput.nextLine().toLowerCase();
                        while (!action.equals("attack") && !action.equals("potion")){
                            System.out.println("That is not a valid action");
                            System.out.print("\nEnter an action(attack, potion): ");
                            action = userInput.nextLine().toLowerCase();
                        }
                        if (action.equals("attack")){
                            System.out.println("Hero attacks the Boss!");
                            if (sandals){
                                b2.updateHealth(2*hero.getAttack());
                                System.out.println("Hero attacks twice!");
                            }
                            else{
                                b2.updateHealth(hero.getAttack());
                            }
                            if (b2.getHealth() < 0){
                                b2.resetHealth();
                            }
                            System.out.println("The Boss's health drops to " + b2.getHealth());
                            if (b2.getHealth() == 0){
                                heroAction = false;
                                System.out.println("The Boss has been slain\n");
                                System.out.println("You loot the Boss' body...You find 250 coins and a phoenix potion.");
                                phoenix = true;
                                b2.delete();
                                printMap(map, hero, coins);
                                boss2 = true;
                                bossFight = false;
                                coins += 250;
                                break;
                            }
                            hero.updateHealth(hero.calcDam(b2.getAttack()));
                            if (hero.getHealth() < 0){
                                hero.resetHealth();
                            }
                            System.out.println("The Boss attacks! Hero's health drops to " + hero.getHealth());
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                        if (action.equals("potion")){
                            while (!pot.equals("exit")){
                                if (hero.getStorage().getPotList().size() == 0){
                                    System.out.println("You have no potions!");
                                }
                                for (int i = 0; i < hero.getStorage().getPotList().size(); i++){
                                    System.out.print(i + ". " + hero.getStorage().getPotList().get(i).toString() + "\n");
                                }
                                System.out.println("Type Exit to Exit");
                                pot = userInput.nextLine().toLowerCase();
                                if (pot.matches("[0-9]+")){
                                    hero.setHealth(100);
                                    System.out.println("Hero's health has been restored");
                                }
                            }
                            hero.updateHealth(hero.calcDam(b2.getAttack()));
                            System.out.println("The Boss attacks!");
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if  (checkBoss(b3, hero)){
                System.out.println("You have encountered the Final Boss!");
                boolean bossFight = true;
                while (bossFight){
                    heroAction = true;
                    System.out.println("Boss HP: " + b3.getHealth() + "\nBoss Attack: " + b3.getAttack());
                    while (heroAction){
                        pot = "";
                        System.out.print("\nEnter an action(attack, potion): ");
                        action = userInput.nextLine().toLowerCase();
                        while (!action.equals("attack") && !action.equals("potion")){
                            System.out.println("That is not a valid action");
                            System.out.print("\nEnter an action(attack, potion): ");
                            action = userInput.nextLine().toLowerCase();
                        }
                        if (action.equals("attack")){
                            System.out.println("Hero attacks the Boss!");
                            if (sandals){
                                b3.updateHealth(2*hero.getAttack());
                                System.out.println("Hero attacks twice!");
                            }
                            else{
                                b3.updateHealth(hero.getAttack());
                            }
                            if (b3.getHealth() < 0){
                                b3.resetHealth();
                            }
                            System.out.println("The Boss's health drops to " + b3.getHealth());
                            if (b3.getHealth() == 0){
                                heroAction = false;
                                System.out.println("The Boss has been slain\n");
                                System.out.println("You Win!");
                                break;
                            }
                            hero.updateHealth(hero.calcDam(b3.getAttack()));
                            if (hero.getHealth() < 0){
                                hero.resetHealth();
                            }
                            System.out.println("The Boss attacks! Hero's health drops to " + hero.getHealth());
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                        if (action.equals("potion")){
                            while (!pot.equals("exit")){
                                if (hero.getStorage().getPotList().size() == 0){
                                    System.out.println("You have no potions!");
                                }
                                for (int i = 0; i < hero.getStorage().getPotList().size(); i++){
                                    System.out.print(i + ". " + hero.getStorage().getPotList().get(i).toString() + "\n");
                                }
                                System.out.println("Type Exit to Exit");
                                pot = userInput.nextLine().toLowerCase();
                                if (pot.matches("[0-9]+")){
                                    hero.setHealth(100);
                                    System.out.println("Hero's health has been restored");
                                }
                            }
                            hero.updateHealth(hero.calcDam(b3.getAttack()));
                            System.out.println("The Boss attacks!");
                            if (hero.getHealth() == 0){
                                if (phoenix){
                                    hero.setHealth(100);
                                    System.out.println("You have used your phoenix potion!");
                                    phoenix = false;
                                }
                                else{
                                    System.out.print("Hero is slain...");
                                    run = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void printMap(Object[][] map, Hero hero, int coins){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("Weapon: " + hero.getWeapon().getName() + " Armor: Leather Breastplate " + "Health: " + hero.getHealth() + " Coins: " + coins);
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
                if ((map[i.getY()][i.getX()] == "[ ? ]") && (i.getX() != 0 && i.getY() != 0) && (i.getX() != 14 && i.getY() != 0) && (i.getX() != 14 && i.getY() != 14)){
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
    
    public static boolean checkBoss(Boss boss, Hero hero){
        if ((boss.getX() == hero.getX()) && (boss.getY() == hero.getY())){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static int checkOne(Hero hero, ArrayList<TownsPerson> townList){
        for (int i = 0; i < townList.size(); i++){
            if ((hero.getX() + 1 == townList.get(i).getX() && hero.getY() + 1 == townList.get(i).getY()) || (hero.getX() + 1 == townList.get(i).getX() && hero.getY() - 1 == townList.get(i).getY()) || (hero.getX() - 1 == townList.get(i).getX() && hero.getY() + 1 == townList.get(i).getY()) || (hero.getX() - 1 == townList.get(i).getX() && hero.getY() - 1 == townList.get(i).getY()) || (hero.getX() + 1 == townList.get(i).getX() && hero.getY() == townList.get(i).getY()) || (hero.getX() - 1 == townList.get(i).getX() && hero.getY() == townList.get(i).getY()) || (hero.getX() == townList.get(i).getX() && hero.getY() + 1 == townList.get(i).getY()) || (hero.getX() == townList.get(i).getX() && hero.getY() - 1 == townList.get(i).getY())){
                return i;
            }
        }
        return -1;
    }
    
    public static int checkTown(Hero hero, ArrayList<TownsPerson> townList){
        for (int i = 0; i < townList.size(); i++){
            if (hero.getX() == townList.get(i).getX() && hero.getY() == townList.get(i).getY()){
                return i;
            }
        }
        return -1;
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
