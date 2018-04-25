public class Table {
    Dominoes [] dominoes = new Dominoes [54];
    Tile right;
    Tile left;
    int numDoms = 0;
    int rightSide = 28;
    int leftSide  = 26;
     
    //Dominoes currently on table, not in order
    public String addOnTable (Dominoes toAdd) {
        if (numDoms == 0) {
        dominoes[27] = toAdd;
        right = dominoes[27].botside;
        left = dominoes[27].topside;
        numDoms++;
        return "any";
        }
        else if (numDoms == 1) {
        	if (toAdd.topside == dominoes[27].botside || toAdd.topside == dominoes[27].topside) {
        		dominoes[rightSide] = toAdd;
        		right = toAdd.botside;
        		rightSide ++;
        		numDoms ++;
        		toAdd.last = "rightbotside";
        		return "rightbotside";
        	}
        	else if (toAdd.botside == dominoes[27].botside || toAdd.botside == dominoes[27].topside) {
        		dominoes[rightSide] = toAdd;
        		right = toAdd.topside;
        		rightSide ++;
        		numDoms ++;
        		toAdd.last = "righttopside";
        		return "righttopside";
        	}
        	else {
        		return "nothing";
        	}
        }
        else if (numDoms == 2) {
        	if (toAdd.topside == dominoes[27].botside || toAdd.topside == dominoes[27].topside) {
        		dominoes[leftSide] = toAdd;
        		left = toAdd.botside;
        		leftSide ++;
        		numDoms ++;
        		toAdd.last = "leftbotside";
        		return "leftbotside";
        	}
        	else if (toAdd.botside == dominoes[27].botside || toAdd.botside == dominoes[27].topside) {
        		dominoes[leftSide] = toAdd;
        		left = toAdd.topside;
        		leftSide ++;
        		numDoms ++;
        		toAdd.last = "lefttopside";
        		return "lefttopside";
        	}
        	else if (toAdd.topside == right) {
                dominoes[rightSide] = toAdd;
                right = toAdd.botside;
                rightSide++;
                numDoms++;
                toAdd.last = "rightbotside";
                return "rightbotside";
            }
            else if(toAdd.botside == right) {
                dominoes[rightSide] = toAdd;
                right = toAdd.topside;
                rightSide++;
                numDoms++;
                toAdd.last = "righttopside";
                return "righttopside";
            }
            else {
            	return "nothing";
            }
        		
        }
        else { //If the dominoes topside is equal to the outmost right tile, then we add that
                // domino on the right side of the array and make right equal to botside
                // we run the same idea on the other 3 cases
            if (toAdd.topside == right) {
                dominoes[rightSide] = toAdd;
                right = toAdd.botside;
                rightSide++;
                numDoms++;
                toAdd.last = "rightbotside";
                return "rightbotside";
            }
            else if(toAdd.botside == right) {
                dominoes[rightSide] = toAdd;
                right = toAdd.topside;
                rightSide++;
                numDoms++;
                toAdd.last = "righttopside";
                return "righttopside";
            }
            else if(toAdd.topside == left) {
                dominoes[leftSide] = toAdd;
                left = toAdd.botside;
                leftSide--;
                numDoms++;
                toAdd.last = "leftbotside";
                return "leftbotside";
            }
            else if(toAdd.botside == left) {
                dominoes[leftSide] = toAdd;
                right = toAdd.topside;
                leftSide--;
                numDoms++;
                toAdd.last = "lefttopside";
                return "lefttopside";
            }
            else {
            	return "nothing";
            }
        }
    }
     
//  public void addOnTable (Dominoes toAdd) {
//      if (numDoms == 0) {
//          dominoes[27] = toAdd;
//          numDoms ++;
//      }
//      else {
//      dominoes[rightSide] = toAdd;
//      rightSide ++;
//      numDoms ++;
//      }
//  }
    public String toString () {
         
        String toReturn = "";
        for (int i = leftSide; i < rightSide; i++) {
            toReturn += " " + dominoes[i];
        }
         
        return toReturn;
    }
     
}
