import java.lang.Math;

public class Repeated{
	private Pict[][] repeated;
	private double scaleFactor;
	
	
	public Repeated(Pict[][] repeated){
		this.repeated = new Pict[repeated.length][repeated[0].length];
		this.repeated = repeated;
		this.scaleFactor = 2.0;
	}
	
	public String toString(){
		String ret = "";
		String temporary = "";
		
		int[] biggest = new int[2];
		biggest = searchForBiggest();
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					temporary = this.scale(repeated[i][j]);
					if((int)Math.ceil(repeated[i][j].getWidth() * scaleFactor) < biggest[0]){
						String[] tmp;
						tmp = temporary.split("\n");
						for(int k = 0; k < tmp.length; k++){
							for(int h = (int)Math.ceil(repeated[i][j].getWidth() * scaleFactor); h < biggest[0]; h++){
								tmp[k] += "b";
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
								ret += "c";
							}
							ret += "\n";
						}
					}
				}
			}
		}
		
		return ret;
	}
	
	private String scale(Pict pictObject){
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
	
	public void setScaleFactor(double factor){
		this.scaleFactor = factor;
	}
	
	private int[] searchForBiggest(){
		int biggestHeight = 0;
		int biggestWidth = 0;
		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					if((int)Math.ceil(repeated[i][j].getWidth()) > biggestWidth){
						biggestWidth = (int)Math.ceil(repeated[i][j].getWidth());
					}
					if((int)Math.ceil(repeated[i][j].getHeight()) > biggestHeight){
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
