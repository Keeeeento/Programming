package report;

import mathlib.GaussSeidel;
import mathlib.GaussianElimination;
import mathlib.Jacobi;
import mathlib.LUDecomposition;
import mathlib.Matrix;
import mathlib.Vector;

public class StationaryIterativeMethod {
	public static void main(String[] args) {
		long start = System.nanoTime();
		int n = 10;
		double[][] aData = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (Math.abs(i - j)) {
				case 0:
					aData[i][j] = 2;
					break;
				case 1:
					aData[i][j] = 1;
					break;
				case 2:
					aData[i][j] = 0;
					break;
				default:
					break;
				}
			}
		}
		Matrix a = new Matrix(aData);
		a.print("A");
		System.out.println("κ1(A) = " + a.getConditionNumberOfOneNorm());
		System.out.println("κ∞(A) = " + a.getConditionNumberOfInfinityNorm());

		// Vector x = new Vector(new double[] { 0.5, 4.5,7.5, 9.5, 10.5, 10.5,
		// 9.5, 7.5, 4.5, 0.5 });
		Vector x = new Vector(n);
		x.allNumber(1);

		// double[] bData = new double[n];
		// for (int i = 0; i < n; i++) {
		// bData[i] = 1;
		// }
		// Vector b = new Vector(bData);
		Vector b = new Vector(n);

		System.out.println("-Gaussian Elimination-");
		b = a.multiply(a, x);
		Vector x1 = GaussianElimination.solve(a, b);
		System.out.println("relativeErrorOne = " + x1.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeErrorInf = " + x1.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteErrorOne = " + x1.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteErrorInf = " + x1.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println("residualOne = " + x1.getAbsoluteResidualOfOneNorm(a, b));
		System.out.println("residualInf = " + x1.getAbsoluteResidualOfInfinityNorm(a, b));
		System.out.println();

		System.out.println("-Pivod Gaussian Elimination-");
		b = a.multiply(a, x);
		Vector x2 = GaussianElimination.pivotSolve(a, b);
		System.out.println("relativeErrorOne = " + x2.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeErrorInf = " + x2.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteErrorOne = " + x2.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteErrorInf = " + x2.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println("residualOne = " + x2.getAbsoluteResidualOfOneNorm(a, b));
		System.out.println("residualInf = " + x2.getAbsoluteResidualOfInfinityNorm(a, b));
		System.out.println();
		System.out.println("-LU Decomposition-");
		b = a.multiply(a, x);
		Vector x3 = LUDecomposition.solve(a, b);
		System.out.println("relativeError3one = " + x3.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError3inf = " + x3.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError3one = " + x3.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError3inf = " + x3.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Jacobi-");
		b = a.multiply(x);
		Vector x4 = Jacobi.solveWithOneNorm(a, b);
		System.out.println("relativeError4one = " + x4.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError4inf = " + x4.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError4one = " + x4.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError4inf = " + x4.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Gauss Seidel-");
		b = a.multiply(x);
		Vector x5 = GaussSeidel.solveWithOneNorm(a, b);
		System.out.println("relativeError5one = " + x5.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError5inf = " + x5.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError5one = " + x5.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError5inf = " + x5.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

	}

}
