import java.lang.Math;

/**
 * This class tests Drunkard class independently from its use in the random walk program.
 *
 */
public class DrunkardTester{

    public static void main(String[] args) {
        
    	//Using different start location, stepSize and stepNumbers to test drunkard class
    	ImPoint startLoc = new ImPoint(3,5);
        int stepSize = 2;
        int stepNumber = 5;
        testDrunkard(startLoc, stepSize, stepNumber);
        
        startLoc = new ImPoint(10, 20);
        stepSize = 5;
        stepNumber = 10;
        testDrunkard(startLoc, stepSize, stepNumber);
        
        startLoc = new ImPoint(10, 20); 
        stepSize = 2;
        stepNumber = 10;
        testDrunkard(startLoc, stepSize, stepNumber);
    }
    
	/**
	 * This method perform testing on Drunkard's constructor and all of its method
	 * @param startLoc the start location of drunkard
	 * @param stepSize the stepsize of drunkard
	 * @param stepNumber the number of steps the drunkard is going to take
	 */
    private static void testDrunkard(ImPoint startLoc, int stepSize, int stepNumber) {
        Drunkard d = new Drunkard(startLoc, stepSize);

        ImPoint currentLoc = d.getCurrentLoc();
        System.out.println("Drunkard starts at " + startLoc.toString() + "; Step size is " + stepSize);
        System.out.println("get starting loc, expected " + startLoc.toString() + ". Actual: " + currentLoc.toString());
        System.out.println("The drunkard is going to take " + stepNumber + " steps.");
        //Test the method of takeStep by checking whether d2 appears in the right coordinate after taking steps.
        int step = 0;
        while(step < stepNumber){
            d.takeStep();
            currentLoc = d.getCurrentLoc(); /
            System.out.print("Took step to " + currentLoc.toString());
            int distance = Math.abs(currentLoc.getX() - startLoc.getX())+Math.abs(currentLoc.getY()- startLoc.getY());
            if (distance % stepSize!= 0){
                System.out.println(" FAILED: not a valid step.");
            }else{
                System.out.println(" SUCCEED.");
            }
            step++;
        }
    }
}

