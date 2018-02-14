import java.util.*;
public class Storage{
    private int size;
    private List<Potion> potList;
    private int count;
    
    public Storage(int size, List<Potion> potList){
        this.size = size;
        this.potList = potList;
        count = 0;
    }
    
    public List<Potion> getPotList(){
        return potList;
    }
    
    public void addPot(Potion potion){
        if (count < size){
            potList.add(potion);
            count += 1;
        }
        else{
            System.out.println("You don't have enough space");
        }
    }
    
    public void usePot(Potion potion){
        count -= 1;
    }
}