package gaussianElimination;

import mathlib.Matrix;
import mathlib.Vector;

public class GaussianEliminationByMatrix {

	public static void main(String[] args) {
		int n = 5;
		Matrix a = new Matrix(n);
		a.hilbertPlus1();
		Vector b = new Vector(n);
		b.allNumber(1);
		Matrix a2 = a.copy();
		Vector b2 = b.copy();

		// 1
		a2.forwardElimination(a2, b2);
		a2.printf("a");
		b2.printf("b");

		// 2
		Vector x = a.gaussianElimination(a, b);
		x.printf("x");

		// 3
		Vector xAsterisk = new Vector(n);
		xAsterisk.allNumber(1);
		Vector bAsterisk = a.multiply(a, xAsterisk);
		bAsterisk.printf("bAsterisk");

		// 4
		Vector bDelta = new Vector(n);
		bDelta.getData()[0] = 1e-3 * b.getData()[0];
		Vector b1 = b.add(bAsterisk, bDelta);
		Vector x1 = a.gaussianElimination(a, b1);
		x1.printf("x1");

		// 5
		System.out.printf("bNorm = %.3e\n", bDelta.getInfinityNorm() / bAsterisk.getInfinityNorm());
		System.out.printf("error = %.3e\n", x1.getRelativeErrorOfInfinityNorm(xAsterisk));

	}
}
