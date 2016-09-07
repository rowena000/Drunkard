import javax.swing.JFrame;
import java.util.Scanner;

/**
 * This class contents the main routine. It takes user's input,
 * simulated drunkard's walk randomly based on that, and draw 
 * the walk in GUI.
 *
 */
public class RandomWalkViewer{
    
	private static final int WINDOW_SIZE = 400;
	
	public static void main(String[] args) {
	    //prompt user for input
		System.out.print("Enter Number of steps: ");
		Scanner s = new Scanner(System.in);
		int steps = s.nextInt();
		while(steps<=0){
		    System.out.println("ERROR: Number of steps must be greater than 0.");
		    System.out.print("Enter Number of steps: ");
		    steps = s.nextInt();
		}
		s.close(); 
		
		// Create JFrame, initiate RandomWalkComponent and add to JFrame
		JFrame frame = new JFrame();
		frame.setSize(WINDOW_SIZE, WINDOW_SIZE);
		frame.setTitle("RandomWalk"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int startLocXY = WINDOW_SIZE/2;
	    ImPoint startLoc = new ImPoint(startLocXY, startLocXY);
		Drunkard drunkard = new Drunkard(startLoc,5);
	
	    RandomWalkComponent component = new RandomWalkComponent(drunkard,steps); 
		frame.add(component);
	
		frame.setVisible(true); 
    }
}
