package exercise08;

public class Problem1_fx {

	public static void main(String[] args) {

		double x1 = 3.0;
		double x2 = 0.0;

		System.out.println("x = 3 の時の f(x) の値は " + f(x1));
		System.out.println("x = 0 の時の f(x) の値は " + f(x2));

		System.out.println("\t"); // 改行

		System.out.println("x = 0 の時の g(x) の値は " + g(x1));
		System.out.println("x = 0 の時の g(x) の値は " + g(x2));

	}

	public static double f(double x) {
		x = Math.pow(x, 3) - 9 * Math.pow(x, 2) + 23 * x - 15;
		return x;
	}

	public static double g(double x) {
		x = Math.exp(x) - 2;
		return x;
	}

}
