//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #2
//Description: Problem 2, Code for a reverse hang man by creating a static for generating a new random letter and then removing it, a static to add the appropriate hangman structure, and then going through the responses of the user and outputting what is said and fitting


import java.util.*; 


public class Problem2 {
	static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //statics for alphabet and amount of letters in alphabet
	static int alphanum = 25;
	public static char randletter() { //static method to get a random letter and then remove it from the alphabet string
		Random rand = new Random();
		int lettervalue = rand.nextInt(alphanum);
		char guessed = alpha.charAt(lettervalue);
		alpha = alpha.substring(0,lettervalue) + alpha.substring(lettervalue+1); //removes the guessed letter
		alphanum = alphanum-1; //lowers amount of letters as one was guessed
		return guessed;
	}
	public static void hangman(int x2) { //static method to print the hang man structure depending on number of mistakes
		String zero = "\n +--+\n |  |\n |\n |\n |\n |\n +-----"; //all strings for each hang man variation
		String one = "\n +--+\n |  |\n |  O\n |\n |\n |\n +-----";
		String two = "\n +--+\n |  |\n |  O\n |  |\n |\n |\n +-----";
		String three = "\n +--+\n |  |\n |  O\n |  |\n |   \\\n |\n +-----";
		String four = "\n +--+\n |  |\n |  O\n |  |\n | / \\\n |\n +-----";
		String five = "\n +--+\n |  |\n |  O\n |  |\\\n | / \\\n |\n +-----";
		String six = "\n +--+\n |  |\n |  O\n | /|\\\n | / \\\n |\n +-----";
		if (x2==0) { 			//if statements to check mistake number and then printing the according hang man
			System.out.println(zero);
		}
		if (x2==1) {
			System.out.println(one);
		}
		if (x2==2) {
			System.out.println(two);
		}
		if (x2==3) {
			System.out.println(three);
		}
		if (x2==4) {
			System.out.println(four);
		}
		if (x2==5) {
			System.out.println(five);
		}
		if (x2==6) {
			System.out.println(six);
		}
		if (x2 ==7) {
			System.out.println(six);
		}
	}

	public static void main(String[] args) {
		//Print the initial lines
		System.out.println("This program plays a game of reverse hangman.\n" + "You think up a word (by typing it on the computer) and I'll try to guess\n" + "the letters.");
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("\nHow many letters are in your word? "); //prompt letter amount
		int amount = console.nextInt();
		System.out.print("Please enter the word for me to guess (letters only): "); //prompt for word
		String word = console.next();
		int right = 0;
		String lines ="";
		String firstlines ="";
		for (int i =0; i<amount; i++) { //printing the initial empty dashes for word
			firstlines = firstlines + "- ";
			
		}
		//System.out.println("\n"+lines);
		for (int i =0; i<amount; i++) { //printing the dashes together to later allow for letters to be properly added
			lines = lines + "-";
			
		}
		System.out.println("\n"+firstlines);
		hangman(0);
		char answer;
		for (int x =1; x<=7; x++) {
			char c = randletter(); //define the random letter
			String lines2="";
			System.out.println("\nI've got "+right +" of the "+amount+" letters so far"); // prompts for showing the current standing of the hang man game
			System.out.println("I guess: " + c);
			System.out.print("Is that letter in the word? "); //prompt for if letter is in word
			answer = console.next().charAt(0);
			c = Character.toLowerCase(c);
			//System.out.println(c);
			if (answer =='y') {
				x=x-1; //to remove the mistake auto added since correct
				
				System.out.print("How many of that letter are in the word? "); //prompt for letter amount
				int letperword = console.nextInt();
				for (int z =0; z<letperword; z++) { //for loop for letter amount in the word
					for (int z2 =0; z2<amount; z2++) { //goes through to add letter at the required place
						//System.out.print(word.charAt(z2));
						if (c==word.charAt(z2)) {
							char h = word.charAt(z2);
							lines=lines.substring(0, z2) + h + lines.substring(z2+1);
							//System.out.println(h);
						}
					}
				}
				right = right +(letperword*1);
				System.out.println("");
				for (int z3 =0; z3<(amount); z3++) { //add spaces between each letter and dash
					char h2 = lines.charAt(z3);
					lines2 = h2 + " ";
					System.out.print(lines2);
				}
				
				System.out.println("");
				hangman(x);
				//System.out.println(x);
			}
			if (answer =='n') {
				//System.out.println("\n"+lines);
				System.out.println("");
				for (int z3 =0; z3<(amount); z3++) { //add spaces between each letter and dash
					char h2 = lines.charAt(z3);
					lines2 = h2 + " ";
					System.out.print(lines2);
				}
				System.out.println("");
				hangman(x);
				//System.out.println(x);
			}
			if (right == amount) { //if word guessed before hang man dies
				System.out.println("I beat you this time.");
				x=9; //breaks out of for loop condition
				
			}
			if (x==7) { //not guessed before hang man dies
				System.out.println("You beat me this time.");
		}
		}
		

	}

}
