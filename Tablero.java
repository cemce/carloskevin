public class Tablero {
	
	int filas;
	int columnas;
	String[][] tablero;
	
	Tablero () {
		
		this.filas = 9;
		this.columnas = 9;
		this.tablero = new String[filas][columnas];
		
		llenarTablero(tablero);
		}
	
	public void llenarTablero (String[][] tablero) {
		
		
		String[] letras = {"/","A","B","C","D","E","F","G","H"};
		String[] numeros = {"/","1","2","3","4","5","6","7","8"};
		
		
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
				
				tablero[i][j] = "i";
				
		
	}
}
	
		for (int i = 0; i < numeros.length; i++) {
			tablero[0][i] = letras[i];
		}
		for (int i = 0; i < numeros.length; i++) {
			tablero[i][0] = numeros[i];
		}
		
		
}
		
	
	public void showTablero () {
		
	
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
			
				System.out.print(tablero[i][j]+ " ");
			}
			System.out.println("");
		}
	}
}
