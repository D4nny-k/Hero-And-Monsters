public class Boss implements Enemy{
    private int attack;
    private int health;
    private int speed;
    
    public Boss(int attack, int health, int speed){
        this.attack = attack;
        this.health = health;
        this.speed = speed;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void updateHealth(int value){
        health -= value;
    }
    
    public void resetHealth(){
        health = 0;
    }
}