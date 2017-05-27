package exerciseOfNewtonsMethod;

public class NewtonsMethod2RelativeError {

	public static void main(String[] args) {
		// 相対誤差10^(-10)以下の解を求めよ

		double x0 = -6; // 初期値(initial)
		double eps = 10E-10; // マシンイプシロン
		double x = x0; // 近似解(approximate) ← これの設定は??
		int count = 0; // 反復回数

		System.out.printf("初期値 = %.0f\n", x);

		do {
			x0 = x;
			x = x - f(x) / df(x);
			count++;
		} while (Math.abs(x0 - x) >= Math.abs(x) * eps);

		count--;

		System.out.printf("近似解 = %.10f\n", x);
		System.out.printf("反復回数 = %d\n", count);

	}

	public static double f(double x) {
		return Math.pow(Math.E, ((-x) / 2)) * Math.sin(x) - 5 * x;
	}

	public static double df(double x) {
		return (-0.5) * (Math.pow(Math.E, ((-x) / 2))) * Math.sin(x) + Math.pow(Math.E, ((-x) / 2)) * Math.cos(x) - 5;
	}
}
