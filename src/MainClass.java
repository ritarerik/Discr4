import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> Последовательный алгоритм >> 1");
			System.out.println("> Параллельный алгоритм >> 2");
			System.out.println("> Выход >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt();				
				if (input == 0) exit = true;				
			} catch (Exception e) { 
				System.out.println("\n> Неверный ввод\n");
				continue; 
			}
			
			if (!exit) {			
				System.out.println();
				
				if (input == 1) { // последовательный алгоритм
					
					System.out.print("> Количество вершин >> ");
					try { 
						input = in.nextInt();				
						if (input == 0) throw new Exception();				
					} catch (Exception e) { 
						System.out.println("\n> Неверный ввод\n");
						continue; 
					}					
					
					System.out.println();
					System.out.println(">> МАТРИЦА СМЕЖНОСТИ >\n");
					
//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        
			        System.out.println(">> ПРЯМОЕ ТРАНЗИТИВНОЕ ЗАМЫКАНИЕ ДЛЯ 7-ОЙ ВЕРШИНЫ (x(6))>\n");
			        int B[] = TransitiveClosure.getDirect(A, 1); // ПЕРЕДЕЛАТЬ НА 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(B, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> ОБРАТНОЕ ТРАНЗИТИВНОЕ ЗАМЫКАНИЕ ДЛЯ 7-ОЙ ВЕРШИНЫ (x(6))>\n");
			        int C[] = TransitiveClosure.getReverse(A, 2); // ПЕРЕДЕЛАТЬ НА 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(C, 'x');
					
				    
				} else { // параллельный алгоритм
					
				}
				
				System.out.println("\n\n");
		         
			} 
		}
		
		in.close();
		
	}
	
}
