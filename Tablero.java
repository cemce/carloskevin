public class Tablero {

	Ficha[][] tablero = new Ficha[8][8];

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
		
		for (int filas = 0; filas < tablero.length; filas++) {
			for (int columnas = 0; columnas < tablero.length; columnas++) {
				System.out.print(tablero[filas][columnas].letra + " ");
			}
			System.out.println("");
		}
	}
	
	public void movimiento (int antigaX, int antigaY, int x, int y) {
		
		// if compleix totes les condicions, encara falten per posar
		if (tablero[antigaX][antigaY].posibleMoviment(antigaX, antigaY, x, y) && sePuedeMover(antigaX, antigaY, x, y)) {
		
			
			if (tablero[antigaX][antigaY].color.equalsIgnoreCase(tablero[x][y].color)) {
				
				System.out.println("No puedes moverla ahí, el color es el mismo al de la ficha");
			}
			
			else {
			tablero[x][y].color = tablero[antigaX][antigaY].color;
			tablero[x][y].letra = tablero[antigaX][antigaY].letra;	
		
			tablero[antigaX][antigaY].color = "empty";
			tablero[antigaX][antigaY].letra = "*";
			}
	
		}
		else {
			System.out.println("Mumal " + tablero[antigaX][antigaY].posibleMoviment(antigaX, antigaY, x, y) + sePuedeMover(antigaX, antigaY, x, y));
		}
		showTablero();
	}
	
	//Aqui hay errores 100%
	public boolean sePuedeMover(int antigaX, int antigaY, int x, int y) {
	    if (antigaX == x && antigaY > y) {
	        for (int i = antigaY - 1; i > y; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	               System.out.println("horitzontal mal");
	            	return false;
	               
	            }
	        }
	    } else if (antigaX < x && antigaY == y) { // horizontal east
	        for (int i = antigaX + 1; i < x; i++) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	                return false;
	            }
	        }
	    } else if (antigaX == x && antigaY < y) { // horizontal south
	        for (int i = antigaY + 1; i < y; i++) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	               System.out.println("falso");
	            	return false;
	               
	            }
	        }
	    } else if (antigaX > x && antigaY == y) { // horizontal west
	        for (int i = antigaX - 1; i > x; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	                return false;
	            }
	        }
	    }
	    else if (antigaX < x && antigaY > y) { // diagonal northeast
	        // these diagonals aren't working properly
	        for (int row = antigaX + 1; row < x; row++) {
	            for (int col = antigaY - 1; col >= y; col--) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX < x && antigaY < y) { // diagonal southeast
	        for (int row = antigaX + 1; row < x; row++) {
	            for (int col = antigaY + 1; col < y; col++) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX > x && antigaY < y) { // diagonal southwest
	        for (int row = antigaX - 1; row >= x; row--) {
	            for (int col = antigaY + 1; col < y; col++) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                    return false;
	                }
	            }
	        }
	    } else if (antigaX > x && antigaY > y) { // diagonal northwest
	        for (int row = antigaX - 1; row >= x; row--) {
	            for (int col = antigaY - 1; col >= y; col--) {
	                if (!tablero[row][antigaX].letra.equalsIgnoreCase("*")) {
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
}
