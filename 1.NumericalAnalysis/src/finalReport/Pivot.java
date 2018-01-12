package finalReport;

import mathlib.GaussianElimination;
import mathlib.LinearCondition;
import mathlib.Matrix;
import mathlib.Vector;

public class Pivot extends LinearCondition {

	public static void main(String[] args) {

		//		System.out.printf("residual, pivotResidual%n");

		normNumber = 2;
		isAbsolute = true;

		n = 500; // size
		int maxK = 100;
		double residual;

		double[][] aData = new double[n][n];
		double[] bData = new double[n];

		for (int k = 1; k <= maxK; k++) {
			// ランダムデータの作成
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					aData[i][j] = Math.random();
				}
				bData[i] = Math.random();
			}

			a = new Matrix(aData);
			b = new Vector(bData);

			Vector x = GaussianElimination.pivotSolve();
			//			Vector pivotX = GaussianElimination.pivotSolve();

			residual = x.getResidual(isAbsolute, normNumber, a, b);
			//			pivotResidual = pivotX.getResidual(isAbsolute, normNumber, a, b);
			System.out.printf("%d, %.10e%n", k, residual);
		}
	}
}
