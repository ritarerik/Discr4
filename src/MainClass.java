import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> Ïîñëåäîâàòåëüíûé àëãîðèòì >> 1");
			System.out.println("> Ïàðàëëåëüíûé àëãîðèòì >> 2");
			System.out.println("> Âûõîä >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt();				
				if (input == 0) exit = true;				
			} catch (Exception e) { 
				System.out.println("\n> Íåâåðíûé ââîä\n");
				continue; 
			}
			
			if (!exit) {			
				
				System.out.println();
				System.out.print("> Êîëè÷åñòâî âåðøèí >> ");
				
				try { 
					input = in.nextInt();				
					if (input == 0) throw new Exception();				
				} catch (Exception e) { 
					System.out.println("\n> Íåâåðíûé ââîä\n");
					continue; 
				}		
				
				if (input == 1) { // ïîñëåäîâàòåëüíûé àëãîðèòì
					
					System.out.println();
					System.out.println(">> ÌÀÒÐÈÖÀ ÑÌÅÆÍÎÑÒÈ >\n");
					
//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        
			        System.out.println(">> ÏÐßÌÎÅ ÒÐÀÍÇÈÒÈÂÍÎÅ ÇÀÌÛÊÀÍÈÅ ÄËß 7-ÎÉ ÂÅÐØÈÍÛ (x(6))>\n");
			        int B[] = TransitiveClosure.getDirect(A, 1); // ÏÅÐÅÄÅËÀÒÜ ÍÀ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(B, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> ÎÁÐÀÒÍÎÅ ÒÐÀÍÇÈÒÈÂÍÎÅ ÇÀÌÛÊÀÍÈÅ ÄËß 7-ÎÉ ÂÅÐØÈÍÛ (x(6))>\n");
			        int C[] = TransitiveClosure.getReverse(A, 2); // ÏÅÐÅÄÅËÀÒÜ ÍÀ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(C, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> ÏÎÑÈÊ ÑËÀÁÛÕ ÊÎÌÏÎÍÅÍÒ ÃÐÀÔÀ >\n");
					
			        TransitiveClosure.printComponents(A);					
					
				} else { // ïàðàëëåëüíûé àëãîðèòì

//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        			        
			        System.out.println(">> ÑËÀÁÛÅ ÊÎÌÏÎÍÅÍÒÛ ÃÐÀÔÀ >\n");					
			        TransitiveClosure.printComponentsMULTITHREAD(A);
								        					
				}
				
				System.out.println("\n");
		         
			} 
		}
		
		in.close();
		
	}
	
}
