package gaussianElimination;

import myBLAS.Calculation;

public class GaussianElimination3 {

	// bAsterisk =
	// 1.450e+00 1.093e+00 8.845e-01 7.456e-01 6.456e-01

	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] xAsterisk = new double[n];
		double[] bAsterisk = new double[n];

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

		// bAsterisk の計算
		bAsterisk = Calculation.multiple(a, xAsterisk);

		// bAsterisk の表示
		System.out.println("bAsterisk = ");
		Calculation.printe(bAsterisk, 3);

	}
}
