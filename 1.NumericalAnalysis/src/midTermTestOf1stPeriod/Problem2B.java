package midTermTestOf1stPeriod;

public class Problem2B {
	public static void main(String[] args) {
		double a = 1e-8;
		double b = 1.0;
		double c = 1e-5;
		double x1 = nizi1(a, b, c);
		double x2 = nizi2(a, b, c);

		// 1
		System.out.printf("x1 = %.10e\n", x1);
		System.out.printf("x2 = %.10e\n", x2);

		// 2
		System.out.printf("x1x2 = %.10e\n", x1 * x2);
		System.out.printf("c/a = %.10e\n", c / a);
	}

	// ax^2+bx+c=0
	public static double nizi1(double a, double b, double c) {
		return (-b - Math.sqrt(b * b - 4 * a * c)) / (2.0 * a);
	}

	public static double nizi2(double a, double b, double c) {
		return (-b + Math.sqrt(b * b - 4 * a * c)) / (2.0 * a);
	}
}
