package report;

import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class Pattern1 {
	public static void main(String[] args) {
		int n = 10;
		while (true) {
			Matrix a = Matrix.random(n);
			Vector x = Vector.allNumber(n, 1);
			Vector b = a.multiply(x);

			if (Jacobi.getIteration(a, b) != 0) {
				a.print("a");
				System.out.println(Jacobi.solveWithOneNorm(a, b));
				break;
			}
		}
		// for (int n = 100; n <= 200; n += 10) {
		// Matrix a = new Matrix(n);
		// a.symmetricBand(100, 2, 1);
		// Vector x = new Vector(n);
		// x.allNumber(1);
		// Vector b = new Vector(n);
		// b = a.multiply(x);
		// System.out.printf("%d , %d , %.0f\n", n, Jacobi.getOperation(a, b),
		// GaussSeidel.getOperation(a, b));
		// }
		// for (int n = 200; n <= 3000; n += 100) {
		// Matrix a = new Matrix(n);
		// a.symmetricBand(100, 2, 1);
		// Vector x = new Vector(n);
		// x.allNumber(1);
		// Vector b = new Vector(n);
		// b = a.multiply(x);
		// System.out.printf("%d , %d , %.0f\n", n, Jacobi.getOperation(a, b),
		// GaussSeidel.getOperation(a, b));
		// }

	}

}
