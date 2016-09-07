/**
   This class simulate a drunkard's walk and save
   its current location.
*/
import java.util.Random;
public class Drunkard {

    private ImPoint currentLoc;
    private int stepSize;
    private Random generator;

	/*
	 *  Random number generator generates a random number between 0 to 3. 
	       0 represents North, 
	       1 represents South,
	       2 represents West,
	       3 represents East.
	 */
    private final int DIRECTION_NUMBER = 4;
    private final int NORTH = 0;
    private final int SOUTH = 1;
    private final int WEST = 2;
    private final int EAST = 3;
    
    /**
       Creates drunkard with given starting location and distance
       to move in a single step.
       Initialize Random number generator for further use.
       @param startLoc starting location of drunkard
       @param theStepSize size of one step in the random walk
    */
    public Drunkard(ImPoint startLoc, int theStepSize) {
    	this.currentLoc = startLoc;
        this.stepSize= theStepSize;
        this.generator = new Random();
      
    }


    /**
       Takes a step of length step-size (see constructor) in one of
       the four compass directions.  Changes the current location of the
       drunkard.
    */
    public void takeStep() {
		int direction = generator.nextInt(DIRECTION_NUMBER);
	    if(direction == NORTH){
		    currentLoc = currentLoc.translate(0,-stepSize);
		}
		else if(direction == SOUTH){
	            currentLoc = currentLoc.translate(0,stepSize);
	        }
		else if(direction == WEST){
		    currentLoc = currentLoc.translate(-stepSize,0);
		}
		else if (direction == EAST){
		    currentLoc = currentLoc.translate(stepSize,0);
        }
    }


    /**
       gets the current location of the drunkard.
       @return an ImPoint object representing drunkard's current location
    */
    public ImPoint getCurrentLoc() {
    	return currentLoc;
    }

}
