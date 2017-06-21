package inverseMatrix;

import myBLAS.Calculation;

public class InverseMatrix {

	// n = 4 のとき
	// κ∞(A) = 2.8375000000e+04
	// residualNorm = 0.0000000000e+00
	// errorNorm = 5.0000000000e-01
	//
	// n = 8 のとき
	// κ∞(A) = 3.3872791483e+10
	// residualNorm = 1.9317880628e-14
	// errorNorm = 7.8352561587e+02
	//
	// n = 12 のとき
	// κ∞(A) = 3.8226213319e+16
	// residualNorm = 1.3411716182e-11
	// errorNorm = 9.5372986356e+05

	public static void main(String[] args) {
		for (int n = 4; n <= 12; n += 4) {
			System.out.println("n = " + n + " のとき");
			double[][] a = new double[n][n];
			double[] x = new double[n];
			double[] b = new double[n];
			double[] bDelta = new double[n];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					a[i - 1][j - 1] = 1.0 / (i + j - 1);
				}
			}
			// (1)
			double cond = Calculation.infinityNorm(a) * Calculation.infinityNorm(Calculation.Inverse(a));
			System.out.printf("κ∞(A) = %.10e\n", cond);

			// (2)
			Calculation.allNumber(x, 1);
			b = Calculation.multiple(a, x);
			bDelta[0] = 1e-03 * b[0];
			double[] b1 = Calculation.add(b, bDelta);
			double[] x1 = Calculation.solveByLUDecomposition(a, b1);

			double residualNorm = Calculation.infinityNorm(Calculation.sub(b1, Calculation.multiple(a, x1)));
			double errorNorm = Calculation.infinityNorm(Calculation.sub(x, x1));

			System.out.printf("residualNorm = %.10e \n", residualNorm);
			System.out.printf("errorNorm = %.10e \n", errorNorm);
			System.out.println();

		}
	}

}
