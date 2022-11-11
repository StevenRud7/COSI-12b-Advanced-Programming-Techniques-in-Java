//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: This is the finishline class, I removed the enterfinishline method and incorporated its functionality into the RaceTrack class. I have the finished method to remove a car from the race by editing its values once it crosses the finish line.


package main;

public class FinishLine {
	
	int fincount=0;
	
	/**
	 * I removed enterfinishline for simplicity and added the use to racetrack and here I just check if a car passes the finish line and then I 
	 * remove it from the race by editing its values
	 */
	
	public boolean finished(Car[] cars) {
		// each time a car passes 1000 add a count then if the count is equal to length of cars then return true;
		if (cars.length>0) {
			for (int z=0; z<cars.length; z++)  { //check if a cars location is above 1000 then add to a count and stop race when count equals total cars
				if (cars[z].unit>=1000 && cars[z].pitcount==0) {
					fincount++;
					cars[z].speed=0; //stop car from moving and push it away from the race
					cars[z].unit=-1;
					cars[z].lap=-1000;
				}
			}
		}
		

		if (fincount==cars.length) {
			return true; //once true is when all cars passed the finish line so the race stops
		}
		else {
			return false;
		}
	}
}

