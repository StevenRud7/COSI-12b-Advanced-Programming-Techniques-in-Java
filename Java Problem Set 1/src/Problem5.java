//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #1
//Description: Problem 5, Outputs an given integer with each digit in a new line in order. Take in an integer, then swap it so it would later output in the right order. Then get each individual digit and output it later.

import java.util.Scanner;  // imports for the scanning and rest of operations

public class Problem5 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("Input a Positive Integer: "); //prompt
		int posi = console.nextInt ();
		int swap = 0; //create an inverted version of the inputted integer 
		for (int sdigit=posi%10; posi>0; sdigit=posi%10) { //invert the number 
			swap = swap*10+sdigit;
			posi = posi/10;
		}
		//System.out.println(swap);
		for (int digit = swap%10; swap>0; digit=swap%10) { //keep dividing by 10 to output the digits from last to first (works since it is inverted now)
			swap = swap/10;
			System.out.println(digit);
		}
		if (posi<0) { //in case a negative integer was inputted 
			System.out.println("Invalid number, Input a positve integer");
		}
		
	}

}
