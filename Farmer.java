public class Farmer {
	
    private int xpos;
    private int ypos;
    
    public Farmer() {
    	
        xpos = (int)(Math.random() * 10);
        ypos = (int)(Math.random() * 10);
        
    }
    
    public void setX() {
        xpos = (int)(Math.random() * 10);
        
    }
    
    public void setY() {
        ypos = (int)(Math.random() * 10);
        
    }
    
    public int getX() {
    	
        return xpos;
        
    }
    
    public int getY() {
    	
        return ypos;
        
    }
    
    public String toString() {
    	
        return "f";
        
    }
    
}