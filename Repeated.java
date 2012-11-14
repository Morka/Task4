import java.lang.Math;

public class Repeated implements Pict{
	private Pict[][] repeated;
	private double scaleFactor;
	private double width; //Invariant: width > 0
	private double height; //Invariant: height > 0
	
	
	public Repeated(Pict[][] repeated){
		//Precondition: repeated != null
		//Postcondition: all classvariables are set
		this.repeated = new Pict[repeated.length][repeated[0].length];
		this.repeated = repeated;
		this.scaleFactor = 1.0;
		this.searchForBiggest();
	}
	
	public String toString(){
		//Postcondition: returns all elements of repeated filled up with " " if necessary

		String ret = "";
		String temporary = "";
		
		int[] biggest = new int[2];
		biggest = searchForBiggest();
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					temporary = this.scalePict(repeated[i][j]);
					if((int)Math.ceil(repeated[i][j].getWidth() * scaleFactor) < biggest[0]){
						String[] tmp;
						tmp = temporary.split("\n");
						for(int k = 0; k < tmp.length; k++){
							for(int h = (int)Math.ceil(repeated[i][j].getWidth() * scaleFactor); h < biggest[0]; h++){
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
					if((int)Math.ceil(repeated[i][j].getHeight() * scaleFactor) < biggest[1]){
						for(int k = (int)Math.ceil(repeated[i][j].getHeight() * scaleFactor); k < (biggest[1]); k++){
							for(int h = 0; h < biggest[0]; h++){
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
	
	public double getWidth(){
		//Postcondition: returns the current width of repeated
		return width;
	}
	
	public double getHeight(){
		//Postcondition: returns the current height of the repeated

		int factor = 0;
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					factor++;
				}
			}
		}
		return height * factor;
	}
	
	private String scalePict(Pict pictObject){
		//Preconditions: pictObject != null
		//Postconditions: returnes String which contains the scaled Pict
		String ret = "";
		String[] tmp;
		tmp = pictObject.toString().split("\n");
		
		int height = tmp.length;
		int width = tmp[0].length();

		
		int outputHeight = (int)Math.ceil(height * scaleFactor);
		int outputWidth = (int)Math.ceil(width * scaleFactor);
		
		for(int i = 0; i < outputHeight; i++){
 			
 			for(int j = 0; j < outputWidth; j++){

 				ret += tmp[i % (int)height].charAt(j % (int)width);
 				
 			}
 			
 			ret += "\n";
 			
 		}
 		return ret;
	}
	
	public void scale(double factor){
		//Precondition: factor > 0
		//Postcondition: updated scaleFactor
		this.scaleFactor = factor;
	}
	
	private int[] searchForBiggest(){
		//Postcondition: this.width and this.height are set and an array of two
				//		 ints which contains biggestHeight and biggestWidth
				//   	 Unnecessary, but don't have time to change
		int biggestHeight = 0;
		int biggestWidth = 0;
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					if((int)Math.ceil(repeated[i][j].getWidth()) > biggestWidth){
						width = repeated[i][j].getWidth();
						biggestWidth = (int)Math.ceil(repeated[i][j].getWidth());
					}
					if((int)Math.ceil(repeated[i][j].getHeight()) > biggestHeight){
						height = repeated[i][j].getHeight();
						biggestHeight = (int)Math.ceil(repeated[i][j].getHeight());
					}
				}
			}
		}
		int[] ret = new int[2];
		
		ret[1] = (int)Math.ceil(biggestHeight * scaleFactor);
		ret[0] = (int)Math.ceil(biggestWidth * scaleFactor);
		
		return ret;
	}
}
