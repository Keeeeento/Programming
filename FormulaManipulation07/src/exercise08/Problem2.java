package exercise08;

public class Problem2 {

	public static void main(String[] args) {
		double x = 10.0;
		double epsilon = Math.pow(10, -10);

		for (int n = 1; n <= 100; n++) {
			if (x >= epsilon) {
				x = renew(x);
			} else {
				break;
			}
			System.out.print(x + " ");
			System.out.println(n);
		}
		System.out.println(x);

		/*
		 * int n=1; while(n<=100 && x>epsilon){ x=renew(x); n++ }
		 */
	}

	public static double f(double x) {
		return x * x * x - 9.0 * x * x + 23.0 * x - 15.0;
	}

	public static double df(double x) {
		return 3 * x * x - 18 * x + 23;
	}

	public static double renew(double x) {
		return x - f(x) / df(x);
	}

}
