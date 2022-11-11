//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the RaceCar class that extends from Car and adds base values and as well the bounds for speed and strength. I also override the racecar specific toString method


package main;

public class RaceCar extends Car{
	
	public int unit,lap,speed,strength,ispeed,pitcount; //each variable initiated

	/**
	 * The two constructors for race car the first creating the base values if 0 is inputed and second if values are inputed and 
	 * we would then ensure they are within the bounds.
	 */
	
	public RaceCar() {
		super.ispeed = 40; //base values for each variable
		super.speed = 40;
		super.strength = 3;
		super.ispeed=super.speed; //sets up initial speed
		super.ID=1; //unique ID for racecar
//		System.out.println(speed);
//		System.out.println(strength);

	}
	
	public RaceCar(int speed, int strength) { //maybe something with super needs to be used?
		super(speed,strength); //creates the inputed values
		super.strength=strength;
		super.ID=1;
		if (speed>55) { //check if speed or strength inputed goes over the boundaries it resets back to the upper/lower bound 
			super.speed=55;
		}
		if (speed<30) {
			super.speed=30;
		}
		if (strength>4) {
			super.strength=4;
		}
		if (strength<2) {
			super.strength=2;
		}
		super.ispeed=super.speed;
		//System.out.println(speed);

	}
	@Override
	public String toString() { //returns string overridden from the car class to specifically return for racecar
		return "RaceCar" + super.ispeed + "/"+super.strength; 
	}
	
}
