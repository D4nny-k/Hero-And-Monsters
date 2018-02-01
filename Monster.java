public class Monster {
	
    private int attack;
    private int health;
    private int speed;
    private int xpos;
    private int ypos;
    
    public Monster() {
    	
        attack = (int)(Math.random() * 30 + 1);
        health = (int)(Math.random() * 100 + 1);
        speed = (int)(Math.random() * 3);
        xpos = (int)(Math.random() * 10);
        ypos = (int)(Math.random() * 10);
        
    }
    
    public int getX() {
    	
        return xpos;
        
    }
    
    public int getY() {
        
    	return ypos;
        
    }
    
    public void setX() {
    	
        xpos = (int)(Math.random() * 10);
        
    }
    
    public void setY() {
    	
        ypos = (int)(Math.random() * 10);
        
    }
    
    public int getSpeed() {
        
    	return speed;
    	
    }
    
    public int getAttack() {
    	
        return attack;
        
    }
    
    public void updateHealth(int value) {
    	
        health += value;
    
    }
    
    public int getHealth() {
    	
        return health;
        
    }
    
    public void setHealth(int value) {
    	
        health = value;
        
    }
    
    public void delete() {
    	
        xpos = -10;
        ypos = -10;
        
    }
    
    public String toString() {
    	
        return "M";
        
    }
}