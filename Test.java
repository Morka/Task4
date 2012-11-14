/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

//Analysis of subtype relationships:
//ClearBox is a valid suptype of Box - pre- and postconditions meet the requirements(preconditions in subtypes are equal or less strict)
//DarkBox would not be a valid subtype of box. The invariant in Box that the frame symbol can't change does not apply to DarkBox. For a suitable subtype invariants
//in subtypes have to have stricter invariants. For a valid subtype relation constant variables in the supertype need a equivalent(subtype of the variabletype in the supertype) variable type.
//FreeBox would not be a valid subtype of box either. Because it is completely different from Box in regards to its variables. In regards to the methods this could work though. 
 
//Testclass 
public class Test {
	public static void main(String[] args) {
		Box box1, box2;
		ClearBox box3;
		FreeBox box4;
		DarkBox box5;
		
		Pict[][] repeated = new Pict[10][11];
		
		//create new Box with width=5, height=5, content=0 and frame=-
		box1 = new Box(5,5,'o','-');
		//create new Box with width=8, height=6, content=I and frame=_
		box2 = new Box(8,6,'I','_');
		//create new ClearBox with width=4, height=10, content=z and frame=*
		box3 = new ClearBox(4,10,'z');
		
		box4 = new FreeBox("1123" + "\n" + "1233");
		
		box5 = new DarkBox(8, 6,'+');
		
		System.out.println("Box 1:");
		System.out.println(box1.toString());
		System.out.println("Box 2:");
		System.out.println(box2.toString());
		System.out.println("Box 3:");
		System.out.println(box3.toString());
		System.out.println("Box 4:");
		System.out.println(box4.toString());
		System.out.println("Box 5:");
		System.out.println(box5.toString());
		
		System.out.println("box1.width: " + box1.getWidth() + " box1.height: " + box1.getHeight());
		System.out.println("box2.width: " + box2.getWidth() + " box2.height: " + box2.getHeight());
		System.out.println("box3.width: " + box3.getWidth() + " box3.height: " + box3.getHeight());
		System.out.println("box3.getRatio(): " + box3.getRatio());
		
		System.out.println("scale1: 5");
		System.out.println("scale2: 0.5");
		System.out.println("scale3: 3");
		System.out.println("scale4: 2");
		System.out.println("scale5: 4");
		System.out.println("box5 - set new Frame to: '*'");
		
		box1.scale(5);
		box2.scale(0.5);
		box3.scale(3);
		box4.scale(2);
		box5.scale(4);
		
		box5.setFrame('*');
		
		System.out.println("box1.width: " + box1.getWidth() + " box1.height: " + box1.getHeight());
		System.out.println("box2.width: " + box2.getWidth() + " box2.height: " + box2.getHeight());
		System.out.println("box3.width: " + box3.getWidth() + " box3.height: " + box3.getHeight());
		
		System.out.println("Box 1:");
		System.out.println(box1.toString());
		System.out.println("Box 2:");
		System.out.println(box2.toString());
		System.out.println("Box 3:");
		System.out.println(box3.toString());
		System.out.println("Box 4:");
		System.out.println(box4.toString());
		System.out.println("Box 5:");
		System.out.println(box5.toString());
		
		System.out.println("box3.getRatio(): " + box3.getRatio());
		
		repeated[0][0] = box1;
		repeated[0][1] = box2;
		repeated[1][1] = box3;
		repeated[0][2] = box4;//GRAD GEADDED BITTE CHECKEN OB DER OUTPUT PASST
		repeated[1][2] = box5;//HIER AUCH CHECKEN
		/*
		Scaled scale = new Scaled(repeated);
		
		System.out.println("Rep to String");
		System.out.println(scale.toString());*/
		
		Repeated rep = new Repeated(repeated);
		System.out.println(rep.toString());
	}
}