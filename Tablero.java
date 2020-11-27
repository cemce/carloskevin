import java.util.Scanner;

public class Tablero {

	//Indicamos atributos de la clase
	
	//El tablero estará compuesto de fichas en cada posición
	Ficha[][] tablero = new Ficha[8][8];
	//Tendrá 2 reyes, si uno desaparece, ganará x o y
	int reyes = 2;
	
	//Los colores de los reyes de la partida
	String colorRei1;
	String colorRei2;
	

	Tablero () {
		
		//Empezamos a rellenar el tablero
		for (int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas < tablero.length; columnas++) {
				
				//Aquí indicaremos todas las fichas negras que no sean peones
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
				//Aqui los peones ya que estaran delante de las otras piezas
				else if (filas == 1) {

					for (columnas = 0; columnas < tablero.length; columnas++) {
						tablero[filas][columnas] = new Ficha("negro", "p");
					}
				}
				// Aquí indicaremos las fichas blancas, que estarán en lo más alto de la matriz.
				//Los peones
				else if(filas == 6) {
					
					for (columnas = 0; columnas < tablero.length; columnas++) {
						tablero[filas][columnas] = new Ficha("blancas", "P");
					}
				}
				//Llenaremos las fichas blancas como antes, pero cambiando el numero de fila y los atributos de las mismas
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
					//En todas las otras premisas, este será el objeto que se pondrá en el tablero
					tablero[filas][columnas] = new Ficha("empty","*");
				}
			}
		}
		//Mostramos tablero
		showTablero();
		
	}
		
		
	
	//Mètodo para mostrar tablero, simplemente.
	public void showTablero () {
		
		int contador = 0;
		for (int filas = 0; filas < tablero.length; filas++) {
			for (int columnas = 0; columnas < tablero.length; columnas++) {
				System.out.print(tablero[filas][columnas].letra + " ");
				
				//Aquí dentro también iremos contando los reyes, para saber el ganador
				if (tablero[filas][columnas].letra.equals("k")) {
					contador++;
					this.reyes = contador;
					this.colorRei1 = tablero[filas][columnas].letra;
				}
				if (tablero[filas][columnas].letra.equals("K")) {
					contador++;
					this.reyes = contador;
					this.colorRei2 = tablero[filas][columnas].letra;
				}
				
			}
			System.out.println("");
		}
		
	}
	
	public boolean movimiento (int antigaX, int antigaY, int x, int y,int turno) {
		
	
		//Depende de los turnos, si no se coge la ficha indicada, retornamos falso, para repetir el paso
		if (turno == 1 && !tablero[antigaX][antigaY].color.equalsIgnoreCase("blancas")) {
			System.out.println("Malament, has de escollir les teves fitxes");
			showTablero();
			return false;
			
		}
		//Depende de los turnos, si no se coge la ficha indicada, retornamos falso, para repetir el paso
		else if (turno != 1 && !tablero[antigaX][antigaY].color.equalsIgnoreCase("negro")) {
			System.out.println("Malament, has de escollir les teves fitxes");
			showTablero();
			return false;
		}
		
		//Aquí en este metodo veremos si los dos mètodos son correctos, las comprobaciones idoneas
		else if (tablero[antigaX][antigaY].posibleMoviment(tablero,antigaX, antigaY, x, y) && sePuedeMover(antigaX, antigaY, x, y)) {
		
			//Si las fichas indicadas son del mismo color, retornamos falso
			if (tablero[antigaX][antigaY].color.equalsIgnoreCase(tablero[x][y].color)) {
				
				System.out.println("No puedes moverla ahí, el color es el mismo al de la ficha");
				showTablero();
				return false;
			}
			
			
			//En el caso que no se cumpla el anterior, cambiamos las dos posiciones, intercambiamos todos los atributos
			else {
			tablero[x][y].color = tablero[antigaX][antigaY].color;
			tablero[x][y].letra = tablero[antigaX][antigaY].letra;	
		
			tablero[antigaX][antigaY].color = "empty";
			tablero[antigaX][antigaY].letra = "*";
			}
	
		}
		//Si la comprobacion de los dos pasos ha sido incorrecta, retornamos el debido boolean y enseñamos el tablero
		else {
		
			showTablero();
			return false;
		}
		showTablero();
		return true;
	}
	
	
	public boolean sePuedeMover(int antigaX, int antigaY, int x, int y) {
	    
		
		if (antigaX == x && antigaY > y) {
			//Això significa que es mou a la esquerra
			//Es va restant la i, comenc                             ESQUERRA
			for (int i = antigaY - 1; i > y; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	              
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
	            	            	
	            	return false;
	               
	            }
	        }
	    } 
		
		//Fila és més gran, columna igual
		//Això vol dir que anem cap amunt                             AMUNT
		else if (antigaX > x && antigaY == y) { // horizontal west
	        for (int i = antigaX - 1; i > x; i--) {
	            if (!tablero[i][antigaX].letra.equalsIgnoreCase("*")) {
	            	
	                return false;
	            }
	        }
	    }
		
		//Diagonal hacia abajo derecha
		else if (antigaX < x && antigaY < y) {
			for (int i = antigaX +1; i < x; i++) {
				antigaY++;
				 if (!tablero[i][antigaY].letra.equalsIgnoreCase("*")) {
					 
		            	System.out.println("hola");
		                return false;
		            }
			}
		}
		
		//Diagonal hacia abajo izquierda
	
		else if (antigaX < x && antigaY > y) {
			for (int i = antigaX +1; i < x; i++) {
				antigaY--;
				 if (!tablero[i][antigaY].letra.equalsIgnoreCase("*")) {
					 
		            	
		                return false;
		          }
			}
		}
		
		else if (antigaX > x && antigaY < y) {
			for (int i = antigaX - 1; i > x; i--) {
				antigaY++;
				 if (!tablero[i][antigaY].letra.equalsIgnoreCase("*")) {
					 
		            	
		                return false;
		          }
			}
		}
		
		else if (antigaX > x && antigaY > y) {
			for (int i = antigaX - 1; i > x; i--) {
				antigaY--;
				 if (!tablero[i][antigaY].letra.equalsIgnoreCase("*")) {
					 
		            	
		                return false;
		          }
			}
		}
		
		return true;

	}
	
	//Funcion final del juego
	public boolean end (Tablero tablero, int turno) {
		
		//Si no hay 2 reyes entramos al bucle para ver quien gana
		if (tablero.reyes != 2) {
			
			//Si el turno es uno, porque no llega a resetearse indicamos los ganadores cruzados 1.negras 2.blancas
			if (turno == 1) {
				System.out.println("Han ganado las negras");
			}
			else {
				System.out.println("Han ganado las blancas");
			}
			return true;
		}
		return false;
		
	}
}
