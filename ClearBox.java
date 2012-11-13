/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class ClearBox extends Box implements Pict {
 	 public ClearBox(double width, double height, char content) {
 	 	 //height = number of chars the height of the box, > 0
 	 	 //width = number of chars building the width of the box, > 0
 	 	 //proportion betwenn height and width stays always the same
 	 	 //content = content filled by specific char, not modifiable after initialisation in Constructor
 	 	 //frame = frame build by specific char, not modifiable after initialisation in Constructor
 	 	 super(width, height, content, '*');
 	 }
 	 
 	 public double getRatio() {
 	 	 return (getWidth())/(getHeight());
 	 }
}