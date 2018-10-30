import java.util.ArrayDeque;
import java.util.ArrayList;

// поиск транзитивных замыканий

public class TransitiveClosure {
	
	// пр€мое транзитивное замыкание 
	public static int[] getDirect(boolean G[][], int index) {
		
		int B[] = new int[G[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // очередь вершин
		Q.addLast(index);							// перва€ вершина задаЄтс€ как параметр функции (по заданию 7-а€ (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // очередь рассто€ний
		L.addLast(B[index]);						// первое рассто€ние = 0
		
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
		Q.addLast(index);							// перва€ вершина задаЄтс€ как параметр функции (по заданию 7-а€ (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // очередь рассто€ний
		L.addLast(B[index]);						// первое рассто€ние = 0
		
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
		System.out.println("\n>> ¬–≈ћя > " + timeSpent + "мс\n");
		
	}
	
	public static void printComponentsMULTITHREAD(boolean G[][]) {
		
			
		
		int threadsNumber = 4;
		WorkingThread wt[] = new WorkingThread[threadsNumber];
		
		//----------------------------------------------------------------//
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < threadsNumber; i++) {			
			wt[i] = new WorkingThread(i, G);
			wt[i].start();			
		}
				
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println(">> ¬–≈ћя > " + timeSpent + "мс\n");
		
		
	}
	
	
}
