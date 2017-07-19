package bisectionMethod;

public class BisectionMethod {
	static double epsilon = 1e-12;
	static int maxCountNumber = (int) (1e+06);

	public static void main(String[] args) {
		double min = 2.3;
		double max = 4.0;
		System.out.println(solve(min, max));

	}

	// 問題に合わせて設定
	public static double f(double x) {
		return Math.pow(Math.E, x) - 2 * x - 1;
	}

	// 区間[min,max]から検出
	public static double solve(double min, double max) {
		double a = 0.0;
		double b = 0.0;
		for (double i = min; i < max; i += 0.1) {
			if (f(i) < 0 || i != 0) {
				a = i;
				break;
			} else if (f(i) > 0 || i != 0) {
				b = i;
				break;
			}
		}
		System.out.println(a);
		System.out.println(b);
		double c = 0;
		for (int i = 0; i < maxCountNumber; i++) {
			c = (a + b) / 2.0;
			if (f(a) * f(c) > 0) {
				a = c;
			} else if (f(a) * f(c) < 0) {
				b = c;
			} else if (f(c) == 0) {
				break;
			} else if (Math.abs(b - a) / 2 >= epsilon) {
				c = Math.abs(b - a) / 2;
				break;
			}
		}
		return c;

	}

}
