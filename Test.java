/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
//Testclass 
public class Test {
	public static void main(String[] args) {
		Box box1, box2;
		ClearBox box3;
		Pict[][] repeated = new Pict[10][11];
		
		//create new Box with width=5, height=5, content=0 and frame=-
		box1 = new Box(5,5,'o','-');
		//create new Box with width=8, height=6, content=I and frame=_
		box2 = new Box(8,6,'I','_');
		//create new ClearBox with width=4, height=10, content=z and frame=*
		box3 = new ClearBox(4,10,'z');
		
		
		System.out.println(box1.toString());
		System.out.println(box2.toString());
		System.out.println(box3.toString());
		
		System.out.println("box1.width: " + box1.getWidth() + " box1.height: " + box1.getHeight());
		System.out.println("box2.width: " + box2.getWidth() + " box2.height: " + box2.getHeight());
		System.out.println("box3.width: " + box3.getWidth() + " box3.height: " + box3.getHeight());
		System.out.println("box3.getRatio(): " + box3.getRatio());
		
		System.out.println("scale1: 5");
		System.out.println("scale2: 0.5");
		System.out.println("scale3: 3");
		
		box1.scale(5);
		box2.scale(0.5);
		box3.scale(3);
		
		System.out.println("box1.width: " + box1.getWidth() + " box1.height: " + box1.getHeight());
		System.out.println("box2.width: " + box2.getWidth() + " box2.height: " + box2.getHeight());
		System.out.println("box3.width: " + box3.getWidth() + " box3.height: " + box3.getHeight());
		
		System.out.println(box1.toString());
		System.out.println(box2.toString());
		System.out.println(box3.toString());
		
		System.out.println("box3.getRatio(): " + box3.getRatio());
		
		repeated[0][0] = box1;
		repeated[0][1] = box2;
		repeated[1][1] = box3;
		
		Repeated rep = new Repeated(repeated);//, repeated.length, repeated[0].length);
		
		System.out.println("Rep to String");
		System.out.println(rep.toString());
	}
}