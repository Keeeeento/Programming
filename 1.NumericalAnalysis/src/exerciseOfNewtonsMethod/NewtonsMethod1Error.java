package exerciseOfNewtonsMethod;

public class NewtonsMethod1Error {

	public static void main(String[] args) {
		// 近似解を求めよ。但し初期値は自分で設定し、出力結果は「初期値・近似解・反復回数」とする
		// 解を小数点以下12桁まで求めよ
		// つまり誤差は10^(-12)である

		double x0 = 2; // 初期値(initial)
		double eps = 10E-12; // マシンイプシロン
		double x = x0; // 近似解(approximate)
		int count = 0; // 反復回数

		System.out.printf("初期値 = %.0f\n", x);

		do {
			x0 = x;
			x = x - f(x) / df(x);
			count++;

		} while (Math.abs(x0 - x) >= eps);

		count--;

		System.out.printf("近似解 = %.12f\n", x);
		System.out.printf("反復回数 = %d\n", count);

	}

	public static double f(double x) { // f(x)
		return Math.pow(Math.E, x) - 2 * x - 1;
	}

	public static double df(double x) { // f'(x)
		return Math.pow(Math.E, x) - 2;

	}
}
