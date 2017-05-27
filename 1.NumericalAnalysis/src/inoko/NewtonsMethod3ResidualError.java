package inoko;

public class NewtonsMethod3ResidualError {
	public static void main(String[] args) {
		// 3問目
		double x0, eps, x, N;
		x0 = 6;
		eps = Math.pow(10, -6);
		x = 0;
		N = 0;
		while (Math.abs(f(x0)) >= eps) {
			N++;
			x = x0 - f(x0) / f_x(x0);
			x0 = x;
		}

		System.out.println("反復" + N + "答え" + x0);
	}

	public static double f(double x) {
		double fx1 = Math.cos(2 * x) + 2 * (Math.sin(x)) + 1 / x;
		return fx1;
	}

	public static double f_x(double x) {
		double fx2 = -2 * (Math.sin(2 * x)) + 2 * (Math.cos(x)) - Math.pow(x, -2);
		return fx2;
	}
}
