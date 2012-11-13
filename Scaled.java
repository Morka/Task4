import java.lang.Math;

public class Scaled{
	private Pict[][] repeated;
	private double scaleFactor;
	
	
	public Scaled(Pict[][] repeated){
		this.repeated = new Pict[repeated.length][repeated[0].length];
		this.repeated = repeated;
		this.scaleFactor = 1.0;
	}
	
	public String toString(){
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
								tmp[k] += "b";
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
	
	public void scale(double factor){
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
