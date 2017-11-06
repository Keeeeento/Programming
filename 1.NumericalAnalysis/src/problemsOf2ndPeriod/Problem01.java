package problemsOf2ndPeriod;

import mathlib.Matrix;

public class Problem01 {

	public static void main(String[] args) {
		int n = 4;

		Matrix t;

		for (int a = 1; a <= 4; a++) {
			t = Matrix.symmetricBand(n, 0.0, 1.0 / a, 1.0 / a);
			t.setEpsilon(1e-08);
			t.setMax_iteration(2000);
			int iteration = t.getIterationOfSpectralRedius();
			double lambda = t.getSpectralRadius();
			System.out.printf("a = %d, N = %d, λ = %.8f%n", a, iteration, lambda);
		}

	}

}
