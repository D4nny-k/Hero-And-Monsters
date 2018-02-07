public class TownsPerson{
    private int xpos;
    private int ypos;
    
    public TownsPerson(){
        xpos = (int)(Math.random() * 15);
        ypos = (int)(Math.random() * 15);
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
    
    public void resetPos(){
        xpos = (int)(Math.random() * 15);
        ypos = (int)(Math.random() * 15);
    }
}