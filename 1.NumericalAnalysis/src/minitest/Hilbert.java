package minitest;

import myBLAS.Calculation;

public class Hilbert {
	public static void main(String[] args) {
		int n = 6;
		double[][] a = new double[n][n];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j);
			}
		}
		// (1)
		System.out.println("(1)");
		double cond = Calculation.infinityNorm(a) * Calculation.infinityNorm(Calculation.Inverse(a));
		System.out.printf("cond = %.2e\n", cond);

		// (2)
		System.out.println("(2)");
		double[] x = { 1, 1, 1, 1, 1, 1 };
		double[] b = Calculation.multiple(a, x);

		System.out.println("b = ");
		Calculation.printe(b, 2);

		double[] x1 = Calculation.gaussianElimination(a, b);
		System.out.println("x1 = ");
		Calculation.printe(x1, 2);

		double residual = Calculation.infinityNorm(Calculation.sub(b, Calculation.multiple(a, x1)))
				/ Calculation.infinityNorm(b);
		System.out.printf("residual = %.2e\n",residual);

		double norm = Calculation.infinityNorm(Calculation.sub(x, x1)) / Calculation.infinityNorm(x);
		System.out.printf("norm = %.2e",norm);
		

	}
}
