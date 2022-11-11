//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #4
//Description: This is the main Casino class where I set up the game utilizing the methods in the card and deck class.

package PA4;

import java.util.*;

public class Casino {

	public static void main(String[] args) {
		int bet; // bet variable for later
		int Cash = 100; // the amount of cash you come in with. Could be changed for whatever amount you want.
		//int count =0; (was used in debugging to count the amount of rounds) 
		Deck d1 = new Deck(); //initialize the deck
		Scanner console = new Scanner(System.in); //beginning command for scanning
		String reply = "yes";
		System.out.println("You come in with " + Cash + "$\n");
		while (reply.toLowerCase().charAt(0)!='n') { //keeps going until someone says any variation of No (as long as first letter is an n)
			System.out.print("Input your bet ");
			bet = console.nextInt(); //gets bet value
			if (bet>Cash) { // if bet greater than cash do an if and then just redo the bet command
				System.out.print("Input a bet lower than your total cash of " + Cash + "$:");
				bet = console.nextInt();
			}
			Card user = d1.drawNextCard(); // get each card and then print
			Card comp = d1.drawNextCard();
			System.out.println("Your card: "+user);
			System.out.println("Dealer's card: "+comp);
			//count++;
			//System.out.println(count);
			if (user.getValue()<=comp.getValue()) { //if yours is less than or equal than dealers, you lost
				Cash = Cash - bet;
				System.out.println("\nYou lost, you have " + Cash + "$ left.");
			}
			if (user.getValue()>comp.getValue()) { // if yours is greater than dealers, you won
				Cash = Cash + bet;
				System.out.println("\nYou Won! You have " + Cash + "$ left.");
			}
			if (Cash ==0) { // if you run out of money break out and end game
				System.out.println("You ran out of money. Game over");
				break;
			}
			System.out.print("Would you like to go again? Yes or No "); //go again or stop
			reply = console.next();
			System.out.print("\n"); 
			if (reply.toLowerCase().charAt(0)=='n') { //create an output message if done playing
				System.out.println("You are leaving with " + Cash+ "$");
			}
		}

	}

}
