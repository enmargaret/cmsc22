/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

import java.lang.*;

public class Circle extends Shape{
	protected double radius;
	
	public Circle(){
		super();
		radius = 1.0;
	}
	
	public Circle(double radius){
		super();
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color,filled);
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getArea(){
		return Math.PI*(radius*radius);
	}
	
	public double getPerimeter(){
		return 2*(Math.PI*radius);
	}
	
	public String toString(){
		return String.format("A Circle with radius = %.2f, which is a subclass of ", radius) + super.toString();
	}
}