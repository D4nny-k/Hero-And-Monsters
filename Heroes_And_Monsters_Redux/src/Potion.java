public class Potion{
    public String strength;
    
    public Potion(String strength){
        this.strength = strength;
    }
    
    public String getStrength(){
        if (strength.equals("half")){
            return "half";
        }
        if (strength.equals("full")){
            return "full";
        }
        return null;
    }
    
    public String toString(){
        if (strength.equals("half")){
            return "Half";
        }
        if (strength.equals("full")){
            return "Full";
        }
        return "None";
    }
}