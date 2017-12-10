package myBLAS;

public class Jcalc {

	// LU分解
	public static double[][] LU(double alpha, double A[][]) {
		for (int k = 0; k < A.length; k++) {
			for (int i = k + 1; i < A.length; i++) {
				alpha = A[i][k] / A[k][k];
				for (int j = k + 1; j < A.length; j++) {
					A[i][j] = A[i][j] - alpha * A[k][j];
				}
				A[i][k] = alpha;
			}
		}
		return A;
	}

	// 前進代入
	public static double[] Forward_sub(double A[][], double b[]) {
		double y[] = new double[b.length];

		for (int k = 0; k < b.length; k++) {
			double sum = 0.0;
			for (int j = 0; j < b.length - 1; j++) {
				sum += A[k][j] * y[j];
			}
			y[k] = b[k] - sum;
		}
		return y;
	}

	// 後退代入
	public static double[] Backward_sub(double A[][], double b[]) {
		double x[] = new double[b.length];
		for (int k = b.length - 1; k >= 0; k--) {
			double sum = 0.0;
			for (int j = k + 1; j < b.length; j++) {
				sum += A[k][j] * x[j];
			}
			x[k] = (b[k] - sum) / A[k][k];
		}
		return x;
	}

	// aの逆行列を求めるメソッド、返すのは逆行列a^(-1)
	public static double[][] InvertMatrix(double a[][]) {

		double A_inv[][] = new double[a.length][a.length];// A_inv = a^(-1)

		// aをLU分解する a=LU 結果は行列Aに保存
		// Aの下三角行列はL 上三角行列はU
		double alpha = 0;
		double[][] A = LU(alpha,a);

		// aの逆行列A_invを計算するa*A_inv = LU*A_inv = E
		// すなわち L*U*A_inv[i] = E[i] = e_i
		// e_i[i] = 1 , e_i[j] = 0 (i!=j)
		// A_inv[i]はL*U*x = e_i の解 x である

		double y[] = new double[a.length];
		double x[] = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			// e_iを定義する
			double e[] = new double[a.length];
			e[i] = 1.0;

			// 前進代入
			y = Forward_sub(A, e);

			// 後退代入
			x = Backward_sub(A, y);

			// A_inv のi列目にxを代入
			for (int k = 0; k < a.length; k++) {
				A[k][i] = x[k];
			}
		}

		return A_inv;
	}

	public static void main(String[] args) {

		double[][] sample = { { 1, 3, 5 }, { 2, 4, 6 }, { 1, 5, 8 } };
		Calculation.print(Jcalc.InvertMatrix(sample));

	}




}
