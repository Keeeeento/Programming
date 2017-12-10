package midTermTestOf1stPeriod;

import mathlib.GaussianEliminationOld;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem4A {
	public static void main(String[] args) {
		int n = 6;
		Matrix a = new Matrix(n);
		Vector x = new Vector(n);
		x.allNumber(1);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a.getData()[i - 1][j - 1] = 0.1 / (i + j - 1) + (i - j);
			}
		}

		a.print("a");
		// 1
		Vector b = a.multiply(a, x);
		b.printf("b");

		// 2
		Vector x1 = GaussianEliminationOld.solve(a, b);
		x1.printf("x1");

		double errorNorm1 = x1.getRelativeErrorOfInfinityNorm(x);
		System.out.printf("errorNorm1 = %.3e\n", errorNorm1);

		// 3
		Vector x2 = GaussianEliminationOld.pivotSolve(a, b);
		x2.printf("x2");

		double errorNorm2 = x2.getRelativeErrorOfInfinityNorm(x);
		System.out.printf("errorNorm2 = %.3e\n", errorNorm2);

		// 4
		double condition = a.getConditionNumber(0);
		System.out.printf("κ∞(A) = %.3e\n", condition);

		// 5
		Vector bTilde = b.deltaAddedVector();
		bTilde.printf("bTilde");

		Vector xTilde = GaussianEliminationOld.pivotSolve(a, bTilde);
		xTilde.printf("xTilde");
		double errorNorm3 = xTilde.getRelativeErrorOfInfinityNorm(x);
		System.out.printf("errorNorm3 = %.3e\n", errorNorm3);

		double residualNorm = xTilde.getRelativeResidualOfInfinityNorm(a, b);
		System.out.printf("residualNorm = %.3e\n", residualNorm);

	}
}
