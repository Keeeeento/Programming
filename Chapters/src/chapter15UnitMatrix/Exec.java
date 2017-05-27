package chapter15UnitMatrix;

public class Exec {
	// 100×100の単位行列を表す二次元配列を作成し、出力するプログラムを組め
	public static void main(String[] args) {
		double[][] matrix = new double[100][100];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					matrix[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
