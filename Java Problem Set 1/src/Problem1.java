//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #1
//Description: Problem 1, Performing different calculations depending on whether next value is odd or even until we reach 1. If even half it, if odd triple it and then add 1

import java.util.*; // imports for the scanning and rest of operations

public class Problem1 {

	public static void main(String[] args) {
		int Count = 1;  // Creating count variable to find total actions performed (start at 1 to include the final operation)
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("Initial value is: "); //prompt
		int number = console.nextInt ();
		if (number>=1) {  // ensure positive integer is inputted
			while (number!=2) { //to stop before pre-last operation
				if (number%2==0) { // check if number is even
					number = number /2; // half it then print the output and add to the total operations performed
					System.out.println("Next value is: " + number);
					Count=Count+1;
				}
				if (number%2!=0) {  //check if number is odd
					number = ((number*3)+1); // triple it and add 1 then print the output and add to the total operations performed
					System.out.println("Next value is: " + number);
					Count=Count+1;
				}
			}
			System.out.println("Final Value 1, number of operations peformed " + Count); //Print final value and amount of operations
			
		}else {
			System.out.println("Error"); //in case a non valid number is inputted 
		}
		

	}

}
