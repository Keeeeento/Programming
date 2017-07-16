package report;

import mathlib.GaussSeidel;
import mathlib.GaussianElimination;
import mathlib.Jacobi;
import mathlib.LUDecomposition;
import mathlib.Matrix;
import mathlib.Vector;

public class Pattern1 {
	public static void main(String[] args) {
		int n = 1000;
		int normNumber = 1;
		Matrix a = Matrix.symmetricBand(n, 10, 2, 1);
		// a.printInt("a");
		Vector xExact = Vector.allNumber(n, 2);
		Vector b = a.multiply(xExact);

		Jacobi.solveAndShowError(a, b, xExact, normNumber);

		GaussSeidel.solveAndShowError(a, b, xExact, normNumber);

		System.out.println("GaussianElimination");
		System.out.println(GaussianElimination.solve(a, b).getRelativeError(normNumber, xExact));

		System.out.println("LUDecomposition");
		System.out.println(LUDecomposition.solve(a, b).getRelativeError(normNumber, xExact));

		System.out.println("PivotGaussianElimination");
		System.out.println(GaussianElimination.pivotSolve(a, b).getRelativeError(normNumber, xExact));

	}

}
