//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #4
//Description: This is the card class where I set up the cards and their various properties (like value and string name)

package PA4;

import java.util.*;

public class Card {
	int value2; //initialize each variable
	String suit2;
	String valuename = "";
	
	public Card(int value, String suit) {
		
		value2=value; //defining the parameters 
		suit2=suit;
		if (value==1) { //Name for each face card
			this.value2=14; // remove this to have ace lose all the time or keep for more original rules where ace wins
			valuename = "Ace";
		}
		if (value==11) {
			valuename = "Jack";
		}
		if (value==12) {
			valuename = "Queen";
		}
		if (value==13) {
			valuename = "King";
		}
		
	}
	public int getValue() { //simply return value of a card from the Card parameter
		return value2;
	}
	public String getColor() { // get the suits color either red or black
		String red = "red";
		String black = "black";
		if (suit2.toLowerCase().equals("hearts") || suit2.toLowerCase().equals("diamonds")) { //check if red (hearts or diamonds)
			return red;
		}
		else { //if not red then its black
			return black;
		}
	}
	public String getSuit() { //simply return the suit from the Card parameter
		return suit2;
	}
	public String toString() { //combining everything return the cards full name to use when playing the game (show what card the user and dealer got)
		if (value2>=11 || value2==1) {
			return valuename + " of " + suit2; //if face do use face variable 
		}
		else {
			return value2 + " of " + suit2; //otherwise just use number value
		}
	}
	
}
