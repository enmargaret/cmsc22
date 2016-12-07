import java.util.*;

public class AutomataTester{
	public static final int THREAD_COUNT = 10;

    public static  void main(String[] args){
        Automata[] thread = new Automata[THREAD_COUNT];
        Scanner sc = new Scanner(System.in);
		
        int in = sc.nextInt();   
        boolean prev[] = new boolean[in];
		
        prev[in/2] = true;
		
        long startTime = System.currentTimeMillis();
        int divisions = in/THREAD_COUNT;
		

        for(int i = 0; i < in; i++){
			int start = 0;
			int end = start + divisions - 1;
            for(int j = 0; j < THREAD_COUNT; j++){
				thread[j] = new Automata(start,end,prev);
				
				start = end+1;
				end = start + divisions - 1;	
				if(end > in){
					end = in - 1;
				}
                
            }
            thread[0].display(prev);
            for(int j = 0; j < THREAD_COUNT; j++){
                thread[j].start();
            }

            for(int j = 0; j < THREAD_COUNT; j++){
                while (thread[j].isAlive()) {

                    try {
                        thread[j].join();
                    } catch (InterruptedException e) {
                        System.err.println("Thread has been interrupted: " + e.getMessage());
                    }
                }
            }
			//replaces previous array with current array
            for(int j = 0; j < THREAD_COUNT; j++){
                thread[j].replace(prev);
            }
        }
        System.out.println("Time taken to generate in ms: " + (System.currentTimeMillis() - startTime));
	}
}
