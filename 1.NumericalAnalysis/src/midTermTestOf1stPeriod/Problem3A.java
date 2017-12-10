package midTermTestOf1stPeriod;

public class Problem3A {
	// ニュートン法
	// x_(k+1) = xk - f(xk)/df(xk)
	public static void main(String[] args) {

		double[] x = { -5, 5 };
		double[] alpha = { -1, 2 };
		double epsilon = 1e-10;

		for (int k = 0; k <= 1; k++) {
			int count = 0;

			System.out.printf("初期値　= %.0f\n", x[k]);

			do {
				x[k] -= f(x[k]) / df(x[k]);
				count++;
			} while (Math.abs(f(x[k])) > epsilon);

			// while (Math.abs(f(x[k])) > epsilon) {
			// x[k] -= f(x[k]) / df(x[k]);
			// count++;
			// }
			System.out.printf("近似解 = %.16e\n", x[k]);
			System.out.printf("反復回数 = %d\n", count);
			//
			// for (int i = (int) x[k] - 5; i <= x[k]; i++) {
			// double absoluteError = Math.abs(x[])
			// }
			System.out.println();
		}

	}

	public static double f(double x) {
		return x * x * x - 3 * x * x + 4;
	}

	public static double df(double x) {
		return 3 * x * x - 6 * x;
	}
}
