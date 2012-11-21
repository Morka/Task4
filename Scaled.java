import java.lang.Math;

public class Scaled<P extends Pict> implements Pict{
	private P[][] repeated;
	private double scaleFactor;
	private double width; //Invariant: width > 0
	private double height; //Invariant: height > 0
	
	
	public Scaled(P[][] repeated){
		//Precondition: repeated != null
		//Postcondition: all classvariables are set
		this.repeated = repeated;
		this.scaleFactor = 1.0;
		searchForBiggest();
	}
	
	public String toString(){
		//Postcondition: returns all elements of repeated filled up with " " if necessary
		String ret = "";
		
		int[] biggest = new int[2];
		biggest = searchForBiggest();
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					repeated[i][j].scale(scaleFactor);
					if((int)Math.ceil(repeated[i][j].getWidth()) < biggest[0]){
						String[] tmp;
						tmp = repeated[i][j].toString().split("\n");
						for(int k = 0; k < tmp.length; k++){
							for(int h = (int)Math.ceil(repeated[i][j].getWidth()); h < biggest[0]; h++){
								tmp[k] += " ";
							}
							tmp[k] += "\n";
						}
						for(int k = 0; k < tmp.length; k++){
							ret += tmp[k];
						}
					}else{
						ret += repeated[i][j].toString();
					}
					if((int)Math.ceil(repeated[i][j].getHeight()) < biggest[1]){
						for(int k = (int)Math.ceil(repeated[i][j].getHeight()); k < (biggest[1]); k++){
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
	
	public void scale(double factor){
		//Precondition: factor > 0
		//Postcondition: updated scaleFactor
		this.scaleFactor = factor;
	}
	
	private int[] searchForBiggest(){
		//Postcondition: this.width and this.height are set and an array of two
		//		 		 ints which contains biggestHeight and biggestWidth
		//   	 		 Unnecessary, but don't have time to change
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
