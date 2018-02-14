public class Armor{
    private int strength;
    
    public Armor(int strength){
        this.strength = strength;
    }
    
    public int deflect(int attack){
        double value = (double)strength/100;
        double count = attack*(1 - value);
        return (int)count;
    }
}