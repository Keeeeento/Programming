package report;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class StationaryIterativeMethod {
	public static void main(String[] args) {
		int n = 100;
		double[][] aData = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					aData[i][j] = 2;
				} else if (Math.abs(i - j) == 1) {
					aData[i][j] = -1;
				}
			}
		}
		Matrix a = new Matrix(aData);

		double[] bData = new double[n];
		for (int i = 0; i < n; i++) {
			bData[i] = 1;
		}
		Vector b = new Vector(bData);

		long start = System.nanoTime();
		Jacobi.solve(a, b);
		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

		start = System.nanoTime();
		GaussSeidel.solve(a, b);
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

	}

}
