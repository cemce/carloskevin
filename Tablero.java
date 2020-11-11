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
		if (tablero[antigaX][antigaY].posibleMoviment(antigaX, antigaY, x, y)) {
		
			if (tablero[x][y].color.equalsIgnoreCase(tablero[antigaX][antigaY].color)) {
				
				System.out.println("La posición a la que va la ficha, es del mismo color que la otra");
			}
			
			else {
				tablero[x][y].color = tablero[antigaX][antigaY].color;
				tablero[x][y].letra = tablero[antigaX][antigaY].letra;	
		
				tablero[antigaX][antigaY].color = "empty";
				tablero[antigaX][antigaY].letra = "*";
		
	
		}
		showTablero();
		}
	
	}
}
