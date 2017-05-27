package problems;

public class Prob01_4 {
	// 3.0 4.414213562373095 5.732050807568877
	// 4.414213562373095 6.0 7.449489742783178
	// 5.732050807568877 7.449489742783178 9.0
	public static void main(String[] args) {

		int n = 3;
		double[][] A = new double[n][n];
		double[][] B = new double[n][n];

		double[][] Ans = new double[n][n];

		// 行列A,Bに値を格納
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = i + 1 + j + 1;
				B[i][j] = Math.sqrt((i + 1) * (j + 1));
			}

		}
		// 行列Ansに値を格納
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Ans[i][j] = A[i][j] + B[i][j];
			}

		}

		// 表示
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(Ans[i][j]+"\t");
			}
			System.out.println();

		}

	}
}
