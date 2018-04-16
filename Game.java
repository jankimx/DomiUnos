import java.util.Scanner;
public class Game {
public void main (String [] arg) {
	
	runGame();
}
	static Scanner keyboard = new Scanner(System.in);
 //Game Pile
	static PileOfDominoes GamePile = new PileOfDominoes();
	static Table table = new Table();
	
public boolean check (int points) {
	if (points >= 100) {
		return true;
	}
	else {
		return false;
	}
}

public boolean roundCheck (PileOfDominoes players, Table table) {
	for (int i = 0; i < players.size(); i ++) {
		if (table.addOnTable(players.dominoes.get(i))) {
			return true;
		}
	}
	return false;
}

public int pointCount (PileOfDominoes players) {
	int count = 0;
	for (int i = 0; i < players.size(); i ++) {
		count = count + players.dominoes.get(i).getValue();
	}
	return count;
}
	
public void runGame (){
	

	GamePile.createPile();
	GamePile.Shuffle();
	Scanner keyboard = new Scanner(System.in);
	
	int points1 = 0;
	int points2 = 0;
	int counter = 0;
	
	

	//System.out.print(GamePile.toString());
	
	//User 1 hand
	PileOfDominoes userOneHand = new PileOfDominoes();
	for(int k = 0; k < 7; k ++) {
	userOneHand.draw(GamePile);
	}
	



	PileOfDominoes userTwoHand = new PileOfDominoes();
	for(int k = 0; k < 2; k ++) {
		userTwoHand.draw(GamePile);
		}
		
	int temp = keyboard.nextInt();
	table.addOnTable(userOneHand.remove(temp));
	System.out.print("User One: " + userOneHand.toString());
	userOneHand.remove(4);
	
	System.out.print("User One: Place Domino number");
	System.out.println("User Two: " + userTwoHand.toString());
	
	System.out.print("User One: " + userOneHand.toString());
	
	System.out.print(GamePile.toString()); 
	System.out.println(userTwoHand.valueOfPile());
	
	//RUN THE ENTIRE GAME IN ITSELF
	counter = (int)(Math.random() * 1);
	while (points1 < 100 && points2 < 100) {
		
		//SHUFFLE AND DISTRIBUTION
		
		
		//RUN A ROUND UNTIL SOMEONE RUNS OUT OF DOMINOES
		while (userOneHand.size() != 0 && userTwoHand.size() != 0) {
			if (roundCheck(userOneHand, table) == false && roundCheck(userTwoHand, table) == false) {
				break;
			}
			//ACTUALLY PLAYING THE GAME
			if (counter == 0) {
				System.out.println("Player 1's turn");
				int choice = keyboard.nextInt();
				table.addOnTable(userOneHand.remove(choice));
				counter ++;
			}
			else if (counter == 1) {
				System.out.println("Player 2's turn");
				int choice = keyboard.nextInt();
				table.addOnTable(userTwoHand.remove(choice));
				counter --;
			}
		}
		//POINT ADDER
		points1 = points1 + pointCount(userOneHand);
		points2 = points2 + pointCount(userTwoHand);
	}
	
	
	//IF SOMEONE WINS
	if (check(points1) == true) {
		System.out.println("Congratulations. Player 2 won");
		return;
	}
	else if (check(points2) == true) {
		System.out.println("Congratulations. Player 1 won");
		return;
	}



}
}
