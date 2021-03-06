package problemsOf2ndPeriod;

public class Trial01_2_1LogisticMap {
	public static void main(String[] args) {

		// x_{n+1} = a x_{n} (1 - x_{n})

		int n = 30;

		double a = 3.8;
		double x = 0.6;

		// (1)
		float a1 = (float) a;
		float x1 = (float) x;

		System.out.println("float, double");
		for (int i = 0; i <= n; i++) {
			if (i % 5 == 0) {
				System.out.printf("x_%d = %.6f, %.16f\n", i, x1, x);
				System.out.printf("relativeError = %e\n", (x1 - x) / x);
			}
			x1 *= a1 * (1f - x1);
			x *= a * (1.0 - x);
		}

	}
}