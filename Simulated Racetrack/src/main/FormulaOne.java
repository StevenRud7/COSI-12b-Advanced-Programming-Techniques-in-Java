//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the FormulaOne class that extends from Car and adds base values and as well the bounds for speed and strength. I also override the formulaone specific toString method


package main;

public class FormulaOne extends Car {
	public int unit,lap,speed,strength,ispeed,pitcount; //initiate all variables
	
	/**
	 * The two constructors for FormulaOne the first creating the base values if 0 is inputed and second if values are inputed and 
	 * we would then ensure they are within the bounds.
	 */

	public FormulaOne() {
		super.ispeed = 50; //base values
		super.speed = 50;
		super.strength = 4;
		super.ID=2; //unique ID for formula one
		super.ispeed=super.speed;

	}
	
	public FormulaOne(int speed, int strength) {
		super(speed,strength); //creates the inputed values
		super.strength=strength;
		super.ID=2;
		if (speed>70) { //check if speed or strength inputed goes over the boundaries it resets back to the upper/lower bound 
			super.speed=70;
		}
		if (speed<30) {
			super.speed=30;
		}
		if (strength>5) {
			super.strength=5;
		}
		if (strength<3) {
			super.strength=3;
		}
		super.ispeed=super.speed; //sets up the initial speed
	}
	@Override
	public String toString() { //string return overridden from car to return the String specific for a FormulaOne
		return "FormulaOne" + super.ispeed + "/"+super.strength; 
	}
	
}
