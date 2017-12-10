package exerciseOfNewtonsMethod;

public class NewtonsMethod3ResidualError {
	public static void main(String[] args) {
		// 残差10^(-6)以下の解を求めよ

		double x = 6; // 初期値(initial)
		double eps = 10E-6; // マシンイプシロン
		int count = 0; // 反復回数

		System.out.printf("初期値 = %.0f\n", x);

		// do {
		// x = x - f(x) / df(x);
		// count++;
		// } while (Math.abs(f(x)) >= eps);
		while (Math.abs(f(x)) >= eps) {
			x = x - f(x) / df(x);
			count++;
		}

		System.out.printf("近似解 = %f\n", x);
		System.out.printf("反復回数 = %d\n", count);

	}

	public static double f(double x) {
		return Math.cos(2 * x) + 2 * (Math.sin(x)) + 1 / x;
	}

	public static double df(double x) {
		return -2 * (Math.sin(2 * x)) + 2 * (Math.cos(x)) - Math.pow(x, -2);
	}
}
