//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #1
//Description: Problem 4, Translates a name into pig latin. Take in a first and last name and then move all letters into right places and output final pig latin name.

import java.util.Scanner;  // imports for the scanning and rest of operations

public class Problem4 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("First name? "); //prompt
		String first = console.next (); //first name string
		System.out.print("Last name? "); //prompt
		String last = console.next (); // last name string
		first = first.toLowerCase(); //lower case each to later only capital the first letter later
		last = last.toLowerCase();
		first = first.substring(1)+first.charAt(0)+"ay"; // remove the first letter from front and move to end and add "ay"
		last = last.substring(1)+last.charAt(0)+"ay";
		String cap1 = first.substring(0, 1).toUpperCase(); //create a string for the new first letter and capitalize it
		String cap2 = last.substring(0, 1).toUpperCase();
		System.out.print(cap1+first.substring(1) + " "); //print out the final name in pig latin 
		System.out.print(cap2+last.substring(1));

	}

}
