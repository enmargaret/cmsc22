import java.util.*;
import java.io.*;
/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/
public class TestShape{
	public static void main(String[] args){
		Circle x = new Circle(2.0);
		Rectangle y = new Rectangle(3, 2, "yellow",true);
		Shape z = new Shape("red",false);
		Square a = new Square(3.0);
			
		System.out.println(z);	
		System.out.println(x + " Perimeter: " + x.getPerimeter() + " Area: " +x.getArea());
		System.out.println(y + " Perimeter: " + y.getPerimeter() + " Area: " +y.getArea());
		System.out.println(a + " Perimeter: " + a.getPerimeter() + " Area: " +a.getArea());
	}
}