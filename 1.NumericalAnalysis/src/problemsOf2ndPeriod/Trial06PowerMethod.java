package problemsOf2ndPeriod;

import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.Vector;

public final class Trial06PowerMethod extends SpectralRadius {
	public static void main(String[] args) {

		/*
		 * 冪乗法を用いて，絶対値最大の固有値をもとめよ．
		 * x0 = {1,1,…,1}
		 * epsilon = 1e-8
		 * 最大反復回数 N=2000
		 * 
		 * A = {
		 * 0,1/a,1/a,0
		 * 1/a,0,1/a,1/a
		 * 1/a,1/a,0,1/a
		 * 0,1/a,1/a,0
		 * }
		 * 
		 * a = 1,2,3,4;
		 * 
		 * 
		 */

		// 収束判定条件
		n = 4;
		epsilon = 1e-08;
		maxIteration = 2000;

		Matrix a = new Matrix(n);
		final Vector x0 = Vector.allNumber(n, 1); // 冪乗法の初期ベクトル

		for (int alpha = 1; alpha <= 4; alpha++) {
			a.symmetricBand(0.0, 1.0 / alpha, 1.0 / alpha);
			int iteration = SpectralRadius.getIterationByRayleigh(a, x0);
			double lambda = SpectralRadius.getSpectralRadiusByRayleigh(a, x0);
			System.out.printf("a = %d, N = %d, λ = %.8f%n", alpha, iteration, lambda);
		}

	}

	public double[][] d(double[][] a) {
		int n = a.length;
		double[][] d = new double[n][n];
		for (int i = 0; i < n; i++) {
			d[i][i] = a[i][i];
		}
		return d;
	}

	public double[][] l(double[][] a) {
		int n = a.length;
		double[][] l = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i < j) {
					l[i][j] = a[i][j];
				}
			}
		}
		return a;
	}

}