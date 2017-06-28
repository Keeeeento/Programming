package pivotGaussianElimination;

import mathlib.Matrix;
import mathlib.Vector;

public class PivotGaussianElimination {
	// (1)
	// κ1(A) = 3.387e+10
	// (2)
	// x1 =
	// 1.174e+00 -4.479e+00 5.579e+01 -2.501e+02 6.037e+02 -7.825e+02 5.234e+02
	// -1.389e+02
	// (3)
	// x.error = 2.950e+02
	// (4)
	// κ1(A) * b.error = 8.680e+06
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
