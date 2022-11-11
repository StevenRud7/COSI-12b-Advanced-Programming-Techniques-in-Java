//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 11, Fall 2021
//Programming Assignment #6
//Description: The RaceTrack class where I utilize all other classes and set up the race. For example, I add all the cars to the race and in each tick this class moves them, checks if they collide, enter pitstop, and finish line.

package main;

public class RaceTrack {

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	
	public int unit,lap,speed,strength,ispeed; //initiate all variables
	
	Car[] cars; //initiate every class/variable
	FinishLine finline;
	PitStop pitstop;
	int fincount=0;
	int place = 1;
	int count = 0;
	int rccount = 0;
	int f1count = 0;
	int sccount = 0;

	
	public RaceTrack() { //set up each method and variable
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
		this.pitstop = new PitStop();
		this.finline = new FinishLine();
	}
	
	public void setCars(Car[] cars) { //assign the cars to array and tally up each of the car amounts in the race 
		this.cars = cars;
		for (int i =0; i<cars.length;i++) {
			if (cars[i].ID==1) {
				rccount++;
			}
		}
		for (int i =0; i<cars.length;i++) {
			if (cars[i].ID==2) {
				f1count++;
			}
		}
		for (int i =0; i<cars.length;i++) {
			if (cars[i].ID==3) {
				sccount++;
			}
		}
		//System.out.println(this.rc.length);
	}
	
	/**
	 * print tick, move the cars, check if they enter pit stop (if yes then print it) then check for collisions
	 */
	
	public void tick() { //go through each method for each tick 
		logger.logNewTick();
		count++; //tick counter
		if (cars.length>0) {
			for (int i =0; i<cars.length; i++) { //move each car along
				cars[i].move();
				//System.out.println(cars[i].unit + " " + String.valueOf(i));  //used for testing code
				//System.out.println(cars[i].speed + "<- speed ");
				//System.out.println(fincount + "<- fincount");
			}
		}
		pitstop.enterPitStop(cars); //check if pitstop would be entered and print the entering and exiting of the pitstop.
		for (int i =0; i<cars.length;i++) {
			if (cars[i].pitcount==1) {
				logger.logEnterPit(cars[i]);
			}
			if (cars[i].pitcount==3) { 
				logger.logExitPit(cars[i]);
				cars[i].pitcount=0;
				cars[i].move(); //to move the car right away after leaving pitstop
			}
		}
		checkCollision(); //check collision
		

	}
	
	/**
	 * nested for loop to go through each car and check if two different cars would meet the collision requirements and if so then 
	 * damage them and edit their speed.
	 */
	
	public void checkCollision() {
		for (int j = 0; j<(cars.length); j++) {
				for (int i =0; i<(cars.length); i++) { 
						if (cars[i].unitvalue()==cars[j].unitvalue()&& cars[i].unit<1000&& cars[i].unit>1 && i!=j && cars[i].pitcount==0&&cars[j].pitcount==0 && cars[i].unitvalue()!=75&& cars[i].unitvalue()!=75) { // if two cars cars are at the same place and not past the finish line then collide 
							if (cars[i].speed==cars[i].ispeed) { //check if not already damaged
								logger.logDamaged(cars[i]); //print damage
								cars[i].speed= cars[i].ispeed -(cars[i].strength*5); //edit speed
							}
							if (cars[j].speed==cars[j].ispeed) {
								logger.logDamaged(cars[j]);
								cars[j].speed= cars[j].ispeed -(cars[j].strength*5);
							}
							
							
						}
		}
		}				
	}
	
	/**
	 * keep running until all cars cross finish line and when one crosses finish line print that it has finished and remove from race
	 * Once all finish then print the final count
	 */
	
	public void run() {
		while (finline.finished(cars)==false) { //while the race isn't finished keep running tick
			tick();
			if (cars.length>0) {
				for (int q = 0; q<cars.length; q++) {
					if (cars[q].unit>=1000&&cars[q].pitcount==0) {
						logger.logFinish(cars[q],place);
						cars[q].speed=0; //remove that car from the race
						//rc[q].unit = 0;
						cars[q].lap = 0;
						place++;
					}
				}
			}

			
		}

		if (finline.finished(cars)) {
			//System.out.println(rccount);
			logger.logScore(calculatorScore(count)); //then just give count
		}
		
		
		

	}
	
	public int calculatorScore(int ticks) { //count calculation for final count
		return (1000 - (20*ticks) +(150*rccount)+(100*f1count)+(200*sccount));
		
		
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}

}
