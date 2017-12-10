package inverseMatrix;

import myBLAS.Calculation;

public class PivotGaussianElimination {
	public static void main(String[] args) {
		int n = 8;
		double[][] a = new double[n][n];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j - 1);
			}
		}
		// (1)
		double cond = Calculation.manhattanNorm(a) * Calculation.manhattanNorm(Calculation.Inverse(a));
		System.out.printf("cond = %.3e\n", cond);

		// (2)
		double[] x = Calculation.allNumber(n, 1);
		double[] b = Calculation.multiple(a, x);
		double[] bDelta = new double[n];
		double[] b1 = Calculation.add(b, bDelta);

		bDelta[0] = 1e-3 * b[0];

		double[] x1 = Calculation.pivotGaussianElimination(a, b1);
		System.out.println("x1 = ");
		Calculation.printe(x1, 3);

	}
}
