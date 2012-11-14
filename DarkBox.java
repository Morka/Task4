/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
import java.lang.Math;
 
public class DarkBox implements Pict {
	// instances represent 2-dimensional pictures
 	
 	private double height; 		//Invariant: height > 0
 	private double width; 		//Invariant: width > 0
 	//Invariant: proportion of the DarkBox stays always the same
 	private char frame;

 	
 	public DarkBox(double width, double height, char frame) {
 		//Precondition: width and height > 0, char != null
 		//Postcondition: all classvariables are set
 		this.frame = frame;
 		this.width = width;
 		this.height = height;
 	}
 	
 	
 	
 	/**
 	* resize the picture 
	*	
	* @param factor factor to resize current length and height 
	*/
 	public void scale(double factor) {
 		//Precondition: 0.1 <= factor <= 10.00
 		//Postcondition: calculates and stores the new dimensions of the DarkBox
 		height *= factor;
 		width *= factor;
 	}
 	 
 	
 	/**
 	* returns the picture as String
	*
	* @return String of picture
	*/
 	public String toString() {
 		//Postcondition: returns a quadratic string representation of the DarkBox
 		String ret = "";
 		int roundheight = (int)Math.ceil(height); 
 		int roundwidth = (int)Math.ceil(width);
 		
 		for(int j = 0; j < roundheight; j++) {
 			for(int i=0; i < roundwidth; i++) {

 				ret += frame;
 				
 				if(i == (roundwidth-1))
						ret += "\n";
 			}
 		}
 		
 		return ret;
 	}
 	
 	/**
 	* returns the width
	*
	* @return double of width
	*/
 	public double getWidth() {
 		//Postcondition: returns the current width of the DarkBox
 		return width;
 	}
 	
 	/**
 	* returns the height
	*
	* @return double of height
	*/
 	public double getHeight() {
 		//Precondition: returns the current height of the DarkBox
 		return height;
 	}
 	
 	/**
 	 * sets the border char
 	 * 
 	 * @param the new char for the frame
 	 */
 	public void setFrame(char newFrame){
 		//Precondition: newFrame != null
 		//Postcondition: this.frame is set to the new frame char newFrame
 		
 		this.frame = newFrame;
 		
 	}
}
