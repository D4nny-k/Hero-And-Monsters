public class Weapon{
    private int attack;
    
    public Weapon(int attack){
        this.attack = attack;
    }
    
    public int returnAttack(){
        return (int)(Math.random()*attack + 10);
    }
}