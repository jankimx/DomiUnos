public class Table {
	Dominoes [] dominoes = new Dominoes [54];
	Tile right;
	Tile left;
	int numDoms = 0;
	int rightSide = 28;
	int leftSide  = 26;
	
	//Dominoes currently on table, not in order
	public boolean addOnTable (Dominoes toAdd) {
		if (numDoms == 0) {
		dominoes[27] = toAdd;
		right = dominoes[27].botside;
		left = dominoes[27].topside;
		numDoms++;
		return true;
		} else { //If the dominoes topside is equal to the outmost right tile, then we add that
				// domino on the right side of the array and make right equal to botside
				// we run the same idea on the other 3 cases
			if (toAdd.topside == right) {
				dominoes[rightSide] = toAdd;
				right = toAdd.botside;
				rightSide++;
				numDoms++;
				return true;
			}
			else if(toAdd.botside == right) {
				dominoes[rightSide] = toAdd;
				right = toAdd.topside;
				rightSide++;
				numDoms++;
				return true;
			}
			else if(toAdd.topside == left) {
				dominoes[leftSide] = toAdd;
				left = toAdd.botside;
				leftSide--;
				numDoms++;
				return true;
			}
			else if(toAdd.botside == left) {
				dominoes[leftSide] = toAdd;
				right = toAdd.topside;
				leftSide--;
				numDoms++;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public String toString () {
		
		String toReturn = "";
		for (int i = leftSide; i < rightSide; i++) {
			toReturn += " " + dominoes[i];
		}
		
		return toReturn;
	}
	
}
