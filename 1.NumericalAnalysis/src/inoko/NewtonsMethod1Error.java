package inoko;

public class NewtonsMethod1Error {

	public static void main(String[] args) {
		// 1問目
		double x0, eps, x, N, c;
		x0 = 2;
		eps = Math.pow(10, -12);
		x = 0;
		N = 0;
		c = 2;
		while (Math.abs(x - x0) > eps) {
			x0 = c;
			N++;
			x = x0 - f(x0) / f_x(x0);
			if ((Math.abs(x - x0)) < eps) {
				break;
			} else {
				c = x;

			}
		}
		System.out.println("反復" + N + "答え" + x);

	}

	public static double f(double x) {
		return Math.pow(Math.E, x) - 2 * x - 1;
	}

	public static double f_x(double x) {
		return Math.pow(Math.E, x) - 2;

	}
}
