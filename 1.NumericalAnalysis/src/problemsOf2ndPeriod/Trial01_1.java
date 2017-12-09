package problemsOf2ndPeriod;

public class Trial01_1 {
	public static void main(String[] args) {

		int n = 5000; // 加算回数

		// (1)
		float x1 = 0f;
		float exactX1 = 0.2f * n;
		for (int i = 0; i < n; i++) {
			x1 += 0.2f;
		}

		System.out.printf("x1 = %f\n", x1);
		System.out.printf("exactX1 = %f\n", exactX1);
		System.out.printf("absoluteError = %e\n", x1 - exactX1);
		System.out.printf("relativeError = %e\n", (x1 - exactX1) / exactX1);

		// (2)
		double x2 = 0;
		double exactX2 = 0.2 * n;
		for (int i = 0; i < n; i++) {
			x2 += 0.2;
		}

		System.out.printf("x2 = %e\n", x2);
		System.out.printf("exactX2 = %e\n", exactX2);
		System.out.printf("absoluteError = %e\n", x2 - exactX2);
		System.out.printf("relativeError = %e\n", (x2 - exactX2) / exactX2);

	}
}
