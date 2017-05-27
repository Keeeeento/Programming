package exercise08;

public class Problem2_ans {

	public static void main(String[] args) {
		double x = 10.0; // 初期値
		double eps = 1.0E-10; // 許容誤差
		int kMax = 100; // 最大反復回数
		int k = 0; // 反復回数

		// 繰り返し（ニュートン法）
		while (Math.abs(f(x)) >= eps) {
			x = x - f(x) / df(x); // 解の更新
			k = k + 1; // 反復回数のカウント

			System.out.printf("%e%n", Math.abs(f(x)));

			if (k == kMax) {
				System.out.println("最大反復回数に到達しました．");
				break;
			}
		}

		System.out.println("反復回数" + k + "で得られた近似解は" + f(x));

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
