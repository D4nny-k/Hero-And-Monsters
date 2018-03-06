public class Monster implements Enemy{
    private int attack;
    private int health;
    private int speed;
    private String direction;
    
    public Monster(String direction){
        attack = (int)(Math.random() * 25 + 5);
        health = (int)(Math.random() * 80 + 20);
        speed = (int)(Math.random()* 3);
        this.direction = direction;
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
    
    public String getDirection(){
        return direction;
    }
    
    public void updateHealth(int value){
        health -= value;
    }
    
    public void resetHealth(){
        health = 0;
    }
}
