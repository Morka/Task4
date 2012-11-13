/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class FreeBox implements Pict {
	
	 private double height, width; 
	 private double scaleFactor;
	 private String[] text; //ODER CHAR[][]
	 
 	 public FreeBox(String content) {
 	 	 //height = number of chars the height of the box, > 0
 	 	 //width = number of chars building the width of the box, > 0
 	 	 //proportion betwenn height and width stays always the same
 	 	 //content = content filled by specific char, not modifiable after initialisation in Constructor
 	 	 //frame = frame build by specific char, not modifiable after initialisation in Constructor
 	 	 //this.height = height;
 	 	 //this.width = width;
 	 	 //this.text = content;
 	 	 this.text = content.split("\n");
 	 	 this.height = this.text.length;
 	 	 this.width = this.text[0].length();
 	 	 this.scaleFactor = 1.0;
 	 	 //System.out.println(this.text[0].charAt(1));
 	 	 //System.out.println(this.height);
 	 	 //System.out.println(this.width);
 	 }
 	 
 	 /**
 	  * calculates the ratio of the dimension of the box
 	  * 
 	  * @return ratio of width and height
 	  */
 	 public double getRatio() {
 	 	 return (this.width)/(this.height);
 	 }

	/**
	 * Sets the factor of which the box get resized in case of calling toString();
	 * 
	 * @param factor the factor the box dimensions will be resized
	 */
	public void scale(double factor) {

		this.scaleFactor = factor;
		
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	/**
	 * returns a read- and printable String of the box and repeats the box if it is smaller than its actual size
	 * 
	 * @return printable String representation of the box
	 */
	public String toString() {
 		String ret = "";
 		int outputHeight = (int)Math.ceil(height * scaleFactor); 
 		int outputWidth = (int)Math.ceil(width * scaleFactor);
 		
 		for(int i = 0; i < outputHeight; i++){
 			
 			for(int j = 0; j < outputWidth; j++){

 				ret += this.text[i % (int)this.height].charAt(j % (int)this.width);//0-offset!!! egal geht bei 0 los - charAt???
 				
 			}
 			
 			ret += "\n";
 			
 		}
 		return ret;
 	}
}