package gaussianElimination;

import myBLAS.Calc;

public class GaussianEliminationSample {
	public static void main(String[] args) {
		double[][] a = { { 1, 2, 1, 2, 1 }, { 2, 3, 2, 3, 2 }, { 1, 2, 3, 4, 5 }, { 4, 3, 8, 1, 2 },
				{ 8, 2, 4, 1, 9 } };
		double[] b = { 7, 7, 7, 7, 7 };
		int n = a.length;
		double alpha = 0.0;

		// 前進消去過程
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] += -alpha * a[k][j];
				}
				b[i] += -alpha * b[k];
			}
		}

		// 後退代入過程
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				b[k] += -a[k][j] * b[j];
			}
			b[k] /= a[k][k];
		}

		System.out.println("A = ");
		Calc.printMat(a);
	}


}
