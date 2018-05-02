import java.util.Scanner;

public class Game {
      
    static Scanner keyboard = new Scanner(System.in);
      
    //Game Pile
    PileOfDominoes GamePile = new PileOfDominoes();
    
    //Creating the table Pile -- which starts with 0 dominoes
    Table table = new Table();
    // Creating Users' Piles which will later be given 7 dominoes each
    PileOfDominoes userOneHand = new PileOfDominoes();
    PileOfDominoes userTwoHand = new PileOfDominoes();
      
    public static boolean check (int points) {
        if (points >= 100) {
            return true;
        }
        else {
            return false;
        }
    }
  
  
    public static int pointCount (PileOfDominoes players) {
        int count = 0;
        for (int i = 0; i < players.size(); i ++) {
            count = count + players.dominoes.get(i).getValue();
        }
        return count;
    }
    public  void runGame (){
	GamePile.createPile();
	GamePile.Shuffle();
	int points1 = 0;
	int points2 = 0;
	//User 1 hand
	for(int k = 0; k < 7; k ++) {
	    this.userOneHand.draw(GamePile);
	}
	//User 2 hand
	for(int k = 0; k < 7; k ++) {
	    this.userTwoHand.draw(GamePile);
	}
     
 
	if(roundEnded()) {
	    Window.pointer.frame.dispose();
	    drawing drawing = new drawing();
       
	}

    }
    public boolean endTurn (PileOfDominoes player, PileOfDominoes GamePile) {
	if (GamePile.size() > 0) {
	    return false;   
	}
        for(Dominoes current : player.dominoes) {
            if (current.botside.name()==table.right.toString() || current.botside.name()==table.left.toString()
		|| current.topside.name()==table.right.toString() || current.topside.name()==table.left.toString()) {
                return false;
            }
        }
	return true;
    }
  
    public boolean roundEnded () {
	if(userOneHand.dominoes.isEmpty()|| userTwoHand.dominoes.isEmpty()) {
	    return true;
	}
	else if (endTurn(userOneHand, GamePile) && endTurn(userTwoHand, GamePile)) {
	    return true;
	}
	return false;
    }
  
      
  
}