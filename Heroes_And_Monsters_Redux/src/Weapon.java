public class Weapon{
    private int attack;
    private String name;
    
    public Weapon(int attack, String name){
        this.attack = attack;
        this.name = name;
    }
    
    public int returnAttack(){
        return (int)(Math.random()*10 + attack);
    }
    
    public String getName(){
        return name;
    }
}