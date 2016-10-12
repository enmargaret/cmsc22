/*
*Created by enmargaret, jezamarts && noahdominic;
*/

public class TestResizable{
	
	public static void main (String[] args){
		ResizableCircle c1 = new ResizableCircle(10);
		
		System.out.println(c1);
		c1.resize(100);
		System.out.println(c1);
		c1.resize(-50);
		System.out.println(c1);
	}
}