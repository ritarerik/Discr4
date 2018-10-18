import java.util.ArrayDeque;

// поиск транзитивных замыканий

public class TransitiveClosure {

	public static int[] getDirect(boolean G[][], int index) {
		
		int B[] = new int[G[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;	
		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // очередь вершин
		Q.addLast(index);							// первая вершина задаётся (по заданию 7-ая (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // очередь расстояний
		L.addLast(B[index]);						// первое расстояние = 0
		
		while (!Q.isEmpty()) {	// обход в ширину 	 		
			
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
	
	public static int[] getReverse(boolean A[][], int index) {
		
		int B[] = new int[A[0].length];
		
		
		
		return B;
		
	}
	
	
}
