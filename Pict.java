/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public interface Pict {
 	 // instances represent 2-dimensional pictures
 	 // consisting of printable characters

 	 public String toString();
 	 // returns the picture as String
     
 	 public void scale(double factor);
 	 // 0.1 <= factor <= 10.0; resize the picture
 	 
 	 public double getHeight();
 	 
 	 public double getWidth();
 }