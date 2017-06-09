package problems;

public class Prob01_3 {
	// n = 11
	// sum = 4.999972e-01
	public static void main(String[] args) {

		int n = 1;
		double sum = 0.0;
		while (a(n) > 1.0e-5) {
			n++;
		}
		System.out.println("n = " + n);
		for (int i = 1; i <= n; i++) {
			sum += a(i);
		}
		System.out.printf("sum = %.6e", sum);

	}

	public static double a(int n) {
		return 1.0 / Math.pow(3, n);
	}
}
