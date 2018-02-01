public class Weapon {
	
    private int bottomValue;
    private int topValue;
    
    public Weapon(int bottomValue, int topValue) {
        this.bottomValue = bottomValue;
        this.topValue = topValue;
        
    }
    
    public int returnAttack() {
    	
        return (int)(Math.random()*bottomValue + (topValue - bottomValue));
        
    }
}