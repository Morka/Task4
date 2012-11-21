/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
public class Repeated<P> implements Pict{
	//This class takes an Object<
	//Precondition: It works with most Objects, that have a suitable toString() method which
	//gives back a rectangle
	
	private P[][] repeated;
	private double scaleFactor;
	private double width; //Invariant: width > 0
	private double height; //Invariant: height > 0
	
	public Repeated(P[][] repeated){
		//Precondition: repeated != null
		//Postcondition: all classvariables are set
		this.repeated = repeated;
		this.scaleFactor = 1.0;
	}
	
	public String toString(){
		//Postcondition: returns all elements of repeated filled up with " " if necessary
		String ret = "";
		String temporary = "";
		
		searchForBiggest();
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					temporary = this.scalePict(repeated[i][j]);
					String[] tmp;
					tmp = temporary.split("\n");
					if((int)Math.ceil(tmp[0].length() * scaleFactor) < width){
						for(int k = 0; k < tmp.length; k++){
							for(int h = (int)Math.ceil(tmp[k].length() * scaleFactor); h < width; h++){
								tmp[k] += " ";
							}
							tmp[k] += "\n";
						}
						temporary = "";
						for(int k = 0; k < tmp.length; k++){
							temporary += tmp[k];
						}
						ret += temporary;
					}else{
						ret += temporary;
					}
					if((int)Math.ceil(tmp.length * scaleFactor) < height){
						for(int k = (int)Math.ceil(tmp.length * scaleFactor); k < height; k++){
							for(int h = 0; h < width; h++){
								ret += " ";
							}
							ret += "\n";
						}
					}
				}	
				
			}
			
		}
		return ret;
	}
	
	private String scalePict(Object object){
		//Preconditions: pictObject != null
		//Postconditions: returnes String which contains the scaled Pict
		String ret = "";
		String[] tmp;
		tmp = object.toString().split("\n");
		
		int tmpHeight = tmp.length;
		int tmpWidth = tmp[0].length();
		
		int outputHeight = (int)Math.ceil(tmpHeight * scaleFactor);
		int outputWidth = (int)Math.ceil(tmpWidth * scaleFactor);
		
		for(int i = 0; i < outputHeight; i++){
 			
 			for(int j = 0; j < outputWidth; j++){
 				
 				ret += tmp[i % (int)height].charAt(j % (int)width);
 				
 			}
 			
 			ret += "\n";
 			
 		}
 		return ret;
	}
	
	private void searchForBiggest(){
		//Postcondition: this.width and this.height are set and an array of two
				//		 ints which contains biggestHeight and biggestWidth
				//   	 Unnecessary, but don't have time to change
		String tmp[];
		this.height = 0;
		this.width = 0;
		
		
		for(int i = 0;i	 < repeated.length; i++){
			for(int j = 0; j < repeated[0].length;j++){
				if(repeated[i][j] != null){
					tmp = repeated[i][j].toString().split("\n");
					if(tmp.length > height){
						height = tmp.length;
					}
					if(tmp[0].length() > width){
						width = tmp[0].length();
					}
				}
			}
		}	
	}
	
	public void scale(double factor){
		//Precondition: factor > 0
		//Postcondition: updated scaleFactor
		this.scaleFactor = factor;
	}
	public double getWidth(){
		//Postcondition: returns the current width of repeated

		return width;
	}
	
	public double getHeight(){
		//Postcondition: returns the current height of the repeated

		return height;
	}
}
