/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

public abstract class Shape{
	protected String color;
	protected boolean filled;
	
	public Shape(){
		color = new String("green");
		filled = true;
	}
	
	public Shape(String color, boolean filled){
		this.color = new String(color);
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		return filled;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public String toString(){
		if(isFilled()){
			return "A Shape with color of " + color + " and filled."	;
		}
		else{
			return "A Shape with color of " + color + " and not filled.";
		}
	}
}
