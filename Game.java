import java.util.Scanner;
public class Game {
	
	static Scanner keyboard = new Scanner(System.in);
	
	//Game Pile
	static PileOfDominoes GamePile = new PileOfDominoes();
	
	//Creating the table Pile -- which starts with 0 dominoes
	static Table table = new Table();
	// Creating Users' Piles which will later be given 7 dominoes each
	static PileOfDominoes userOneHand = new PileOfDominoes();
	static PileOfDominoes userTwoHand = new PileOfDominoes();
	
	public static boolean check (int points) {
		if (points >= 100) {
			return true;
		}
		else {
			return false;
		}
	}

//	public static boolean roundCheck (PileOfDominoes players, Table table) {
//		for (int i = 0; i < players.size(); i ++) {
//			if (table.addOnTable(players.dominoes.get(i)) == 0) {
//				return true;
//			}
//		}
//		return false;
//	}

	public static int pointCount (PileOfDominoes players) {
		int count = 0;
		for (int i = 0; i < players.size(); i ++) {
			count = count + players.dominoes.get(i).getValue();
		}
		return count;
	}
public static void runGame (){
	GamePile.createPile();
	GamePile.Shuffle();
	int points1 = 0;
	int points2 = 0;
	int counter = 0;
	//User 1 hand
	for(int k = 0; k < 7; k ++) {
	userOneHand.draw(GamePile);
	}
	//User 2 hand
	for(int k = 0; k < 7; k ++) {
	userTwoHand.draw(GamePile);
	}
	counter = (int)(Math.random() * 1);
//	while (points1 < 100 && points2 < 100) {
//		
//		//SHUFFLE AND DISTRIBUTION
//		
//		
//		//RUN A ROUND UNTIL SOMEONE RUNS OUT OF DOMINOES
//		while (userOneHand.size() != 0 && userTwoHand.size() != 0) {
////			if (roundCheck(userOneHand, table) == false && roundCheck(userTwoHand, table) == false) {
////				break;
////			}
//			//ACTUALLY PLAYING THE GAME
//			if (counter == 0) {
//				System.out.println("Player 1's turn");
//				int choice = keyboard.nextInt();
//				table.addOnTable(userOneHand.remove(choice));
//				counter ++;
//			}
//			else if (counter == 1) {
//				System.out.println("Player 2's turn");
//				int choice = keyboard.nextInt();
//				table.addOnTable(userTwoHand.remove(choice));
//				counter --;
//			}
//		}
//		//POINT ADDER
//		points1 = points1 + pointCount(userOneHand);
//		points2 = points2 + pointCount(userTwoHand);
//	}
//	
//	
//	//IF SOMEONE WINS
//	if (check(points1) == true) {
//		System.out.println("Congratulations. Player 2 won");
//		return;
//	}
//	else if (check(points2) == true) {
//		System.out.println("Congratulations. Player 1 won");
//		return;
//}
 }

}