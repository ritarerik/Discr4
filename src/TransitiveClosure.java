import java.util.ArrayDeque;

// ����� ������������ ���������

public class TransitiveClosure {

	public static int[] getDirect(boolean G[][], int index) {
		
		int B[] = new int[G[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;	
		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // ������� ������
		Q.addLast(index);							// ������ ������� ������� (�� ������� 7-�� (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // ������� ����������
		L.addLast(B[index]);						// ������ ���������� = 0
		
		while (!Q.isEmpty()) {	// ����� � ������ 	 		
			
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
