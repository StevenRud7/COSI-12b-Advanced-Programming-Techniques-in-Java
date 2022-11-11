//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #4
//Description: This is the deck class where I create the deck and manipulate for the game, such as shuffling and discarding.
package PA4;

import java.util.*;

public class Deck {
	Random rand = new Random(); //initialize each variable for future use
	Card[] cards;
	Card[] discardPile;
	int p;
	int j=0;
	public Deck() {
		cards = new Card[52]; //create total cards
		p=52; //amount of cards
		discardPile= new Card[52]; //create the discard pile
		for (int i = 0; i < 13; i++) { //create the deck suit by suit using the idea that there are 13 of each suit
            cards[i] = new Card(i + 1, "Hearts");
            cards[i + 13] = new Card(i + 1, "Diamonds");
            cards[i + 26] = new Card(i + 1, "Clubs");
            cards[i + 39] = new Card(i + 1,"Spades");
        }
		shuffle();
	}
	public void shuffle() { // the fischer yates shuffle into java
		Card temp; //temp as temporary storage then into cards 
		int rshuf; 
		for (int y = 0; y < p; y++) { // go through each card and randomly assign to cards by using temp as the medium
			rshuf = rand.nextInt(p);
			temp = cards[y];
            cards[y] = cards[rshuf];
            cards[rshuf] = temp;
		}
	}
	public Card drawNextCard() { // take the next card then discard it 
		if (p==0) { //if one deck is gone through then reset the conditions and shuffle again
			cards = discardPile.clone(); //move the discarded cards back into original deck
			discardPile = new Card[52];
			p = 52;
			shuffle();
		}
		p--;
		Card card = cards[p];
		discard(card);
		return cards[p];
	}
	public void discard(Card c) {  //move every new card to discard pile 
		if (j==52) { //if all cards gone through then reset condition 
			//shuffle();
			j=0;
		}
		//discardPile= new Card[52];
		discardPile[j]=cards[p]; // move to discard pile
		j++;
	}
	

}
