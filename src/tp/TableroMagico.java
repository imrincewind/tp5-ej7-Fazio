package tp;



public class TableroMagico {
	private static final int S = 15;//23
	private static final int K = 9;//13
	private static final int N = 3;//3

	public static void main(String[] args) {
		int[][] tablero = new int[N][N];
	
		
		tablero = resolver(tablero);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(tablero[i][j] + "-");
			}
			System.out.println();
		}
	

	}

	public static int[][] resolver(int[][] tablero) {
		int[] candidatos = new int[K]; //para no repetir números y mejorar tiempos de ejecución
		for (int i = 0; i < K; i++) {
				candidatos[i] = i+1;	
		}
		tablero = backMagico(tablero,candidatos, 0);

		return tablero;
	}

	private static int[][] backMagico(int[][] tablero, int[] candidatos, int nivel) {
		if (nivel == (N * N) - 1 && esSolucion(tablero)) {

			return tablero;

		} else if(nivel < (N * N)){
			
				for (int i = 0; i < K; i++) {
					
					int temp = 0;
					if(candidatos[i] != 0){
						temp = candidatos[i];
						candidatos[i] = 0;
					tablero[nivel / N][nivel % N] = temp;
					
					}
					int[][] sol = backMagico(tablero,candidatos, nivel + 1);
					candidatos[i] = temp;
					if (sol != null) {
						return sol;
					}
				}
			}
	
		

		return null;
	}

	private static boolean esSolucion(int[][] tablero) {
		return sumas(tablero);
	}

	


	private static boolean sumas(int[][] tablero) {

		for (int i = 0; i < N; i++) {
			int suma = 0;
			for (int j = 0; j < tablero.length; j++) {
				suma += tablero[i][j]; // sumamos las filas
			}
			if (suma != S) {
				return false;
			}
		}
		for (int i = 0; i < N; i++) {
			int suma = 0;
			for (int j = 0; j < tablero.length; j++) {
				suma += tablero[j][i]; // sumamos las columnas
			}
			if (suma != S) {
				return false;
			}
		}

		return true;
	}

}
