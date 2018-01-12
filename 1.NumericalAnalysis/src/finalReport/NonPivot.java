package finalReport;

import mathlib.GaussianElimination;
import mathlib.LinearCondition;
import mathlib.Matrix;
import mathlib.Vector;

public class NonPivot extends LinearCondition {

	public static void main(String[] args) {

		//		System.out.printf("residual, pivotResidual%n");

		// 収束判定条件
		normNumber = 2;
		isAbsolute = true;

		n = 500; // size
		int maxI = 100;
		double residual;

		double[][][] aDatas = new double[maxI][n][n];
		double[][] bDatas = new double[maxI][n];

		for (int i = 0; i < maxI; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					aDatas[i][j][k] = Math.random();
				}
				bDatas[i][j] = Math.random();
			}
		}

		// NonPivot
		for (int i = 0; i < maxI; i++) {

			a = new Matrix(aDatas[i]);
			b = new Vector(bDatas[i]);

			Vector x = GaussianElimination.solve();

			residual = x.getResidual(isAbsolute, normNumber, a, b);
			System.out.printf("%d, %.10e%n", i + 1, residual);
		}

		System.out.println();

		// Pivot
		for (int i = 0; i < maxI; i++) {

			a = new Matrix(aDatas[i]);
			b = new Vector(bDatas[i]);

			Vector x = GaussianElimination.pivotSolve();

			residual = x.getResidual(isAbsolute, normNumber, a, b);
			System.out.printf("%d, %.10e%n", i + 1, residual);
		}

	}
}
