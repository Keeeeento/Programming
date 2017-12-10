package midTermTestOf1stPeriod;

public class Problem3BNweton {
	public static void main(String[] args) {

		double x = 5;
		double epsilon = 1e-10;
		int iter = 0;
		int maxIter = 50;

		double alpha = 2;

		while (Math.abs(f(x)) >= epsilon) {
			x -= f(x) / df(x);
			iter++;
			// System.out.println("反復回数は " + iter + " 回");
			System.out.printf("近似解は %.3e\n", x);
			// System.out.printf("誤差 %.3e\n", alpha - x);
			if (iter > maxIter) {
				System.out.println("収束しません");
				break;
			}
		}
	}

	static double f(double x) {
		return 2 * x * x * x - 7 * x * x + 4 * x + 4;
	}

	static double df(double x) {
		return 6 * x * x - 14 * x + 4;
	}
}
