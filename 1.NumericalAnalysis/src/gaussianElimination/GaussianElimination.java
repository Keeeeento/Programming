package gaussianElimination;

public class GaussianElimination {
	public static void main(String[] args) {

		int n = 5; // 行列のサイズ
		double[][] a = new double[n][n];
		double[] x = new double[n];
		double[] b = new double[n];
		double alpha = 0; // 中間変数alpha

		for (int i = 1; i <= n; i++) { // 行列 A_{n,n} = a の作成
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = 1.0 / (i + j);
			}
		}

		for (int i = 0; i < n; i++) { // ベクトルbの作成
			b[i] = 1;
		}

		// 前進消去過程
		for (int k = 1; k < n; k++) {
			for (int i = k + 1; i <= n; i++) {
				alpha = a[i - 1][k - 1] / a[k - 1][k - 1]; // alphaの更新

				for (int j = k + 1; j <= n; j++) {
					a[i - 1][j - 1] += -alpha * a[k - 1][j - 1]; // A_{i,j}
																	// 成分の更新
				}
				b[i - 1] += -alpha * b[k - 1]; // b_i 成分の更新
			}
		}

		// 後退代入前にxにbを保存
		for(int i =0;i<n;i++){

				x[i] = b[i];

		}

		// 後退代入過程　xに上書き
		for (int k = n; k >= 1; k--) {
			for (int j = k + 1; j <= n; j++) {
				x[k - 1] += -a[k - 1][j - 1] * x[j - 1];
			}
			x[k - 1] /= a[k - 1][k - 1];

		}
		// x の表示
		System.out.println("x = ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%f ", x[i]);
		}

		System.out.println();

		// b の表示
		System.out.println("b = ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%f ", b[i]);
		}

		System.out.println(); // 改行

		// A の表示
		System.out.println("A = ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					a[i][j] = 0;
				}
				System.out.printf("%.10f ", a[i][j]);
			}
			System.out.println();
		}

	}
}
