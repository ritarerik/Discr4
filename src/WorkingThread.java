
public class WorkingThread extends Thread {
	
	int N = 0;
	
	WorkingThread(int n) {
		N = n;
	}
	
	@Override
	public void run() {
		
		System.out.println("YA RODILSYA " + N);
		
	}
	
	
}
