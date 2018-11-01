import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
					
			System.out.println("> ���������������� �������� >> 1");
			System.out.println("> ������������ �������� >> 2");
			System.out.println("> ������ >> 3");
			System.out.println("> ����� >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt();				
				if (input == 0) exit = true;				
			} catch (Exception e) { 
				System.out.println("\n> �������� ����\n");
			}
			
			if (!exit) {			
				
				System.out.println();
				System.out.print("> ���������� ������ >> ");
				
				int count = 0;
				
				if (input == 1 || input == 2) 				
					try { 
						count = in.nextInt();				
						if (count == 0) throw new Exception();				
					} catch (Exception e) { 
						System.out.println("\n> �������� ����\n");
					}		
				
				switch (input) {
					case 1 : { // ���������������� ��������
						
						boolean A[][] = Matrix.createBOOLEAN(count);		        
//						System.out.println(">> ������ ���������� ����� >\n");					
				        TransitiveClosure.printComponents(A);
				        break;
					}
						
					case 2 : { // ������������ ��������
	
						boolean A[][] = Matrix.createBOOLEAN(count);			        			        
//				        System.out.println(">> ������ ���������� ����� >\n");					
				        TransitiveClosure.printComponentsMULTITHREAD(A);
				        break;
					}
									        					
					case 3 : {
						
						System.out.println();
						System.out.println(">> ������� ��������� >\n");
	
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
				        System.out.println("\n");
				        
				        System.out.println(">> ����� ������ ��������� ����� >\n");
						
				        TransitiveClosure.printComponents(A);
				        break;
					}
				}
				
				System.out.println("\n");
		         
			} 
		
		in.close();
		
	}
	
}
