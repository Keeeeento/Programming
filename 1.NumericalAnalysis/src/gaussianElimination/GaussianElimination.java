package gaussianElimination;

import myBLAS.Calculation;

public class GaussianElimination {
	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] b = new double[n];

		// 行列 A_{n,n} = a の作成
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j);
			}
		}

		// ベクトルbの作成
		for (int i = 0; i < n; i++) {
			b[i] = 1;
		}

		Calculation.forwardElimination(a, b);

		System.out.println("A = ");
		Calculation.printf(a, 3);

		System.out.println("b = ");
		Calculation.printf(b, 3);

	}
}
