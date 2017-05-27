package sample08;

public class Sampling {

	public static void main(String[] args) {

		double x = 0.0;
		double h = 0.125;

		while (x <= 6) {
			System.out.printf("%f,%f%n", x, f(x));
			x += h;
		}
	}

	public static double f(double x) {
		x = x * x * x - 9.0 * x * x + 23.0 * x - 15.0;
		return x;
	}
}
