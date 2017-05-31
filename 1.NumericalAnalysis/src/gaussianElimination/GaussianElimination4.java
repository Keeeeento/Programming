package gaussianElimination;

public class GaussianElimination4 {
	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] xAsterisk = new double[n];
		double[] bAsterisk = new double[n];
		double[] bDelta = new double[n];
		double alpha = 0.0;

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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bAsterisk[i] += a[i][j] * xAsterisk[j];
			}
		}

		// ベクトルbDelta の作成
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				bDelta[i] = 10e-2 * bAsterisk[i];
			} else {
				bDelta[i] = 0.0;
			}
		}

		// 誤差を含めたベクトルbAsteriskの更新
		for (int i = 0; i < n; i++) {
			bAsterisk[i] += bDelta[i];
		}

		// 前進消去過程
		for (int k = 1; k < n; k++) {
			for (int i = k + 1; i <= n; i++) {
				alpha = a[i - 1][k - 1] / a[k - 1][k - 1]; // alphaの更新

				for (int j = k + 1; j <= n; j++) {
					a[i - 1][j - 1] += -alpha * a[k - 1][j - 1]; // A_{i,j}
																	// 成分の更新
				}
				bAsterisk[i - 1] += -alpha * bAsterisk[k - 1]; // b_i 成分の更新
			}
		}

		// 後退代入過程
		double sum = 0;
		// xAsterisk[n - 1] = bAsterisk[n - 1] / a[n - 1][n - 1]; // n番目の場合(x_n)
		for (int k = n; k >= 1; k--) {
			for (int j = k + 1; j <= n; j++) {
				sum += a[k - 1][j - 1] * xAsterisk[j - 1];
			}
			xAsterisk[k - 1] = (bAsterisk[k - 1] - sum) / a[k - 1][k - 1];

		}

		System.out.println("xAsterisk[0] = " + xAsterisk[0]);

	}
}
