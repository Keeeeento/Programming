package report;

import mathlib.GaussianElimination;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class Hilbert {
	public static void main(String[] args) {
		int n = 10;
		Matrix a = new Matrix(n);
		Vector x = new Vector(n);
		x.allNumber(1);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a.getData()[i - 1][j - 1] = (i == j) ? 100 : -1;
			}
		}

		a.print("a");

		System.out.println(a.isDiagonalDominant());
		System.out.println(a.isPrincipalMinorDeterminant());

		// 1
		Vector b = a.multiply(a, x);
		b.printf("b");

		// 2
		Vector x1 = GaussianElimination.solve(a, b);
		x1.printf("x1");

		double errorNorm1 = x1.getRelativeErrorOfOneNorm(x);
		System.out.printf("errorNorm1 = %.3e\n", errorNorm1);

		// 3
		Vector x2 = GaussianElimination.pivotSolve(a, b);
		x2.printf("x2");

		double errorNorm2 = x2.getRelativeErrorOfOneNorm(x);
		System.out.printf("errorNorm2 = %.3e\n", errorNorm2);

		Vector x3 = Jacobi.solve(a, b);
		x3.print("x3");
		// 4
		double condition = a.getConditionNumberOfOneNorm();
		System.out.printf("κ1(A) = %.3e\n", condition);

		// 5
		Vector bTilde = b.deltaAddedVector();
		bTilde.printf("bTilde");

		Vector xTilde = GaussianElimination.pivotSolve(a, bTilde);
		xTilde.printf("xTilde");
		double errorNorm3 = xTilde.getRelativeErrorOfOneNorm(x);
		System.out.printf("errorNorm3 = %.3e\n", errorNorm3);

		double residualNorm = xTilde.getRelativeResidualOfOneNorm(a, b);
		System.out.printf("residualNorm = %.3e\n", residualNorm);
	}

}
