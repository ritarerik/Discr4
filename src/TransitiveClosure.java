import java.util.ArrayDeque;

// ����� ������������ ���������

public class TransitiveClosure {
	
	// ������ ������������ ��������� ������������
	public static int[] getDirect(boolean G[][], int index) {
		
		int B[] = new int[G[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // ������� ������
		Q.addLast(index);							// ������ ������� ������� ��� �������� ������� (�� ������� 7-�� (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // ������� ����������
		L.addLast(B[index]);						// ������ ���������� = 0
		
		while (!Q.isEmpty()) {						// ����� � ������ 	 		
			
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
	
	// �������� ������������ ��������� ������������
	public static int[] getReverse(boolean G[][], int index) {
		
		int B[] = new int[G.length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;		
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // ������� ������
		Q.addLast(index);							// ������ ������� ������� ��� �������� ������� (�� ������� 7-�� (x(6)))
		
		ArrayDeque<Integer> L = new ArrayDeque<>(); // ������� ����������
		L.addLast(B[index]);						// ������ ���������� = 0
		
		while (!Q.isEmpty()) {						// ����� � ������ 	 		
			
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
	
	public static int[][] getComponents(boolean B[][]) {
		
		int A[][] = new int[B.length][2];
		
		
		
		
		return A;
		
	}
	
	public static int[][] getComponentsMULTITHREAD(boolean B[][]) {
		
		int A[][] = new int[B.length][2];
		
		
		
		
		return A;
		
	}
	
	
}
