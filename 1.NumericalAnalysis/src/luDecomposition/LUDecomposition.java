package luDecomposition;

import myBLAS.Calculation;

public class LUDecomposition {
	public static void main(String[] args) {
		int n = 7; // 行列のサイズ
		double[][] a = new double[n][n];
		double[][] l = new double[n][n];
		double[][] u = new double[n][n];
		double alpha = 0.0;

		double detA = 1.0;

		double[] b = { 1, 2, 3, 4, 5, 6, 7 };
		double[] x = new double[n];
		double[] y = new double[n];

		// 行列Aへ格納
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (Math.abs(i - j)) {
				case 0:
					a[i][j] = 2;
					break;
				case 1:
					a[i][j] = -1;
					break;
				// default:
				// a[i][j] = 0;
				}

			}
		}
		System.out.println("A = ");
		Calculation.printf(a, 0);

		// (1)
		// 前進消去過程（並行して行列Lの作成）
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				a[i][k] = alpha;
				for (int j = k + 1; j < n; j++) {
					a[i][j] -= alpha * a[k][j];
				}
			}
		}

		// Calculation.printe(Calculation.multiple(a, l), 3);
		System.out.println("A = ");
		Calculation.printe(a, 3);

		// 行列Lの完成
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					l[i][j] = a[i][j];
				} else if (i == j) {
					l[i][j] = 1;
				}
			}
		}
		System.out.println("L = ");
		Calculation.printe(l, 3);

		// 行列Uの完成
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= j) {
					u[i][j] = a[i][j];
				}
			}
		}
		System.out.println("U = ");
		Calculation.printe(u, 3);

		// (2)
		// detA = detL.detU = detU の計算
		for (int i = 0; i < n; i++) {
			detA *= u[i][i];

		}
		System.out.println("detA = " + detA);

		// (3)
		// Ly = b (bがyとなる)
		for (int k = 0; k < n; k++) {
			for (int j = 0; j <= k; j++) {
				b[k] -= l[k][j] * b[j];
			}
		}

		// Ux = y
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				b[k] += -u[k][j] * b[j];
			}
			b[k] /= u[k][k];

		}
		System.out.println("x = ");
		Calculation.printe(b, 3);
	}
}
