

// поиск транзитивных замыканий

public class TransitiveClosure {

	public static int[] getDirect(boolean A[][], int index) {
		
		int B[] = new int[A[0].length];
		for (int i = 0; i < B.length; i++) B[i] = -1;
		B[index] = 0;	
		
		
		
		return B;
		
	}
	
	public static int[] getReverse(boolean A[][], int index) {
		
		int B[] = new int[A[0].length];
		
		
		
		return B;
		
	}
	
	
}
