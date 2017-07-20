package report;

import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class PatternA {
	public static void main(String[] args) {
		int n = 100;
		int normNumber = 1;

		System.out.println("ρ(T), Jacobi, GaussSeidel");

		double k = 6.0189;
		while (true) {

			Matrix a = Matrix.symmetricBand(n, k, 2, 1);
			// a.printInt("a");
			Vector xExact = Vector.allNumber(n, 2);
			Vector b = a.multiply(xExact);

			// GaussSeidel.solveAndShowError(normNumber, a, b, xExact);
			// System.out.println("k = " + k);
			System.out.printf("%.3e, %d\n", Jacobi.IterativeMatrixOf(a).getSpectralRadius(),
					Jacobi.getIterationNumber(normNumber, a, b, xExact));
			if (k < 8) {
				k += 0.01;

			} else if (k < 10) {
				k += 0.1;
			} else if (k < 100) {
				k++;
			} else if (k < 1000) {
				k += 10;
			} else if (k < 10000) {
				k += 100;
			}

			if (k > 10000) {
				break;
			}
		}

		// for (k = 6.0189; k < 10; k += 0.01)
		//
		// {
		//
		// Matrix a = Matrix.symmetricBand(n, k, 2, 1);
		// // a.printInt("a");
		// Vector xExact = Vector.allNumber(n, 2);
		// Vector b = a.multiply(xExact);
		//
		// // GaussSeidel.solveAndShowError(normNumber, a, b, xExact);
		// System.out.println("i = " + k);
		// System.out.printf("%.3e, %d, %d\n",
		// a.getIterativeMatrix().getSpectralRadius(),
		// Jacobi.getIterationNumber(normNumber, a, b, xExact),
		// GaussSeidel.getIterationNumber(normNumber, a, b, xExact));
		// }
	}

}
