package problemsOf1stPeriod;

import myBLAS.Calculation;

public class Prob01_4 {
	// 3.0000000000 4.4142135624 5.7320508076
	// 4.4142135624 6.0000000000 7.4494897428
	// 5.7320508076 7.4494897428 9.0000000000
	public static void main(String[] args) {
		int n = 3;
		double[][] a = new double[n][n];
		double[][] b = new double[n][n];

		// 行列a,bに値を格納
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i - 1][j - 1] = i + j;
				b[i - 1][j - 1] = Math.sqrt(i * j);
			}
		}
		// 表示
		Calculation.print(Calculation.add(a, b));

	}
}
