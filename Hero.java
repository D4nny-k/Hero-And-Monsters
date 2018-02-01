public class Hero {
	
    private int xpos;
    private int ypos;
    private int health;
    private Weapon weapon;
    
    public Hero(Weapon weapon) {
    	
        xpos = 0;
        ypos = 9;
        health = 100;
        this.weapon = weapon;
        
    }
    
    public boolean run(int speed) {
    	
        if (speed == 0){
            if (Math.random() > .25){
                return true;
                
            }
            
        }
        else if (speed == 1) {
        	
            if (Math.random() > .50) {
            	
                return true;
            
            }
        }
        else if (speed == 2) {
        	
            if (Math.random() > .75) {
            	
                return true;
            }
        }
        else if (speed == 3) {
        	
            return false;
        }
        
        return false;
        
    }
    
    public int getX() {
    	
        return xpos;
        
    }
    
    public int getY() {
    	
        return ypos;
        
    }
    
    public void setX(int value) {
    	
        xpos += value;
        
    }
    
    public void setY(int value) {
    	
        ypos += value;
    
    }
    
    public int getHealth() {
    	
        return health;
        
    }
    
    public void updateHealth(int value) {
    	
        health += value;
        
    }
    
    public void setHealth(int value) {
    	
        health = value;
        
    }
    
    public Weapon getWeapon() {
    	
        return weapon;
        
    }
    
    public void updateWeapon(Weapon weapon) {
    	
        this.weapon = weapon;
        
    }
    
    public String toString() {
    	
        return "h";
        
    }
}