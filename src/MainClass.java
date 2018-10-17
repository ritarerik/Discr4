import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> ����������� ��������� ������� >> (4;8)");
			System.out.println("> ������� �������� ������� >> 1");
			System.out.println("> ����� >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt(); 
				
				if (input == 0) exit = true;
				else if (input == 1) ;
				else if (input < 4 || input > 8) throw new Exception();
				
			} catch (Exception e) { 
				System.out.println("\n> �������� ����\n");
				continue; 
			}
			
			if (!exit) {			
				System.out.println();
				
				if (input == 1) {
				
					boolean A[][] = {{false, true,  true,  false, false, false, false, false, false},
									 {false, false, false, true,  false, false, false, false, false},
									 {false, false, false, true,  false, false, false, false, false},
									 {false, false, false, false, true,  false, false, false, false},
									 {false, false, false, false, false, true,  true,  true,  false},
									 {false, false, false, false, false, false, false, false, false},
									 {false, false, false, false, false, false, false, false, false},
									 {false, false, false, false, false, false, false, false, true},
									 {false, false, false, false, false, false, false, false, false}};
			        
					System.out.println("\n");
					
			        boolean B[][] = {{false, true,  true,  false, false, false, false, false, false},
							 		 {false, false, false, false, true,  false, false, false, false},
							 		 {false, false, false, true,  false, false, false, false, false},
							 		 {false, false, false, false, true,  false, false, false, false},
							 		 {false, false, false, false, false, true,  true,  true,  false},
							 		 {false, false, false, false, false, false, false, false, false},
							 		 {false, false, false, false, false, false, false, false, false},
							 		 {false, false, false, false, false, false, false, false, true},
							 		 {false, false, false, false, false, false, false, false, false}};
				    
				} else {
					
				}
				
				System.out.println("\n");
		         
			} 
		}
		
		in.close();
		
	}
	
}
