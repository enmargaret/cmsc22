/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

import java.lang.*;

public class Triangle{
	protected double side1;
	protected double side2;
	protected double side3;

	public Triangle(){
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}

	public Triangle(double side1, double side2, double side3){
		if(side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2 && side1 > 0 && side2 > 0 && side3 > 0){
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		} else {
			throw new IllegalArgumentException("Incorrect sides of triangle.");
		}
	}

	public double getSide1(){return side1;}
	
	public double getSide2(){return side2;}
	
	public double getSide3(){return side3;}

	public void setSide1(double side1){
		if(side1 >= side2 + side3 && side1 <= 0){
			throw new IllegalArgumentException("Incorrect value of side1");
		} else {
			this.side1 = side1;
		}
	}

	public void setSide2(double side2){
		if(side2 >= side1 + side3 && side2 <= 0){
			throw new IllegalArgumentException("Incorrect value of side2");
		} else {
			this.side2 = side2;
		}
	}

	public void setSide3(double side3){
		if(side3 >= side2 + side1 && side3 <= 0){
			throw new IllegalArgumentException("Incorrect value of side3");
		} else {
			this.side3 = side3;
		}
	}

	public double getPerimeter(){
		return side1 + side2 + side3;
	}

	public double getArea(){
		double s = 0.5 * (side1 + side2 + side3);
		return Math.sqrt(s * (s-side1) * (s - side2) * (s - side3)); //Heron's formula
	}

	public String toString(){
		return "A triangle with sides " + side1 + ", " + side2 + ", and " + side3 + " is a subclass of " + super.toString();
	}
}