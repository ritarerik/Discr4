import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> ���������������� �������� >> 1");
			System.out.println("> ������������ �������� >> 2");
			System.out.println("> ����� >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt();				
				if (input == 0) exit = true;				
			} catch (Exception e) { 
				System.out.println("\n> �������� ����\n");
				continue; 
			}
			
			if (!exit) {			
				System.out.println();
				
				if (input == 1) { // ���������������� ��������
					
					System.out.print("> ���������� ������ >> ");
					try { 
						input = in.nextInt();				
						if (input == 0) throw new Exception();				
					} catch (Exception e) { 
						System.out.println("\n> �������� ����\n");
						continue; 
					}					
					
					System.out.println();
					System.out.println(">> ������� ��������� >\n");
					
//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        
			        System.out.println(">> ������ ������������ ��������� ��� 7-�� ������� (x(6))>\n");
			        int B[] = TransitiveClosure.getDirect(A, 1); // ���������� �� 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(B, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> �������� ������������ ��������� ��� 7-�� ������� (x(6))>\n");
			        int C[] = TransitiveClosure.getReverse(A, 2); // ���������� �� 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(C, 'x');
					
				    
				} else { // ������������ ��������
					
				}
				
				System.out.println("\n\n");
		         
			} 
		}
		
		in.close();
		
	}
	
}
