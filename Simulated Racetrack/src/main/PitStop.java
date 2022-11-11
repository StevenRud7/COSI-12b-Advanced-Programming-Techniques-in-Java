//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the pitstop class that I have add a car to a pitstop, hold it there for two ticks and then release it and fix its speed


package main;

public class PitStop {
	
	RaceTrack racetrack;
	
	/**
	 * go through each and then below check all possible scenarios where car could've entered a pitstop
	 */
	public void enterPitStop(Car[] cars) { //check if last 2 digits in location is 75+ or if the damaged car passed a pitstop than keep damaged car in pitstop for 2 ticks and edit speed value
		if (cars.length>0) { //ensure there are cars
			for (int i =0; i<cars.length; i++) { 
				if (cars[i].unitvalue()>=75 || cars[i].unitvalue()==0 || (cars[i].unitvalue()<(cars[i].getLocation()-cars[i].ispeed)%100 && cars[i].pitcount<=3&&0<=cars[i].pitcount && cars[i].unitvalue()-cars[i].speed!=0)) {
					if (cars[i].speedvalue()<cars[i].ispeedvalue()) { //check if damaged
						//System.out.println(cars[i]);
						cars[i].speed=0; //use so car wouldn't move 
						cars[i].pitcount++; //add to pitstop count
						
						if (cars[i].pitcount==3) { //once it held for two ticks release the care and push it back to the pitstop and fix speed
							//cars[i].unit=cars[i].iunit;
							if (cars[i].unitvalue()>=75) {
								cars[i].unit=cars[i].unit-(cars[i].unit%100)+75;
							}
							if (cars[i].unitvalue()<75) {
								cars[i].unit = ((cars[i].unit-74)-((cars[i].unit-74)%100) + 75);
							}
							cars[i].speed = cars[i].ispeed; //fix speed
						}
						
					}			
					
				}
		}

		}
		
		
	}
	
}
