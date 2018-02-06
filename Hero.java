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
    }
    
    public int getX(){
        return xpos;
    }
    
    public int getY(){
        return ypos;
    }
    
    public void delete(){
        xpos = -1;
        ypos = -1;
    }
}
