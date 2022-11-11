//Steven Rud
//COSI 12b, Fall 2021
//Programming Assignment #1
//Description: Problem 2, Translating a normal integer into a Roman numeral. Go through each range of values where a numeral is used and add the numerals if required.

import java.util.Scanner;  // imports for the scanning and rest of operations

public class Problem2 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); //beginning command for scanning
		System.out.print("Input a number not greater than 4999:  "); //prompt
		int num = console.nextInt (); 
		String rom = " "; //create roman numeral string
		int original = num; //store the original number 
		for (num=num ;num>=1000; num=num-1000) { //situation for when number greater than 1000
			rom = rom + "M";
		}
		if (num>=900) { //add CM if in the 900s and remove amount from the number
			rom = rom +"CM";
			num = num-900;
		}
		if (num>=500) { //add D if in the 500s and remove amount from the number
			rom = rom +"D";
			num = num - 500;
		}
		if (num>=400) { //add CD if in the 400s and remove amount from the number
			rom = rom +"CD";
			num = num-400;
		}
		for (rom=rom ;num>=100; num=num-100) { //add C's for the 100s 
			rom = rom + "C";
		}
		if (num>=90) { //add XC if in the 90s and remove amount from the number
			rom = rom +"XC";
			num = num-90;
		}
		if (num>=50) { //add L if in the 50s and remove amount from the number
			rom = rom +"L";
			num = num -50;
		}
		if (num>=40) { //add XL if in the 40s and remove amount from the number
			rom = rom +"XL";
			num = num-40;
		}
		for (rom=rom ;num>=10; num=num-10) { //add X's for the 10s
			rom = rom + "X";
		}
		if (num>=9) { //add IX if in the 9s and remove amount from the number
			rom = rom +"IX";
			num = num-9;
		}
		if (num>=5) { //add V if in the 5s and remove amount from the number
			rom = rom +"V";
			num = num -5;
		}
		if (num>=4) { //add IV if in the 4s and remove amount from the number
			rom = rom +"IV";
			num = num-4;
		}
		for (rom=rom ;num>=1; num=num-1) { //add I's for the 1s
			rom = rom + "I";
		}
		if (original>4999 || original<1) { // incase the inputted value is invalid output an error
			System.out.println("Number invalid, try again");
			rom = "";
		}else { //output final answer
			System.out.println(original + " in Roman numerals is: " + rom);
		}
		

	}

}
