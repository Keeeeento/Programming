package inoko;

public class NewtonsMethod2RelativeError {

	public static void main(String[] args) {
		// 2問目
		double x0, eps, x, N, c;
		x0 = -6;
		eps = Math.pow(10, -10);
		x = 0;
		N = 0;
		c = -6;
		while (Math.abs(((x - x0) / x)) > eps) {
			x0 = c;
			N++;
			x = x0 - f(x0) / f_x(x0);
			if ((Math.abs((x - x0) / x)) < eps) {
				break;
			} else {
				c = x;
			}
		}
		System.out.println("反復" + N + "答え" + x);

	}

	public static double f(double x) {
		return Math.pow(Math.E, ((-x) / 2)) * Math.sin(x) - 5 * x;
	}

	public static double f_x(double x) {
		return (-0.5) * (Math.pow(Math.E, ((-x) / 2))) * Math.sin(x) + Math.pow(Math.E, ((-x) / 2)) * Math.cos(x) - 5;
	}
}
