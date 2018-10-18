import java.util.ArrayDeque;

// поиск транзитивных замыканий

public class TransitiveClosure {
	
	// прямое транзитивное замыкание ОДНОПОТОЧНОЕ
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
	
	// обратное транзитивное замыкание ОДНОПОТОЧНОЕ
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
	
	// прямое транзитивное замыкание МНОГОПОТОЧНОЕ
	public static int[] getDirectMULTITHREAD(boolean G[][], int index) {
		
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
	
	// обратное транзитивное замыкание МНОГОПОТОЧНОЕ
	public static int[] getReverseMULTITHREAD(boolean G[][], int index) {
			
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
	
}
