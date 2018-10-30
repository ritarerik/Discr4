
public class WorkingThread extends Thread {
	
	private static int N = 0;
	private static boolean G[][];
	
	WorkingThread(int n, boolean g[][]) {
		N = n;
		G = g;
	}
	
	@Override
	public void run() {
		
//		for (int i = N; i < G[0].length; i++) {	
		int i = N;
		while (i <  G[0].length) {
			int B[] = TransitiveClosure.getDirect(G, i);			
			for (int j = 0; j < B.length; j++) 				
				if (B[j] == -1) {
					Integer a[] = {i, j};
					
					boolean find = false;
//					for (int k = 0; k < A.size(); k++) 
//						if (a[0] == A.get(k)[1] && a[1] == A.get(k)[0]) {
//							find = true;
//							break;
//						}
					
					if (!find)  {
						System.out.println("   {x(" + a[0] + "), x(" + a[1] + ")}");
					}
				}
			i+= 4;			
		}
		
	}
	
	
}
