//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #2
//Description: Problem 1, Code for a number guessing game with random number guesses. Done by a outputting a random number within range and checking if it is higher or lower or correct compared to intended number and then playing this as many times as user inputs yes. 

import java.util.Scanner;

import java.util.*; 


public class Problem1 {
	static final int max = 100; //class constant for max
	static int z = 0; //int to later find the max amount of guesses
	static int totalg=0;
	static int games=0;
	static double divide=0;
	public static void division(double divide2) { //static method for finding guesses/games with proper amount of sig figs
		divide2 = (((double)totalg/games)*10)/10;
		System.out.printf("    guesses/game  = %.1f", divide2); // use printf so i could use %.1f 
	}
	public static int greatest(int[] largest2) { //static method for deciphering largest number in an array of all guesses
		int most =0;
		for (int i =0; i<largest2.length; i++) { 
			if (largest2[i]>most) {
				most = largest2[i];
			}
		}
		return most;
	}

	public static void main(String[] args) {
		int top = 0; // create max and min to manipulate range after higher or lower input
		int bottom = max;
		System.out.println("This program allows you to play a guessing game.\n" + "Think of a number between 1 and " + bottom +"\n"+ "and I will guess until I get it.\n" + "For each guess, tell me if the\n" + "right answer is higher or lower than your guess, or if it is correct.\n");
		Scanner console = new Scanner(System.in); //beginning command for scanning
		int count = 1; //define each variable required
		int nothing = 0;
		String reply = "";
		String again ="yes";
		char ag = 'y';
		int[] largest = new int[games+max];
		Random rand = new Random();
		System.out.println("Think of a number...");
		for (int randnum = rand.nextInt(bottom)+1; ag=='y'; nothing++) { //for loop too keep going while user replies yes to playing again
			System.out.println("My guess: "+randnum); //prompt for message sentence
			reply = console.next();
			
			if (reply.equals("lower")) { //conditions for if lower. Generate a new random number less than previous guess
				bottom = randnum;
				//System.out.println(bottom);
				randnum = rand.nextInt(bottom-top)+top+1;
				count+=1;
			}
			if (reply.equals("higher")) { //conditions for if higher. Generate a new random number more than previous guess
				top = randnum;
				randnum = rand.nextInt(bottom-top)+top+1; 
				count+=1;
			}
			if (reply.equals("correct")) { //when number is guessed
				if (count==0) { // if immediately guessed then have guess number as 1
					count = 1;
				}
				System.out.println("I got it right in "+ count+ " guesses\n"); //print out statements and questions
				System.out.print("Do you want to play again? ");
				
				top = 0; //reset conditions
				bottom =100;	
				randnum = rand.nextInt(bottom)+1;
				totalg = count+totalg;	//add to total guesses		
				games+=1; //add to total games
				largest[z] = count; //create the array with all guesses inside
				z=z+1;
				count=1;
				//System.out.println(Arrays.toString(largest));
				again = console.next();
				System.out.println("");
				again = again.toLowerCase();
				ag = again.charAt(0); //check if user wants to play again and lowercase and check only first digit
				if (ag =='y') {
					System.out.println("Think of a number...");
				}
					
			}
		}
		if (ag=='n') {	//if not print final results
			divide = (((double)totalg/games)*10)/10; //create double for  total guesses over games played
			System.out.println("Overall results: \n"+"    total games   = "+games+"\n    total guesses = "+totalg); // print 2 final lines using \n for new line
			division(divide); // method for guesses divided by games
		    System.out.print("\n    max guesses   = "+greatest(largest)); //print the max amount of guesses by calling another method
		}
		
	}

}