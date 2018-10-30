import java.util.ArrayDeque;
import java.util.ArrayList;

// ����� ������������ ���������

public class TransitiveClosure {
	
	// ������ ������������ ��������� 
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
	
	// �������� ������������ ���������
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
	
	public static void printComponents(boolean G[][]) {
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer[]> A = new ArrayList<>();		
		
		for (int i = 0; i < G[0].length; i++) {			
			int B[] = getDirect(G, i);			
			for (int j = 0; j < B.length; j++) 				
				if (B[j] == -1) {
					Integer a[] = {i, j};
					
					boolean find = false;
					for (int k = 0; k < A.size(); k++) 
						if (a[0] == A.get(k)[1] && a[1] == A.get(k)[0]) {
							find = true;
							break;
						}
					
					if (!find)  {
//						A.add(a);
						System.out.println("   {x(" + a[0] + "), x(" + a[1] + ")}");
					}
				}
		}		
		
		//----------------------------------------------------------------//
//		ArrayList<String> B = new ArrayList<>();		
//		for (Integer a[] : A) B.add("   {x(" + a[0] + "), x(" + a[1] + ")}");
//		for (String b : B) System.out.println(b);
		//----------------------------------------------------------------//
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println("\n>> ����� > " + timeSpent + "��\n");
		//----------------------------------------------------------------//
//		return B;
		
	}
	
	public static void printComponentsMULTITHREAD(boolean G[][]) {
		
		long startTime = System.currentTimeMillis();
		ArrayList<Integer[]> A = new ArrayList<>();	
		
		int threadsNumber = 4;
		WorkingThread wt[] = new WorkingThread[threadsNumber];
		
		for (int i = 0; i < threadsNumber; i++) {			
			wt[i] = new WorkingThread(i);
			wt[i].start();			
		}
				
		//----------------------------------------------------------------//
		long timeSpent = System.currentTimeMillis() - startTime;
		System.out.println(">> ����� > " + timeSpent + "��\n");
		
		
	}
	
	
}
