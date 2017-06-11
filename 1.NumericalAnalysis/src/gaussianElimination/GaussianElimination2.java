package gaussianElimination;

import myBLAS.Calculation;

public class GaussianElimination2 {

	// x =
	// 3.000e+01 -4.200e+02 1.680e+03 -2.520e+03 1.260e+03

	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] x = new double[n];
		double[] b = new double[n];

		for (int i = 1; i <= n; i++) { // 行列 A_{n,n} = a の作成
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j);
			}
		}

		for (int i = 0; i < n; i++) { // ベクトルbの作成
			b[i] = 1;
		}

		x = Calculation.gaussianElimination(a, b);
		System.out.println("x = ");
		Calculation.printe(x, 3);
	}
}
