public abstract class People implements Entity{
    private int xpos;
    private int ypos;
    
    public People(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }
    
    public abstract int getX();
    public abstract int getY();
    public abstract void delete();
}