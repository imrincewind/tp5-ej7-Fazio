package tp;



public class TableroMagico {
	private static final int S = 2;
	private static final int K = 2;
	private static final int N = 2;

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
		
		tablero = backMagico(tablero, 0, 0, 1);

		return tablero;
	}

	private static int[][] backMagico(int[][] tablero, int nivel, int nivelI, int j) {
		if (nivel == N - 1 && nivelI == N -1 ) {
			if (esSolucion(tablero)) {
				return tablero;
			}
		} else {
			for (int i = 0; i < N; i++) {
				while (j < K && nivel < N) {
					tablero[nivel][i] = j;
					int[][] sol = backMagico(tablero, nivel+1,i , j + 1);
					if (i == N - 1 && nivel < N) {
						//i = 0;
						sol = backMagico(tablero, nivel + 1,i, j + 1);
					}
					if (sol != null) {
						return sol;
					}
				}
			}

		}

		return null;
	}

	private static boolean esSolucion(int[][] tablero) {
		return numerosDistintos(tablero) && sumas(tablero);
	}

	private static boolean numerosDistintos(int[][] tablero) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp = tablero[i][j];
				for (int g = i; i < N; g++) {
					for (int h = j + 1; j < N; h++) {
						if (temp == tablero[g][h]) {
							return false;
						}
					}

				}
			}
		}
		return true;
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
