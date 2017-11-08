package problemsOf2ndPeriod;

import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.Vector;

public final class Problem01 {
	public static void main(String[] args) {

		int n = 4;
		double epsilon = 1e-08;
		int max_iteration = 2000;
		double norm_number = 2;
		boolean is_absolute = true;

		SpectralRadius sr = new SpectralRadius(epsilon, max_iteration, norm_number, is_absolute);
		sr.setX0(Vector.allNumber(n, 1.0));

		for (int a = 1; a <= 4; a++) {
			sr.setMarix(Matrix.symmetricBand(n, 0.0, 1.0 / a, 1.0 / a));
			int iteration = sr.getIteration();
			double lambda = sr.getSpectralRadius();
			System.out.printf("a = %d, N = %d, λ = %.8f%n", a, iteration, lambda);
		}

	}
}