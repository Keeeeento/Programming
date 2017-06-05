package luDecomposition;

import myBLAS.Calc;

public class LUDecomposition {
	public static void main(String[] args) {
		int n = 7; // 行列のサイズ
		double[][] a = new double[n][n];
		double[][] l = new double[n][n];
		double[][] u = new double[n][n];
		double alpha = 0.0;

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

		// 前進消去過程（並行して行列Lの作成）
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] += -alpha * a[k][j];
				}
				l[i][k] = alpha;
			}
		}

		// Lの完成
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					l[i][j] = 1;
				}
			}
		}
		
		
		
		Calc.printMat(Calc.multipleMat(a, l));
	}

}
