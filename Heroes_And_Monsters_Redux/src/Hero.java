public class Hero extends People{
    private int xpos;
    private int ypos;
    private int health;
    private Weapon weapon;
    private Storage storage;
    private Armor armor;
    
    public Hero(Weapon weapon, Storage storage, Armor armor){
        super(0, 14);
        xpos = 0;
        ypos = 14;
        health = 100;
        this.weapon = weapon;
        this.storage = storage;
        this.armor = armor;
    }
    
    public boolean run(int value){
        if (value == 0){
            if (Math.random() > .25){
                return true;
            }
        }
        else if (value == 1){
            if (Math.random() > .50){
                return true;
            }
        }
        else if (value == 2){
            if (Math.random() > .75){
                return true;
            }
        }
        else if (value == 3){
            return false;
        }
        return false;
    }
    
    public void setStorage(Storage storage){
        this.storage = storage;
    }
    
    public Storage getStorage(){
        return storage;
    }
    
    public void updateHealth(int value){
        health -= value;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void resetHealth(){
        health = 0;
    }
    
    public void setHealth(int value){
        health = value;
    }
    
    public int getAttack(){
        return weapon.returnAttack();
    }
    
    public int calcDam(int value){
        return armor.deflect(value);
    }
    
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    public Weapon getWeapon(){
        return weapon;
    }
    
    public int getX(){
        return xpos;
    }
    
    public void setX(int value){
        xpos += value;
    }
    
    public int getY(){
        return ypos;
    }
    
    public void setY(int value){
        ypos += value;
    }
    
    public void delete(){
        xpos = -1;
        ypos = -1;
    }
}