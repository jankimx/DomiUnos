import java.util.ArrayList;
import java.util.Random;
 
public class PileOfDominoes {
     
public ArrayList<Dominoes> dominoes;
int [] badArray = {0, 1, 8, 2, 9, 16, 3, 10, 17, 24, 4, 11, 18, 25, 32, 5, 12, 19, 26, 33, 40, 6, 13, 20, 27, 34, 41, 48};
 
public PileOfDominoes() {
    this.dominoes = new ArrayList<Dominoes>();
}
 
public void createPile() {
    //Generate Dominoes
    int toDelete = 0;
    for(Tile topside: Tile.values()) {
        for(Tile botside: Tile.values()) {
 
    if (this.check(toDelete)) {
        this.dominoes.add(new Dominoes(topside, botside));
        toDelete++;     
    }       
    else{
        toDelete++;
        continue;
    }
            }
         
        }
    }
 
    public String toString() {
         
        String toPrint = "";
 
        for(Dominoes current : this.dominoes) {
            toPrint += current.toString();
        }
    return toPrint;
     
}
    public Dominoes getDomino (int i) {
    	return dominoes.get(i);
    }
    public void Shuffle () {
        Random rand = new Random();
        ArrayList<Dominoes> tempPile = new ArrayList<Dominoes>();
        int size = dominoes.size();
        for (int i = 0; i < size; i++) {
             int randomindex = rand.nextInt((this.dominoes.size() - 1 - 0) + 1) + 0;
              for(int n = 0; n < 4; n++) {
            	  Dominoes temp = tempPile.get(n);
            	  temp.makeSpecial();
            	  tempPile.set(n, temp);
              	}
              }
             tempPile.add(this.dominoes.remove(randomindex));
        }
         
        this.dominoes = tempPile;
    }
     
    public boolean check (int value) {
        boolean toReturn = false;
        for (int i = 0; i < badArray.length; i++) {
             
            if(value == badArray[i]) {
                return toReturn=true;
            }
        }
         
        return toReturn;
    }
     
    public void draw (PileOfDominoes actualPile) {
        this.dominoes.add(actualPile.dominoes.remove(0)); 
    }
    //This method will be used at the end of each round.
    //It's function is to add up the value of the dominoes that each player has
    //Of course, only player who did not win this round would want to call this method
    //We could use this method so that the game resets only when one of the two players
    //has reached, let's say, 100 points...that player would then be removed from the game
    //and the remaining players would play till there is only one left.
    public int valueOfPile () {
            int totalValue = 0;
 
            //For every domino in the pile
            for(Dominoes domino : this.dominoes){
                //Switch of possible values
                switch(domino.botside){
                case ZERO: totalValue += 0; break;
                case ONE: totalValue += 1; break;
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                 
                }   
                switch(domino.topside){
                case ZERO: totalValue += 0; break;
                case ONE: totalValue += 1; break;
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                 
                }   
            }
            return totalValue;
    }
    public Dominoes remove (int p) {
        return this.dominoes.remove(p);
    }
    public int size() {
        return dominoes.size();
    }
     
}
