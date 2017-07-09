package report;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class StationaryIterativeMethod2 {
	public static void main(String[] args) {
		int n = 10;
		double[][] aData = new double[n][n];
		for (int i = 0; i < n; i++) {
			aData[i][i] = 2 * i * i + 1;
			for (int j = 0; j < n; j++) {
				if (Math.abs(i - j) == 1) {
					aData[i][j] = i + 1;
				}
			}
		}
		Matrix a = new Matrix(aData);
		a.print("a");
		double[] bData = new double[n];
		for (int i = 0; i < n; i++) {
			bData[i] = 1100;
		}
		Vector b = new Vector(bData);

		long start, end;

		start = System.nanoTime();
		Jacobi.solveWithSum(a, b).print("Jacobi");
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

		System.out.println();

		start = System.nanoTime();
		Jacobi.solve(a, b).print("acobi2");
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

		System.out.println();

		start = System.nanoTime();
		GaussSeidel.solve(a, b).print("GaussSeidel");
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

	}

}
