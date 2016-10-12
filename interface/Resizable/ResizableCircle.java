/*
*Created by enmargaret, jezamarts && noahdominic;
*/

public class ResizableCircle extends Circle implements Resizable{
	
	public ResizableCircle(double radius){
		super(radius);
	}

	public void resize(int percent){
		if(percent > 0){
			radius += radius * ((double)percent/100);
		}
		else if(percent < 0){
			radius -= (radius* -1) * ((double)percent/100);
		}
	}
}