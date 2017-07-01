package pivotGaussianElimination;

import mathlib.Matrix;
import mathlib.Vector;

public class PivotGaussianElimination {
	public static void main(String[] args) {
		int n = 8;

		Matrix a = new Matrix(n);
		a.hilbert();

		// (1)
		System.out.println("(1)");
		double cond = a.getOneConditionNumber();
		System.out.printf("κ1(A) = %.3e\n", cond);

		// (2)
		System.out.println("(2)");
		Vector x = new Vector(n);
		x.allNumber(1);
		Vector b = new Vector(n);
		b = a.multiply(a, x);
		Vector bDelta = new Vector(n);
		bDelta.getData()[0] = 1e-3 * b.getData()[0];
		Vector b1 = b.add(b, bDelta);

		Vector x1 = a.pivotGaussianElimination(a, b1);
		x1.printf("x1");

		// (3)
		System.out.println("(3)");
		System.out.printf("x.error = %.3e\n", x1.getRelativeErrorOfOneNorm(x));

		// (4)
		System.out.println("(4)");
		System.out.printf("κ1(A) * b.error = %.3e\n", cond * b1.getRelativeErrorOfOneNorm(b));

	}

}
