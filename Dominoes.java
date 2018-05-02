
public class Dominoes {
    Tile topside;
    Tile botside;
    double x = 0;
    double y = 0;
    String last = null;
    boolean specialdom;
    boolean specialdom2;
 
    //SWING JAVA GRAPHICS-----------------------
 
    public  Dominoes(Tile topside, Tile botside){
	this.topside = topside;
	this.botside = botside;
    }
 
    public String toString() {
	String toReturn ="";
	toReturn = "\n-----" + "\n" + this.topside + " |" + "\n-----" + "\n" + this.botside + " |"+ "\n-----";
	//return this.topside.toString() + "|" + this.botside.toString();
	return toReturn;
    }
    public int getValue() {
	return this.getValue();
    }
 
    //This takes a domino and compares it to the current domino.
    //If any side of it connects, then it returns true
    public boolean compare (Dominoes toCompare) {
	if(toCompare.botside == this.botside || toCompare.topside == this.botside
	   || toCompare.botside == this.topside || toCompare.topside == this.topside) {
	    return true;
	}
	else {
	    return false;
	}
    }
    public void makeSpecial() {
	this.specialdom = true;
    }
    public void makeSpecial2() {
	this.specialdom2 = true;
    }
    public boolean isSpecial() {
	return this.specialdom;
    }
    public boolean isSpecial2() {
	return this.specialdom2;
    }
}