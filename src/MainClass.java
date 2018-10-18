import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> œÓÒÎÂ‰Ó‚‡ÚÂÎ¸Ì˚È ‡Î„ÓËÚÏ >> 1");
			System.out.println("> œ‡‡ÎÎÂÎ¸Ì˚È ‡Î„ÓËÚÏ >> 2");
			System.out.println("> ¬˚ıÓ‰ >> 0");
			System.out.print("\n  >> ");
			
			int input = 0;			
			
			try { 
				input = in.nextInt();				
				if (input == 0) exit = true;				
			} catch (Exception e) { 
				System.out.println("\n> ÕÂ‚ÂÌ˚È ‚‚Ó‰\n");
				continue; 
			}
			
			if (!exit) {			
				System.out.println();
				
				if (input == 1) { // ÔÓÒÎÂ‰Ó‚‡ÚÂÎ¸Ì˚È ‡Î„ÓËÚÏ
					
					System.out.print(">  ÓÎË˜ÂÒÚ‚Ó ‚Â¯ËÌ >> ");
					try { 
						input = in.nextInt();				
						if (input == 0) throw new Exception();				
					} catch (Exception e) { 
						System.out.println("\n> ÕÂ‚ÂÌ˚È ‚‚Ó‰\n");
						continue; 
					}					
					
					System.out.println();
					System.out.println(">> Ã¿“–»÷¿ —Ã≈∆ÕŒ—“» >\n");
					
//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        
			        System.out.println(">> œ–ﬂÃŒ≈ “–¿Õ«»“»¬ÕŒ≈ «¿Ã€ ¿Õ»≈ ƒÀﬂ 7-Œ… ¬≈–ÿ»Õ€ (x(6))>\n");
			        int B[] = TransitiveClosure.getDirect(A, 1); // œ≈–≈ƒ≈À¿“‹ Õ¿ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(B, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> Œ¡–¿“ÕŒ≈ “–¿Õ«»“»¬ÕŒ≈ «¿Ã€ ¿Õ»≈ ƒÀﬂ 7-Œ… ¬≈–ÿ»Õ€ (x(6))>\n");
			        int C[] = TransitiveClosure.getReverse(A, 2); // œ≈–≈ƒ≈À¿“‹ Õ¿ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(C, 'x');
					
				    
				} else { // Ô‡‡ÎÎÂÎ¸Ì˚È ‡Î„ÓËÚÏ
					
					System.out.print(">  ÓÎË˜ÂÒÚ‚Ó ‚Â¯ËÌ >> ");
					try { 
						input = in.nextInt();				
						if (input == 0) throw new Exception();				
					} catch (Exception e) { 
						System.out.println("\n> ÕÂ‚ÂÌ˚È ‚‚Ó‰\n");
						continue; 
					}					
					
					System.out.println();
					System.out.println(">> Ã¿“–»÷¿ —Ã≈∆ÕŒ—“» >\n");
					
//					boolean A[][] = Matrix.createBOOLEAN(input);
					boolean A[][] = {{false, true, true,  false,  false, false},
							 		 {false, true,  false, false, true,  false},
									 {false, false, false, false, false, false},
									 {false, false, true,  false, false, false},
									 {true,  false, false, true,  false, false},
									 {true,  false, false, false, true,  true}};					
					
					Matrix.printBOOLEAN(A, 'x', 'x'); 
			        System.out.println("\n");
			        
			        System.out.println(">> œ–ﬂÃŒ≈ “–¿Õ«»“»¬ÕŒ≈ «¿Ã€ ¿Õ»≈ ƒÀﬂ 7-Œ… ¬≈–ÿ»Õ€ (x(6))>\n");
			        int B[] = TransitiveClosure.getDirectMULTITHREAD(A, 1); // œ≈–≈ƒ≈À¿“‹ Õ¿ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(B, 'x');
			        System.out.println("\n");
			        
			        System.out.println(">> Œ¡–¿“ÕŒ≈ “–¿Õ«»“»¬ÕŒ≈ «¿Ã€ ¿Õ»≈ ƒÀﬂ 7-Œ… ¬≈–ÿ»Õ€ (x(6))>\n");
			        int C[] = TransitiveClosure.getReverseMULTITHREAD(A, 2); // œ≈–≈ƒ≈À¿“‹ Õ¿ 6!!!!!!!!!!!!!!!
			        Matrix.printINT_VECTOR(C, 'x');
					
				}
				
				System.out.println("\n\n");
		         
			} 
		}
		
		in.close();
		
	}
	
}
