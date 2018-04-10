import java.util.Scanner;
public class Game {
public static void main (String [] arg) {
	runGame();
}
	static Scanner keyboard = new Scanner(System.in);
 //Game Pile
	static PileOfDominoes GamePile = new PileOfDominoes();
	static Table table = new Table();
	
public static void runGame (){
	

	GamePile.createPile();
	GamePile.Shuffle();
	//System.out.print(GamePile.toString());
	
	//User 1 hand
	PileOfDominoes userOneHand = new PileOfDominoes();
	for(int k = 0; k < 7; k ++) {
	userOneHand.draw(GamePile);
	}

	
	//User 2 hand
/*	PileOfDominoes userTwoHand = new PileOfDominoes();
	for(int k = 0; k < 2; k ++) {
		userTwoHand.draw(GamePile);
		}
		
*///	int temp = keyboard.nextInt();
	//table.addOnTable(userOneHand.remove(temp));
	System.out.print("User One: " + userOneHand.toString());
	userOneHand.remove(4);
	
	System.out.print("User One: Place Domino number");
	//System.out.println("User Two: " + userTwoHand.toString());
	
	System.out.print("User One: " + userOneHand.toString());
	
	//System.out.print(GamePile.toString()); 
	//System.out.println(userTwoHand.valueOfPile());

}
}
