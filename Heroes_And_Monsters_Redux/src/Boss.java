public class Boss implements Enemy{
    private int attack;
    private int health;
    private int xpos;
    private int ypos;
    
    public Boss (){
        attack = 0;
        health = 0;
        xpos = -1;
        ypos = -1;
    }
    
    public Boss(int attack, int health, int xpos, int ypos){
        this.attack = attack;
        this.health = health;
        this.xpos = xpos;
        this.ypos = ypos;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getX(){
        return xpos;
    }
    
    public int getY(){
        return ypos;
    }
    
    public void updateHealth(int value){
        health -= value;
    }
    
    public void delete(){
        xpos = -1;
        ypos = -1;
    }
    
    public void resetHealth(){
        health = 0;
    }
}