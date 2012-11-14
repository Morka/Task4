/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class FreeBox implements Pict {
	
	 private double height, width; //Invariant: height and width > 0
	 private double scaleFactor;
	 private String[] text;
	 
 	 public FreeBox(String content) {
 		 //Precondition: content is a rectangular shaped text
 		 //Postcondition: the height and width are caluclated, the scaleFactor's default value is set and the text is saved
 		 //in a string array
 	 	 this.text = content.split("\n");
 	 	 this.height = this.text.length;
 	 	 this.width = this.text[0].length();
 	 	 this.scaleFactor = 1.0;
 	 }
 	 
 	 /**
 	  * calculates the ratio of the dimension of the box
 	  * 
 	  * @return ratio of width and height
 	  */
 	 public double getRatio() {
 		 //Postcondition: calculates and returns the ratio of width and height
 	 	 return (this.width)/(this.height);
 	 }
 	 
	/**
	 * Sets the factor of which the box get resized in case of calling toString();
	 * 
	 * @param factor the factor the box dimensions will be resized
	 */
	public void scale(double factor) {
		//Precondition: 0.1 <= factor <= 10.0
		//Postcondition: calculates the new size of the box and stores scaleFactor
		this.scaleFactor *= factor;
		
	}
	
	public double getWidth(){
		//Postcondition: returns the width of the Box
		return width * scaleFactor;
	}
	
	public double getHeight(){
		//Postcondition: returns the height of the Box
		return height * scaleFactor;
	}
	
	/**
	 * returns a read- and printable String of the box and repeats the box if it is smaller than its actual size
	 * 
	 * @return printable String representation of the box
	 */
	public String toString() {
		//Postcondition: calculates the size of the box, creates and returns a rectangular String representation of the Box
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