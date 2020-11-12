import java.util.Scanner;

public class Tablero {

	Ficha[][] tablero = new Ficha[8][8];
	int reyes = 2;

	Tablero () {
		
		for (int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas < tablero.length; columnas++) {
				
				if (filas == 0) {
					
					tablero[0][0] = new Ficha	("negro", "t");
					tablero[0][1] = new Ficha("negro", "c");
					tablero[0][2] = new Ficha("negro", "a");
					tablero[0][3] = new Ficha("negro", "k");
					tablero[0][4] = new Ficha("negro", "q");
					tablero[0][5] = new Ficha("negro", "a");
					tablero[0][6] = new Ficha("negro", "c");
					tablero[0][7] = new Ficha("negro", "t");
				}
				else if (filas == 1) {

					for (columnas = 0; columnas < tablero.length; columnas++) {
						tablero[filas][columnas] = new Ficha("negro", "p");
					}
				}
				else if(filas == 6) {
					
					for (columnas = 0; columnas < tablero.length; columnas++) {
						tablero[filas][columnas] = new Ficha("blancas", "P");
					}
				}
				else if(filas == 7) {
					
					tablero[7][0] = new Ficha("blancas", "T");
					tablero[7][1] = new Ficha("blancas", "C");
					tablero[7][2] = new Ficha("blancas", "A");
					tablero[7][3] = new Ficha("blancas", "K");
					tablero[7][4] = new Ficha("blancas", "Q");
					tablero[7][5] = new Ficha("blancas", "A");
					tablero[7][6] = new Ficha("blancas", "C");
					tablero[7][7] = new Ficha("blancas", "T");
					}
				else {
					
					tablero[filas][columnas] = new Ficha("empty","*");
				}
			}
		}
		showTablero();
		
	}
		
		
	
	
	public void showTablero () {
		
		int contador = 0;
		for (int filas = 0; filas < tablero.length; filas++) {
			for (int columnas = 0; columnas < tablero.length; columnas++) {
				System.out.print(tablero[filas][columnas].letra + " ");
				
				if (tablero[filas][columnas].letra.equalsIgnoreCase("k")) {
					contador++;
					this.reyes = contador;
				}
			}
			System.out.println("");
		}
		
	}
	
	public void movimiento (int antigaX, int antigaY, int x, int y) {
		
		// if compleix totes les condicions, encara falten per posar
		if (tablero[antigaX][antigaY].posibleMoviment(tablero,antigaX, antigaY, x, y) && sePuedeMover(antigaX, antigaY, x, y)) {
		
			
			if (tablero[antigaX][antigaY].color.equalsIgnoreCase(tablero[x][y].color)) {
				
				System.out.println("No puedes moverla ahí, el color es el mismo al de la ficha");
			}
			
			//Controlar el peon que no pueda matar delante
			else if (tablero[antigaX][antigaY].letra.equalsIgnoreCase(tablero[x][y].letra) && 
					(tablero[antigaX][antigaY].letra.equalsIgnoreCase("p")
							|| tablero[x][y].letra.equalsIgnoreCase("p"))) {
				
				System.out.println("Peon no mata así");
			}
			
			else {
			tablero[x][y].color = tablero[antigaX][antigaY].color;
			tablero[x][y].letra = tablero[antigaX][antigaY].letra;	
		
			tablero[antigaX][antigaY].color = "empty";
			tablero[antigaX][antigaY].letra = "*";
			}
	
		}
		else {
			System.out.println("Algo ha fallat " + "comprobació moviment peça " + tablero[antigaX][antigaY].posibleMoviment(tablero,antigaX, antigaY, x, y) + "comprobació pot passar " + sePuedeMover(antigaX, antigaY, x, y));
		}
		showTablero();
	}
	
	//Aqui hay errores 100%
	public boolean sePuedeMover(int antigaX, int antigaY, int x, int y) {
	    
		
		if (antigaX == x && antigaY > y) {
			//Això significa que es mou a la esquerra
			//Es va restant la i, comenc                             ESQUERRA
			for (int i = antigaY - 1; i > y; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	               System.out.println("esquerra mal");
	            	return false;
	               }
			}
		}
		//Fila més petita, columna igual 
		//Moviment cap abaix                                      ABAIX
		else if (antigaX < x && antigaY == y) { 
				
			//Se suma les files 
		        for (int i = antigaX + 1; i < x; i++) {
		            if (!tablero[i][antigaY].letra.equalsIgnoreCase("*")) {
		            	System.out.println("abaix mal");
		                return false;
		            }
		        }
		}	
		//Fila igual, columna més petita
		//Això vol dir que anem cap a la dreta                      DRETA
		else if (antigaX == x && antigaY < y) {
			//Sumem a la columna per veure si trobem algo que no toca
	        for (int i = antigaY + 1; i < y; i++) {
	            if (!tablero[antigaX][i].letra.equalsIgnoreCase("*")) {
	            	System.out.println("dreta malament");	            	
	            	return false;
	               
	            }
	        }
	    } 
		
		//Fila és més gran, columna igual
		//Això vol dir que anem cap amunt                             AMUNT
		else if (antigaX > x && antigaY == y) { // horizontal west
	        for (int i = antigaX - 1; i > x; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	            	System.out.println("amunt mal");
	                return false;
	            }
	        }
	    }
		
		return true;
		/*//Posició fila inicial és igual a la fila, sol canvia columnes
		
	    else if (antigaX < x && antigaY > y) { 
	        
	        for (int row = antigaX + 1; row < x; row++) {
	            for (int col = antigaY - 1; col >= y; col--) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                	System.out.println("vertical mal");
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX < x && antigaY < y) { 
	        for (int row = antigaX + 1; row < x; row++) {
	            for (int col = antigaY + 1; col < y; col++) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                	System.out.println("vertical mal");
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX > x && antigaY < y) {
	        for (int row = antigaX - 1; row >= x; row--) {
	            for (int col = antigaY + 1; col < y; col++) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                	System.out.println("vertical mal");
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX > x && antigaY > y) { 
	        for (int row = antigaX - 1; row >= x; row--) {
	            for (int col = antigaY - 1; col >= y; col--) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                	System.out.println("vertical mal");
	                    return false;
	                }
	            }
	        }
	    }
	    return true;*///
	}
	public boolean end (Tablero tablero) {
		
		if (tablero.reyes != 2) {
			return true;
		}
		return false;
		
	}
}
