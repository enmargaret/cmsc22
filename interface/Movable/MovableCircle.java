/*
*Created by enmargaret, jezamarts && noahdominic;
*/

public class MovableCircle implements Movable{
	private MovablePoint center;
	private int radius;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	public void moveUp(){
   		center.y -= center.ySpeed;
   	}

   	public void moveDown(){
   		center.y += center.ySpeed;
   	}

   	public void moveLeft(){
   		center.x -= center.xSpeed;
   	}

   	public void moveRight(){
   		center.x += center.xSpeed;
   	}

   	public String toString(){
   		return "Coordinates of Circle are (" + center.x + ", " + center.y + ")";
   	}
}