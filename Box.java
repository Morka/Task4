/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
import java.lang.Math;
 
public class Box implements Pict {
	// instances represent 2-dimensional pictures
 	// consisting of printable characters
 	
 	private double height; 		//number of chars the height of the box, > 0
 	private double width; 		//number of chars building the width of the box, > 0
 	//proportion betwenn height and width stays always the same
 	private final char content; 	//content filled by specific char, not modifiable after initialisation in Constructor
 	private final char frame; 	//frame build by specific char, not modifiable after initialisation in Constructor

 	
 	public Box(double width, double height, char content, char frame) {
 		this.content = content; //not modifiable
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
 				if((i == 0) || (j == 0) || (i == (roundwidth-1)) || (j == (roundheight-1))) {	
 					ret += frame;
 					
 					if(i == (roundwidth-1))
 						ret += "\n";
 				}
 				else
 					ret += content;
 			}
 		}
 		
 		return ret;
 	}
 	
 	/**
 	* returns the width
	*
	* @return double of width
	*/
 	double getWidth() {
 		return width;
 	}
 	
 	/**
 	* returns the height
	*
	* @return double of height
	*/
 	double getHeight() {
 		return height;
 	}
}
