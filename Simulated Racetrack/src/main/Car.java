//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the abstract car class that has all the functions I would need for each car and would later use in pitstop, finishline, and racetrack

package main;

public abstract class Car {
	public int unit,lap,speed,strength,ispeed,pitcount,ID; //each variable initiated 
	
	/**
	 * The two general constructors for car creating all base variables 
	 */
	
	public Car() {
		unit = 0;
		lap = 1;
		pitcount=0;
	}
	
	public Car(int speed,int strength) {
		this.speed=speed;
		this.strength=strength;
		this.ispeed=this.speed; //creating initial speed too to have it is as the starting speed to be used in other methods 
		
	}
	public double getLocation() { //returns location	
		return (lap-1)*100+unit;
	}
	public double move() { //move the car along adding speed to the unit
		unit+=speed;
		return unit;
	}
	
	public abstract String toString(); //returns string overridden in each car later as each car has a unique toString to return

	
	/**
	 * Return all of the base values  
	 */
	
	public int speedvalue() {//return specific values for checking later
		return speed;
	}
	public int ispeedvalue() {
		return ispeed;
	}
	public int unitvalue() { //returns last two numbers in location value
		return unit%100;
	}
	public int carID() { //A unique identifier for each car to check how many of each car there is to be able to correctly calculate score
		return ID;
	}

}
