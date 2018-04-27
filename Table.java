public class Table {
    Dominoes [] dominoes = new Dominoes [54];
    Tile right;
    Tile left;
    int numDoms = 0;
    int rightSide = 28;
    int leftSide  = 26;
    boolean leftCovered = false;
    boolean rightCovered = false;
     
    //Dominoes currently on table, not in order
    public String addOnTable (Dominoes toAdd, int side) {
    	//FIRST DOMINO PLACING
        if (numDoms == 0) {
        dominoes[27] = toAdd;
        right = dominoes[27].botside;
        left = dominoes[27].topside;
        numDoms++;
        return "any";
        }
        
        //IF DOMINO IS NOT FIRST ONE
        else if (numDoms > 0) {
        	//IF SECOND DOMINO IS PLACED ON LEFT
        	if (leftCovered == false && side == 0) {
        		if (toAdd.topside == dominoes[27].botside || toAdd.topside == dominoes[27].topside) {
            		dominoes[leftSide] = toAdd;
            		left = toAdd.botside;
            		leftSide ++;
            		numDoms ++;
            		toAdd.last = "leftbotside";
            		leftCovered = true;
            		return "leftbotside";
            	}
        		else if (toAdd.botside == dominoes[27].botside || toAdd.botside == dominoes[27].topside) {
            		dominoes[leftSide] = toAdd;
            		left = toAdd.topside;
            		leftSide ++;
            		numDoms ++;
            		toAdd.last = "lefttopside";
            		leftCovered = true;
            		return "lefttopside";
            	}
        		else {
            		return "nothing";
            	}
        	}
        	//IF SECOND DOMINO IS PLACED ON RIGHT
        	else if (rightCovered == false && side == 1) {
        		if (toAdd.topside == dominoes[27].botside || toAdd.topside == dominoes[27].topside) {
            		dominoes[rightSide] = toAdd;
            		right = toAdd.botside;
            		rightSide ++;
            		numDoms ++;
            		toAdd.last = "rightbotside";
            		rightCovered = true;
            		return "rightbotside";
            	}
            	else if (toAdd.botside == dominoes[27].botside || toAdd.botside == dominoes[27].topside) {
            		dominoes[rightSide] = toAdd;
            		right = toAdd.topside;
            		rightSide ++;
            		numDoms ++;
            		toAdd.last = "righttopside";
            		rightCovered = true;
            		return "righttopside";
            	}
            	else {
            		return "nothing";
            	}
        	}
        	else if (leftCovered && side == 0) {
        		 if(toAdd.topside == left) {
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
        	else if (rightCovered && side == 1) {
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
        	}
        }
		return "nothing";
        }
        

    public String toString () {
         
        String toReturn = "";
        for (int i = leftSide; i < rightSide; i++) {
            toReturn += " " + dominoes[i];
        }
         
        return toReturn;
    }
     
}
