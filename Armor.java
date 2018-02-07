public class Armor{
    private int strength;
    
    public Armor(int strength){
        this.strength = strength;
    }
    
    public int deflect(int attack){
        return attack*strength/100;
    }
}