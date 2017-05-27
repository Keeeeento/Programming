package chapter15UnitMatrix;

public class Exec2 {
	// 100×100の単位行列を表す二次元配列を作成し、出力するプログラムを組め
	public static void main(String[] args) {
		int n = 100;
		double[][] matrix = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					matrix[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%.1f", matrix[i][j]);
			}
			System.out.println();
		}

	}

}
