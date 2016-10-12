/*
*Created by enmargaret, jezamarts && noahdominic;
*/

public class Circle implements GeometricObject{
	protected double radius;

	public Circle(double radius){
		this.radius = radius;
	}

	public double getPerimeter(){
		return 2*(Math.PI*radius);
	}

	public double getArea(){
		return (radius*radius)*Math.PI;
	}
	
	public String toString(){
		return "Radius: " + radius;
	}
}