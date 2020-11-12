public class Ficha {

	String color;
	String letra;
	
	public Ficha (String color, String letra) {
	 
		this.color = color;
		this.letra = letra;
		
	}
	
	public boolean posibleMoviment (int antigaX, int antigaY, int x, int y) {
		
		//Torre posible movimientos
		if (this.letra.equalsIgnoreCase("t")) {
			
			if (x == antigaX || antigaY == y) {
				System.out.println("correcte");
				return true;
			}
			//Comprobant de on les ha posat
			else {
				System.out.println(antigaX + "" + x);
			}
		}
		
		//Peones movimientos possibles
		if (this.letra.equalsIgnoreCase("p")) {
			
			if (this.color.equalsIgnoreCase("blancas")) {
				
				if ( (x+1 == antigaX || x+2 == antigaX) && antigaY == y ) {
					System.out.println("correcte");
					return true;
				}
				else {
					System.out.println("peon fallo movimiento");
					return false;
				}
			}
			
			else {
			if ( (x-1 == antigaX || x-2 == antigaX) && antigaY == y ) {
				System.out.println("correcte");
				return true;
			}
			else {
				System.out.println("peon fallo movimiento");
				return false;
			}
		}
	}//Fin peon
		
		if (this.letra.equalsIgnoreCase("c")) {
			
			if ((x - antigaX) * (x- antigaX) + (y - antigaY) * (y- antigaY) == 5) {
				System.out.println("correcte");
				return true;
			}
			else {
				System.out.println("fallo movimiento caballo");
				return false;
			}
			
		} //Fin del caballo
		
		if (this.letra.equalsIgnoreCase("q")) {
			
			if ((x == antigaX) || (y == antigaY) || (Math.abs(x - antigaX) == Math.abs(y - antigaY))) {
				System.out.println("correcte");
				return true;
			}
			else {
				System.out.println("fallo movimiento reina");
				return false;
			}
		} //Fin de la reina
		
		if (this.letra.equalsIgnoreCase("k")) {
			
			if ( (Math.abs(x - antigaX )<=1) && (Math.abs(y - antigaY) <=1) ) {
				System.out.println("correcte");
				return true;
			}
			else {
				System.out.println("fallo movimiento rei");
				return false;
			}
		} //Fin rei
		
		if (this.letra.equalsIgnoreCase("a")) {
			
			if (Math.abs(x - antigaX) == Math.abs(y - antigaY)) {
				System.out.println("correcte");
				return true;
				}
			else {
				System.out.println("fallo movimiento alfil");
				return false;
			}
		}// Fi alfil
		return false;
		}
	}


