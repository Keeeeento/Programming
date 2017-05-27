package exercise08;

public class Problem3_1 {

	public static void main(String[] args) {
		double x = 10.0;
		double epsilon = Math.pow(10, -10);

		for (int n = 1; n <= 100; n++) {
			if (x >= epsilon) {
				x = renew(x);
			} else {
				break;
			}
		}
		System.out.println(x);

		System.out.println("誤差は" + Math.abs(x - Math.sqrt(2)));

	}

	public static double f(double x) {
		return x * x - 2;
	}

	public static double df(double x) {
		return 2 * x;
	}

	public static double renew(double x) {
		x += -f(x) / df(x);
		return x;
	}

}
