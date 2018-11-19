
public class WorkingThread4 extends Thread {
	
	private static int N = 0;
	private static boolean G[][];
	
	WorkingThread4(int n, boolean g[][]) {
		N = n;
		G = g;			
	}
	
	@Override
	public void run() {

		int i = N;
		long startTime = System.currentTimeMillis();
		
		while (i < G[0].length) {
			int B[] = TransitiveClosure.getDirect(G, i);			
			for (int j = 0; j < B.length; j++) 				
				if (B[j] == -1) {
					Integer a[] = {i, j};					
					System.out.println("   {x(" + a[0] + "), x(" + a[1] + ")}");
				}
			i+= 4;			
		}
		
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("  >> t(" + N + ") = " + timeSpent + "мс");
		
	}
	
	
}
