/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
import java.lang.Math;
 
public class DarkBox implements Pict {
	// instances represent 2-dimensional pictures
 	// consisting of printable characters
 	
 	private double height; 		//number of chars the height of the box, > 0
 	private double width; 		//number of chars building the width of the box, > 0
 	//proportion betwenn height and width stays always the same
 	private char frame; 	//frame build by specific char, not modifiable after initialisation in Constructor

 	
 	public DarkBox(double width, double height, char frame) {
 		this.frame = frame; 	//not modifiable
 		this.width = width;
 		this.height = height;
 	}
 	
 	
 	/**
 	* resize the picture 
 	* 0.1 <= factor <= 10.0
	*	
	* @param factor factor to resize current length and height 
	*/
 	public void scale(double factor) {
 		height *= factor;
 		width *= factor;
 	}
 	 
 	
 	/**
 	* returns the picture as String
	*
	* @return String of picture
	*/
 	public String toString() {
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
 		return width;
 	}
 	
 	/**
 	* returns the height
	*
	* @return double of height
	*/
 	public double getHeight() {
 		return height;
 	}
 	
 	/**
 	 * sets the border char
 	 * 
 	 * @param the new char for the frame
 	 */
 	public void setFrame(char newFrame){
 		
 		this.frame = newFrame;
 		
 	}
}
