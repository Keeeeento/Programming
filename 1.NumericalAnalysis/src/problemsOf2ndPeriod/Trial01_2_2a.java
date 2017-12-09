package problemsOf2ndPeriod;

public class Trial01_2_2a {
	public static void main(String[] args) {

		int n = 30;
		// System.out.println("a,relativeError,…");

		for (double a = 0.1; a < 4.2; a += 0.1) {
			System.out.printf("%.1e", a);
			double x = 0.6;

			// (1)
			float aFloat = (float) a;
			float xFloat = (float) x;

			for (int i = 0; i < n; i++) {
				if (i % 5 == 0) {
					// System.out.printf("x_%d = %f, %f\n", i, xFloat, x);
					System.out.printf(",%.2e", Math.abs(xFloat - x) / Math.abs(x));
				}
				xFloat *= aFloat * (1f - xFloat);
				x *= a * (1.0 - x);
			}
			System.out.println();
		}

	}
}