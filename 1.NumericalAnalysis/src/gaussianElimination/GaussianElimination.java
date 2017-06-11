package gaussianElimination;

import myBLAS.Calculation;

public class GaussianElimination {

	// A =
	// 5.000e-01 3.333e-01 2.500e-01 2.000e-01 1.667e-01
	// 0.000e+00 2.778e-02 3.333e-02 3.333e-02 3.175e-02
	// 0.000e+00 0.000e+00 1.667e-03 2.857e-03 3.571e-03
	// 0.000e+00 0.000e+00 0.000e+00 1.020e-04 2.268e-04
	// 0.000e+00 0.000e+00 0.000e+00 0.000e+00 6.299e-06
	//
	// b =
	// 1.000e+00 3.333e-01 1.000e-01 2.857e-02 7.937e-03

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
		Calculation.printe(a, 3);

		System.out.println("b = ");
		Calculation.printe(b, 3);

	}
}
