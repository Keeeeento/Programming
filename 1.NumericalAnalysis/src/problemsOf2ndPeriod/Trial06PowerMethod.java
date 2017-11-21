package problemsOf2ndPeriod;

import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.Vector;

public final class Trial06PowerMethod extends SpectralRadius {
	public static void main(String[] args) {

		// 収束判定条件
		n = 4;
		epsilon = 1e-08;
		maxIteration = 2000;

		Matrix a = new Matrix(n);
		final Vector x0 = Vector.allNumber(n, 1); // 冪乗法の初期ベクトル

		for (int alpha = 1; alpha <= 4; alpha++) {
			a.symmetricBand(0.0, 1.0 / alpha, 1.0 / alpha);
			int iteration = SpectralRadius.getIterationByRayleigh(a, x0);
			double lambda = SpectralRadius.getSpectralRadiusByRayleigh(a, x0);
			System.out.printf("a = %d, N = %d, λ = %.8f%n", alpha, iteration, lambda);
		}

	}
}