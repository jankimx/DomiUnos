import java.awt.Graphics;
public class Dominoes {
Tile topside;
Tile botside;
String last = null;
boolean specialskipdom;
boolean specialdrawdom;

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
	//METHOD THAT MAKES THE SPECIAL SKIP TILE TRUE
public void makeSpecialSkip() {
	this.specialskipdom = true;
}
	//METHOD THAT RETURNS THE SPECIAL SKIP DOMINO
public boolean isSpecialSkip() {
	return this.specialskipdom;
}
	//METHOD THAT RETURNS THE SPECIAL DRAW ONE DOMINO
public void makeSpecialDraw() {
	this.specialdrawdom = true;
}
	//METHOD THAT RETURNS THE SPECIAL DRAW ONE DOMINO
public boolean isSpecialDraw() {
	return this.specialdrawdom;
}
}
