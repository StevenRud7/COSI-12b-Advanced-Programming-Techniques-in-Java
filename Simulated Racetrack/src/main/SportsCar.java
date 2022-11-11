//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the SportsCar class that extends from Car and adds base values and as well the bounds for speed and strength. I also override the sportscar specific toString method

package main;

public class SportsCar extends Car {
	public int unit,lap,speed,strength,ispeed,pitcount; //initiate all variables
	
	/**
	 * The two constructors for sports car the first creating the base values if 0 is inputed and second if values are inputed and 
	 * we would then ensure they are within the bounds.
	 */
	
	public SportsCar() {
		super.ispeed = 30; //base values
		super.speed = 30;
		super.strength = 2;
		super.ID=3; //unique ID for sports car
		super.ispeed=super.speed; //sets value for initial speed

	}

	public SportsCar(int speed, int strength) {
		super(speed,strength); //gets speed and strength from inputed values
		super.strength=strength;
		super.ID=3;
		if (speed>45) { //check if speed or strength inputed goes over the boundaries it resets back to the upper/lower bound 
			super.speed=45;
		}
		if (speed<20) {
			super.speed=20;
		}
		if (strength>3) {
			super.strength=3;
		}
		if (strength<1) {
			super.strength=1;
		}
		super.ispeed=super.speed;
	}
	@Override
	public String toString() { //string return overridden from car to return String specific for SportsCar
		return "SportsCar" + super.ispeed + "/"+super.strength; 
	}
	
	
}
