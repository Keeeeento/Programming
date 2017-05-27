package exercise10;

public class MatrixAndVector {

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 3, 4 }, { -2, 1 } };
		int[][] b = { { 2, 5 }, { 3, 4 } };

		int[][] c = productM(a, b);

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.printf(c[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int[] productV(int[][] a, int[] x) {

		int[] y = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				y[i] += a[i][j] * x[i];
			}
		}
		return y;
	}

	public static int[][] sum(int[][] a, int[][] b) {

		int[][] c = new int[a.length][a[0].length];
		if (a.length == b.length && a[0].length == b[0].length) {

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					c[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return c;

	}

	public static int[][] productM(int[][] a, int[][] b) {

		int[][] c = new int[a.length][b[0].length];
		if (a[0].length == b.length) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					for (int k = 0; k < b.length; k++) {
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
		}
		return c;
	}

	// コンソールへの行列の出力
	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		return;
	}
}
