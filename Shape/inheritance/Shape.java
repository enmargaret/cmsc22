/*
* Created by enamargaret, JezaMarts, && noahdominic;
*/
public class Shape{
	private String color;
	private boolean filled;
	
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
	
	public String toString(){
		if(isFilled()){
			return "A Shape with color of " + color + " and filled."	;
		}
		else{
			return "A Shape with color of " + color + " and not filled.";
		}
	}
}
