//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #1
//Description: Problem 3, Performs a Caesar cipher on a message. Take in message, take in key (how many letters to move each letter by), and then print the final message

import java.util.Scanner;  // imports for the scanning and rest of operations

public class Problem3 {

	public static void main(String[] args) {
		String alpha = "abcdefghijklmnopqrstuvwxyz "; //alphabet string plus an empty space for the spaces
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("Your message? "); //prompt for message sentence
		String mess = console.nextLine ();
		System.out.print("Encoding key? "); //prompt for key
		int key = console.nextInt ();
		int let2 = 0; // used to look through the alphabet string
		String code = ""; //code string
		mess = mess.toLowerCase(); //lowercase message to match alphabet string
		for (int let1=0; (let1)<mess.length(); let2+=1) { // the loop to add the proper letter to the code
			if (mess.charAt(let1)==alpha.charAt(let2) && (let2+key)<=25 && let2!=26) { //calculation if code key is less than  26 and not the space
				code += alpha.charAt(let2+key);
				let1 += 1; //begin checking next letter in message
				let2 = -1; //reset alphabet scan
			}
			if ( let2+key>25 && key<=26 && mess.charAt(let1)==alpha.charAt(let2) && let2!=26) { //calculation for the having to loop back
				code +=alpha.charAt(let2+key-26); 
				let1 += 1;
				let2 = -1;
			}
			if (key>26 && mess.charAt(let1)==alpha.charAt(let2) && let2!=26) { //calculation for when having a large key
				code +=alpha.charAt((let2+key)%26);
				let1 += 1;
				let2 = -1;
			}
			if (let2==26 && mess.charAt(let1)==alpha.charAt(let2)) { //adding a space in code message for where there is a space in the message.
				code+=" ";
				let1 += 1;
				let2 = -1;
			}
			
		}
		System.out.println(code.toUpperCase()); //output code in capital letters

	}

}
