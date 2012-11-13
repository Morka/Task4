import java.lang.Math;

public class Repeated{
	private Pict[][] repeated;
	
	
	public Repeated(Pict[][] repeated){
		this.repeated = new Pict[repeated.length][repeated[0].length];
		this.repeated = repeated;
	}
	
	public String toString(){
		String ret = "";
		String tmp = "";
		
		int[] biggest = new int[2];
		biggest = scaleToBiggest();
		
		char[][] charExpresion = new char[biggest[0]][biggest[1]];

		
		for(int i = 0; i < repeated.length; i++){
			for(int j = 0; j < repeated[0].length; j++){
				if(repeated[i][j] != null){
					if(repeated[i][j].getWidth() < biggest[0]){
						
					}
					//ret += repeated[i][j].toString();
				}
			}
		}
		
		return ret;
	}
	
	private int[] scaleToBiggest(){
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
		
		ret[1] = biggestHeight;
		ret[0] = biggestWidth;
		
		return ret;
	}
}
