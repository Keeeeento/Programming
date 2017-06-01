package gaussianElimination;

public class GaussianElimination3 {
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


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bAsterisk[i] += a[i][j] * xAsterisk[j];
			}
		}



		// bAsterisk の表示
		System.out.println("b = ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%f ", bAsterisk[i]);
		}





	}
}
