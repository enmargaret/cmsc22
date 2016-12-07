import java.util.*;
public class Automata extends Thread{
	private boolean[] prev;
	private boolean[] curr;
	private int start, end;
	
	public Automata(int start, int end,boolean[] prev){
		this.start = start;
		this.end = end;
		this.prev = prev;
		curr = new boolean[(end - start) + 1];
	}
	
	public void run(){
		for(int i = start, j = 0; i <= end; i++, j++){
			boolean a = i-1>=0 ? prev[i-1]:false;
			boolean b = prev[i];
			boolean c = i+1<prev.length-1 ? prev[i+1]: false;
			
			if ((a && b) || (a && c) || (!a && !b && !c)) {
               curr[j] = false;
            } else {
                curr[j] = true;
			}
		}	
	}
	
	public void replace(boolean[] prev){
		for(int i = start,j = 0; i <= end; i++,j++){
			prev[i] = curr[j];
		}
	}
	
	public void display(boolean prev[]){
		String out = "";
		
		for (int i = 0; i <prev.length; i++) {
            if (prev[i]) {
                out += "1";
            } else {
                out += "0";
            }
		}	
		System.out.println(out);
	}
}
