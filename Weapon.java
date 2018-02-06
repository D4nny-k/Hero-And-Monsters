public class Weapon implements Entity {
    private int xpos;
    private int ypos;
    public Weapon(){
        
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
