package gaussianElimination;

import myBLAS.Calculation;

public class GaussianElimination5 {
	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] xAsterisk = new double[n];
		double[] xAsterisk1 = new double[n];
		double[] bAsterisk = new double[n];
		double[] bAsterisk1 = new double[n];
		double[] bDelta = new double[n];

		// 行列 A_{n,n} = a の作成
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j);
			}
		}

		// ベクトルxAsteriskの作成
		for (int i = 0; i < n; i++) {
			xAsterisk[i] = 1;
		}

		// ベクトルbAsterisk の作成
		bAsterisk = Calculation.multiple(a, xAsterisk);

		// ベクトルbDelta の作成
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				bDelta[i] = 10e-3 * bAsterisk[i];
			} else {
				bDelta[i] = 0.0;
			}
		}

		// ベクトルbAsterisk1の作成
		bAsterisk1 = Calculation.add(bAsterisk, bDelta);

		// 前半の表示
		System.out.println("|Δb|∞ / |b*|∞ = ");
		System.out.println(Calculation.infinityNorm(bDelta) / Calculation.infinityNorm(bAsterisk));

		// ガウスの消去法
		xAsterisk1 = Calculation.gaussianElimination(a, bAsterisk1);

		// 後半の表示
		System.out.println("|x₁*-x*|∞ / |x*|∞ = ");
		System.out.println(Calculation.infinityNorm(Calculation.sub(xAsterisk1, xAsterisk)) / Calculation.infinityNorm(xAsterisk));

	}
}
