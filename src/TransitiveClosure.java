import java.util.ArrayDeque;
import java.util.ArrayList;

// поиск транзитивных замыканий

public class TransitiveClosure {
	
	// прямое транзитивное замыкание 
	public static int[] getDirect(boolean G[][], int index) {
		
		int B[] = new int[G[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // очередь вершин
		Q.addLast(index);							// первая вершина задаётся как параметр функции (по заданию 7-ая (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // очередь расстояний
		L.addLast(B[index]);						// первое расстояние = 0
		
		while (!Q.isEmpty()) {						// обход в ширину 	 		
			
			int i = Q.removeFirst();
			
			int length = L.removeFirst() + 1;						
			for (int j = 0; j < G[0].length; j++)						
				if (G[i][j] && B[j] != 0 && B[j] == -1) {					
					Q.addLast(j);
					L.addLast(length);
					B[j] = length;
				} 
						
		}
		
		return B;
		
	}
	
	// обратное транзитивное замыкание
	public static int[] getReverse(boolean G[][], int index) {
		
		int B[] = new int[G.length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // очередь вершин
		Q.addLast(index);							// первая вершина задаётся как параметр функции (по заданию 7-ая (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // очередь расстояний
		L.addLast(B[index]);						// первое расстояние = 0
		
		while (!Q.isEmpty()) {						// обход в ширину 	 		
			
			int j = Q.removeFirst();
			
			int length = L.removeFirst() + 1;						
			for (int i = 0; i < G.length; i++)						
				if (G[i][j] && B[i] != 0 && B[i] == -1) { 
					Q.addLast(i);
					L.addLast(length);
					B[i] = length;
				} 
						
		}		
		
		return B;
		
	}
	
	//----------------------------------------------------------------//
	//----------------------------------------------------------------//
	
	public static void printComponents(boolean G[][]) {
		
		ArrayList<Integer[]> A = new ArrayList<>();		

		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < G[0].length; i++) {			
			int B[] = getDirect(G, i);			
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
		}		
		
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("\n  >> t = " + timeSpent + "мс\n");
		
	}
	
	public static void printComponentsMULTITHREAD(boolean G[][]) {
		
//		int threadsNumber = 4;
//		WorkingThread wt[] = new WorkingThread[threadsNumber];
//
//		for (int i = 0; i < threadsNumber; i++) {			
//			wt[i] = new WorkingThread(i, G);
//			wt[i].start();			
//		}
		
		WorkingThread wt_1 = new WorkingThread(0, G);
		WorkingThread2 wt_2 = new WorkingThread2(1, G);
		WorkingThread3 wt_3 = new WorkingThread3(2, G);
		WorkingThread4 wt_4 = new WorkingThread4(4, G);
		wt_1.start();
		wt_2.start();
		wt_3.start();
		wt_4.start();
		
	}
	
	
}
