/*
* Modified by enmargaret, JezaMarts, && noahdominic;
*/

import java.util.*;
import java.io.*;

public class TestShape{
	public static void main(String[]args){
		Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
		System.out.println(s1);                    // which version? -->The Circle's toString is called;
		System.out.println(s1.getArea());          // which version? -->The area of the Circle;
		System.out.println(s1.getPerimeter());     // which version? --> The perimeter of the Circle;
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());
		//System.out.println(s1.getRadius());	
		/*s1.getRadius() can only be accessed if the Shape is 
		downcasted back to Circle*/
		   
		Circle c1 = (Circle)s1;                   // Downcast back to Circle
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());
		   
		//Shape s2 = new Shape();
		Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		//System.out.println(s3.getLength()); 
		/*s3.getLength() can only be accessed if the Shape is 
		downcasted back to Rectangle*/
		   
		Rectangle r1 = (Rectangle)s3;   // downcast
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());
		   
		Shape s4 = new Square(6.6);     // Upcast
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		//System.out.println(s4.getSide());
		/*s4.getSide() can only be accessed if the Shape is 
		downcasted back to Square*/
		  
		Rectangle r2 = (Rectangle)s4; /*
		*This will not work because s4 is a Square and when Shape s4 is downcasted to Rectangle.
		*A Rectangle cannot be downcasted as a Square since it is the superclass of Square.
		*/
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		//System.out.println(r2.getSide());
		/*r2.getSide() can only be accessed if it is a Square*/
		System.out.println(r2.getLength());
		   
		// Downcast Rectangle r2 to Square
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());
	}
}
