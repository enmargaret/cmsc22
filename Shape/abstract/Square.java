/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

public class Square extends Rectangle{
	
	public Square(){
		super();
	}
	public Square(double side){
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled){
		super(side, side, color, filled);
	}
	
	public double getSide(){
		return width;
	}
	
	public void setSide(double side){
		setWidth(side);
		setLength(side);
	}
	//overridden method
	public void setWidth(double side){
		super.setWidth(side);
	}
	//overridden method
	public void setLength(double side){
		super.setLength(side);
	}

	public String toString(){
		return String.format("A Square with side = %.2f, which is a subclass of ", width) + super.toString();
	}
}