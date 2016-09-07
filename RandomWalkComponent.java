import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;


/**
 * This class extends JComponent. It overrides paintComponent method
 * to draw drunkard's random walk. 
 */
public class RandomWalkComponent extends JComponent{

    private Drunkard drunkard;
    private int steps;

    /**
       Creates random walk component with given drunkard and number of steps in this random walk.
       @param d the drunkard taking the random walk
       @param s number of steps in the random walk
    */
    public RandomWalkComponent(Drunkard drunkard, int steps){
    	this.drunkard = drunkard;
    	this.steps = steps;
    }


    /**
       Override paintComponent to draw the random walk.
       Use a Drunkard object to keep track of steps
    */
    public void paintComponent(Graphics g){
       Graphics2D g2 = (Graphics2D) g;
       //Create a loop drawing the random walk step by step.
       int step = 0;
       while(step < steps){
		   //Get the starting coordinate.
		   ImPoint currentLoc = drunkard.getCurrentLoc();
		   int startX = currentLoc.getX();
		   int startY = currentLoc.getY();
	
		   drunkard.takeStep();
		   
		   //Get the ending coordinate after taking a step
		   currentLoc = drunkard.getCurrentLoc();
		   int endX = currentLoc.getX();
		   int endY = currentLoc.getY();
	
		   //Draw a line between the starting coordinate and the ending coordinate.
		   g2.drawLine(startX, startY, endX, endY);
	
		   step++;
       }
    }
}
