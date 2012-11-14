public class newRepeated implements Pict{
	private Object[][] repeated;
	private double scaleFactor;
	private double width;
	private double height;
	
	public newRepeated(Object[][] repeated){
		this.repeated = new Object[repeated.length][repeated[0].length];
		this.repeated = repeated;
		this.scaleFactor = 1.0;
	}
	
	public String toString(){
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
							for(int h = (int)Math.ceil(tmp[0].length() * scaleFactor); h < width; h++){
								tmp[k] += "k";
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
								ret += "h";
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
		this.scaleFactor = factor;
	}
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
}
