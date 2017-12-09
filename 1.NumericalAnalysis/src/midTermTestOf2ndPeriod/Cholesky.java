package midTermTestOf2ndPeriod;

import mathlib.CholeskyDecomposition;
import mathlib.LinearCondition;
import mathlib.Matrix;
import mathlib.Vector;

public class Cholesky extends LinearCondition {

	public static void main(String[] args) {

		n = 5;
		a = Matrix.symmetricBand(n, 4.0, -1.0, -1.0);

		Matrix l = CholeskyDecomposition.getL(a);
		l.printf("l");
		l.multiply(l.transpose()).print("a");

		Vector b = Vector.allNumber(n, 1.0);
		CholeskyDecomposition.solve(a, b).print("x");
		//		GaussianEliminationOld.solve(a, b).printInt("x");

	}

	//	public static void rayleighQuotient(double[][] a, double[] x0) {
	//
	//		int n = a.length;
	//		final int NORM_NUMBER = 2;
	//		double lambda = 0.0;
	//		double lambdaOld = 0.0;
	//		int maxIteration = 1000; // 最大反復回数
	//		double[] x = new double[n];
	//		double[] x_old = new double[n];
	//
	//		int i;
	//		for (i = 1; i <= maxIteration; i++) {
	//
	//			// ベクトルの正規化
	//			x_old = x_old.scalarMultiply(1.0 / x_old.getNorm(NORM_NUMBER));
	//
	//			// レイリーによる計算
	//			x = a.multiply(x_old);
	//			lambda = Vector.innerProduct(x, a.multiply(x)) / Vector.innerProduct(x, x);
	//
	//			if (Math.abs(lambda - lambdaOld) / Math.abs(lambda) < epsilon) {
	//				break;
	//			}
	//			lambdaOld = lambda;
	//		}
	//	}
}
